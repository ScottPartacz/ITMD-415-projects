package lab1;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MathClient extends Thread
{
	private Message beginning = null;
	private Socket socket = null;
	private ObjectInputStream in = null;
	private ObjectOutputStream out = null;
	
	public MathClient(String host, int port)
	{
		this.connect(host, port);
	}
	
	public MathClient(Socket s)
	{
		this.socket = s;
	}
	
	/***
	 * 
	 * @return A message from the server.
	 */
	public Message recieve() throws ClassNotFoundException, IOException
	{
		return (Message) this.in.readObject();
	}
	
	/***
	 * Send a message to the server.
	 */
	public void send(Message m) throws IOException
	{
		this.out.writeObject(m);
		this.out.flush();
	}
	
	/***
	 * Send a quit message to the server.
	 * 
	 * Note: A quit message is one with zero length.
	 * @throws IOException 
	 */
	public void quit() throws IOException
	{
		this.send(new Message());
	}
	
	public void connect(String host, int port)
	{
		// if we already have a connection, don't connect
		if(socket != null && !socket.isClosed())
		{
			return;
		}

		System.out.printf("Connecting to '%s:%d'\n", host, port);

		try
		{
			socket = new Socket(host, port);
			System.out.printf("Connected to server at local port '%d'!\n", socket.getLocalPort());

			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());

			System.out.println("I/O Streams established.");
		}
		catch(IOException e)
		{
			System.out.println("Client Error: " + e.getMessage());
			e.printStackTrace();
		}
		
		try
		{
			beginning = this.recieve(); //this is to consume the first message from the server in case we are a bot
		}
		catch(ClassNotFoundException | IOException e)
		{
			e.printStackTrace();
		} 
	}
	
	public void disconnect() throws IOException
	{
		socket.close();
	}
	
	/***
	 * Initiate a command-line REPL that interfaces with a math server.
	 */
	public void repl()
	{
		Scanner keyboard = new Scanner(System.in);

		String input = "";

		Message serverMsg = beginning;
		Message clientMsg = new Message();

		boolean keepgoing = true;

		while(keepgoing == true)
		{
			try
			{

				if(serverMsg.length() == 0) // if server wants to disconnect or we want to quit
				{
					System.out.println("Server wishes to terminate connection.");
					keepgoing = false;
					break;
				}
				else if(!HLib.shouldContinue(input.toUpperCase(), MathE.QUIT.s().toUpperCase()))
				{
					// prepare our quit signal
					clientMsg = new Message();
					this.send(clientMsg);

					System.out.println("Goodbye!");
					keepgoing = false;
					break;
				}

				serverMsg.toString(System.out); // print that message

				// prepare message from keyboard
				System.out.print(" > ");
				clientMsg = new Message(input = keyboard.nextLine());

				out.writeObject(clientMsg); // send message
				out.flush();
				
				serverMsg = this.recieve(); // read message from server

			}
			catch(EOFException e)
			{
				System.out.println("Server's message terminated unexpectedly.");
				e.printStackTrace();
			}
			catch(IOException e)
			{
				System.out.println("I/O Exception occurred.");
				e.printStackTrace();
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}

		}

		// close open streams
		keyboard.close();
		
		try
		{
			socket.close();
		}
		catch(IOException e)
		{
			System.out.println("Closing socket failed.");
			e.printStackTrace();
		}


		System.out.println("Connection terminated."); // Signifies the end of the connection

	}

	/***
	 * 
	 * {@link #calculate(double, String, double)}
	 * @param opa Operand a.
	 * @param op  Operation op.
	 * @param opb Operand b.
	 */
	public double calculate(Double opa, String op, Double opb)
	{
		return this.calculate(opa.toString() + op + opb.toString());
	}
		
	/***
	 * Has a client ask a server for the result of operation 's'.
	 * @return The value of 's' as an operation
	 * 
	 * Example:
	 * c("2.0**3.0") -> magic server math -> 8.0
	 */
	public double calculate(String s)
	{
		Message query = new Message(s);
		Message response = null;

		System.out.printf("Sending %s -> ", query);
		
		try
		{
			out.writeObject(query); // send question
			out.flush();
			
			response = (Message) in.readObject(); // recieve response
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		System.out.printf("{%s}\n", response.toString());
		
		return (Double) response.result;
	}

	/***
	 * Command-line interface to server.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		MathClient replMathClient = new MathClient(MathE.HOST.s(), MathE.PORT.i());

		replMathClient.repl();
	}
}
