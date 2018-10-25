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
	private Sala sala;
	private ServerSocket sc;
	public Server(int puerto) throws IOException, InterruptedException{
		this.puerto =puerto;
		sc = new ServerSocket(puerto);
		sala = new Sala();
		//so = new Socket();
		
		boolean cerrar=true;
		while(cerrar){
			so=sc.accept();
			DataInputStream input = new DataInputStream(so.getInputStream());
			DataOutputStream  output = new DataOutputStream(so.getOutputStream());
			output.writeUTF("hello cliente");
			String usuario = input.readUTF();
			output.writeUTF("Usuario logeado");
			sala.nuevaConexion(so, usuario);
		//Thread.sleep(500);
		}
	
		//entrada 
		//salida
		
		so.close();
	}	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		 
		new Server(10000);

	}

}
