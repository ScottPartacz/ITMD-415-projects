import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static void main(String[] args) {
		try {
			String math = "-,+,*,/,%,";
			double answer = 0;
			String returnMessage;
			ArrayList<String> componets = new ArrayList<String>();
			String[] array = new String[2];
			int port = 2500;
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server Started and listening to the port 2500");
			Socket socket = serverSocket.accept();
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("Client connected");

			// Server is running always. This is done using this while(true)
			// loop
			do {
				// Reading the message from the client
				String equation = br.readLine();
				if(!equation.equals(""))
				{
				array = equation.split("[-+/%*]");

				
				for (String temp: array) {
					if(temp.equals("")){continue;}
				    componets.add(temp);
				}
				
				outerloop:
					for(int i = 0; i < equation.length(); i++)
					{
						char temp = equation.charAt(i);
						if(!equation.matches("[0-9+-/%*]+") || (equation.matches("[0-9]+") && !equation.matches("[+-/%*]+")) || (!equation.matches("[0-9]+") && equation.matches("[+-/%*]+")) || componets.size() > 2)
						{
							returnMessage = "Invaild expression";
							pw.println(returnMessage);
							componets.clear();
							answer = -1;
							break outerloop;
							
						}
						
						switch(math.indexOf(temp)) 
						{
							case 0:// Subtraction
								answer = Double.parseDouble(componets.get(0)) - Double.parseDouble(componets.get(1));
								break outerloop;
							case 2:// Addition
								answer = Double.parseDouble(componets.get(0)) + Double.parseDouble(componets.get(1));
								break outerloop;
							case 4:// Multiplication
								answer = Double.parseDouble(componets.get(0)) * Double.parseDouble(componets.get(1));
								break outerloop;
							case 6:// Division
								if(equation.charAt(++i) == '/') // Floor Division 
								{
									answer = Math.floor(Double.parseDouble(componets.get(0)) / Double.parseDouble(componets.get(1)));
								}
								else
								{
									answer = Double.parseDouble(componets.get(0)) / Double.parseDouble(componets.get(1));
								}
								
								break outerloop;
							case 8:// Modulo
								answer = Double.parseDouble(componets.get(0)) % Double.parseDouble(componets.get(1));
								break outerloop;
						}
					}
				if(!(answer == -1))
				{
				returnMessage = equation + " = " + answer;
			
				// Sending the response back to the client.
				pw.println(returnMessage);
				componets.clear();
				}
				else
				{
					answer = 0;
				}
				}
			} while (true);
		}
		 catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
		
	
