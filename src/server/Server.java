package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	int puerto;
	ServerSocket server;
	private Socket so;
	private ServerSocket sc;
	public Server(int puerto) throws IOException{
		this.puerto =puerto;
		sc = new ServerSocket(puerto);
		so = new Socket();
		so=sc.accept();
		DataInputStream input = new DataInputStream(so.getInputStream());
		DataOutputStream  output = new DataOutputStream(so.getOutputStream());
		//entrada 
		System.out.println(input.readUTF());
		//salida
		output.writeUTF("hello cliente");
		
		so.close();
		
	}
	
	public static void main(String[] args) throws IOException {
		 
		new Server(10000);

	}

}
