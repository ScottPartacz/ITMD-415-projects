import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String args[]) {
		try ( Socket socket = new Socket("localhost", 2500)){
		
			// Send the message to the server
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			Scanner scan = new Scanner(System.in);
			do{
			System.out.println("Enter your Equation:");
			String equation = scan.next();
			
			if(!equation.equalsIgnoreCase("exit"))
			{
			
			String sendMessage = equation + "\n";
			pw.println(sendMessage);

			// Get the return message from the server
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message = br.readLine();
			System.out.println("\n" + message + "\n");
			}
			else{
				scan.close();
				System.exit(0);
			}
			} while(true);
		} catch (Exception exception) {
			exception.printStackTrace();
		} 
	}
}