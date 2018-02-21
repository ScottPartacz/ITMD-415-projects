package lab1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;

public class MathServerThread extends Thread
{

	protected Socket socket;
	protected ObjectOutputStream out;
	protected ObjectInputStream in;
	protected IntHolder clientNumber;
	protected int cID;
	
	public MathServerThread(Socket socket, ObjectOutputStream out, ObjectInputStream in, IntHolder clientNumber, int id)
	{
		this.clientNumber = clientNumber;
		this.cID = id;
		this.clientNumber.increment();
		this.socket = socket;
		this.out = out;
		this.in = in;
	}

	/***
	 * Called when a server-client connection is initiated.
	 */
	public void run()
	{
		System.out.printf("Client %d: '%s'\n", cID, this.toStringHP());
		
		Message serverMsg = new Message();
		Message clientMsg = new Message();
		Statement s = null;

		serverMsg.addF("Welcome to %s's and %s's MATH SERVER!", MathE.NAMED.s(), MathE.NAMEH.s());
		serverMsg.addF("You are client '%d'.", cID);
		serverMsg.add("");
		serverMsg.addF("Enter (%s) to quit.", MathE.QUIT.s());
		serverMsg.addF("Enter (%s) to get number of clients connected.", MathE.COUNT.s());
		serverMsg.addF("Valid operators: %s",
				Arrays.toString(MathE.VALID_OPS).replaceAll("[\\[\\]\\\"]", ""));
		
		try
		{
			// send object initially
			out.writeObject(serverMsg);
			out.flush();

			System.out.printf("[%s]: Wrote beginning message.\n", this.toStringHP());

			boolean keep = true;

			// while we should keep going
			while(keep)
			{
				s = null; // set math statement to null
				serverMsg = null; // set out response to null

				clientMsg = (Message) in.readObject(); // get response

				if(clientMsg.empty()) // if they want to quit
				{
					keep = false;
					System.out.printf("[%s]: Wants to quit.\n", this.toStringHP());
					break;
				}
				else if(clientMsg.flatten().equalsIgnoreCase(MathE.COUNT.s())) //if they want to get count of others
				{
					serverMsg = new Message(String.format("Your ID: '%d', there are '%d' other clients including you.", cID, clientNumber.getValue()));
				}
				else //else, assume it's math
				{
					try //try to parse their request of math...
					{
						s = new Statement(clientMsg.flatten());
					}
					catch(Exception e) //it's invalid
					{
						serverMsg = new Message(String.format("Invalid request '%s'.",clientMsg.flatten()));
						System.out.print("INVALID");
					}
					
					if(s != null) //if math was successfully parsed
					{
						serverMsg = new Message(String.format("'%s' = %.2f",clientMsg.flatten(), s.result())); // add formatted result
						serverMsg.result = s.result(); // add actual number result
						
						System.out.print(s.result());
					}
				}
				
				System.out.printf("[%s;%d]: {%d}:'",this.toStringHP(), cID, clientMsg.length()); //log what they send
				clientMsg.toString(System.out,";");
				System.out.print("' -> ");
				
				
				
				out.writeObject(serverMsg); //output whatever our message is
				out.flush();
				

				System.out.print("\n");

			}

		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.printf("Error reading/writing for client %s!\n", this.toStringHP());
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			this.clientNumber.decrement();
			
			try
			{
				socket.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}

//	/***
//	 * Called to initiate the server.
//	 * 
//	 * @param args
//	 */
//	public static void main(String[] args)
//	{
//		System.out.println("Server starting.");
//		ServerSocket server = null;
//		try
//		{
//			server = new ServerSocket(MathE.PORT.i()); // probably blocking
//
//			while(true) // blocking accept request FOREVER!!! :)
//			{
//				System.out.println("Waiting for client to connect...");
//				new MathServerThread(server.accept()); // blocking
//			}
//		}
//		catch(IOException ioe)
//		{
//			System.out.println("Error starting server.");
//			ioe.printStackTrace();
//		}
//
//	}

	/***
	 * Return current connection to a string as "hostname:port".
	 * 
	 * @return host:port String of current MathServer connection.<br>
	 *         Example: "localhost:23532"
	 */
	public String toStringHP()
	{
		return String.format("%s:%d", this.socket.getInetAddress().toString(), this.socket.getPort());
	}
}
