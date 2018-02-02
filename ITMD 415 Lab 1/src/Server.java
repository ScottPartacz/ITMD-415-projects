import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws IOException
	{
		int port = 2500;
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("Server Started and listening to the port 2500");
		while(true)
		{
		Socket socket = serverSocket.accept();
		System.out.println("Client Connected");
		new ServerThreads(socket).start();
		}
	}

}