import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


	public static void main(String[] args) {
		try {

			int port = 2500;
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server Started and listening to the port 2500");

			// Server is running always. This is done using this while(true)
			// loop
			while (true) {
				// Reading the message from the client
				Socket socket = serverSocket.accept();
				System.out.println("Client connected");
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String equation = br.readLine();
				System.out.println("got message");
				// Multiplying the number by 2 and forming the return message
				String returnMessage;
				try {
					int returnValue = 3 * 5;
					returnMessage = "3 * 5 =" + "\t" + String.valueOf(returnValue) + "\n";
				} finally {}

				// Sending the response back to the client.
				PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
				pw.println(returnMessage);
				System.out.println("Message sent to the client is " + returnMessage);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
