import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static Socket socket;

	public static void main(String[] args) {
		try {

			int port = 2500;
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server Started and listening to the port 2500");

			// Server is running always. This is done using this while(true)
			// loop
			while (true) {
				// Reading the message from the client
				socket = serverSocket.accept();
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String equation = br.readLine();
				System.out.println("Message received from client is " + equation);

				// Multiplying the number by 2 and forming the return message
				String returnMessage;
				try {
					int returnValue = 3 * 5;
					returnMessage = "3 * 5 =" + "\t" + String.valueOf(returnValue) + "\n";
				} finally {}

				// Sending the response back to the client.
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(osw);
				bw.write(returnMessage);
				System.out.println("Message sent to the client is " + returnMessage);
				bw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
			}
		}
	}
}
