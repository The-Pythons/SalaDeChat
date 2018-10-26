package servidorsimple;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
	
	private int puerto;
	private ServerSocket server;
	private Socket so;
	private ServerSocket sc;
	private HashMap<String,Conexion> conexiones;
	public Server(int puerto) throws IOException, InterruptedException{
		this.puerto =puerto;
		sc = new ServerSocket(puerto);
		conexiones = new HashMap<String,Conexion>();
		//so = new Socket();	
		//entrada 
		//salida
		
		
	}
	
	public void  iniciar() throws IOException {
		boolean cerrar=true;
		DataInputStream input;
		DataOutputStream  output;
		while(cerrar){
			try {
				so=sc.accept();
				input = new DataInputStream(so.getInputStream());
				output = new DataOutputStream(so.getOutputStream());
				
				output.writeUTF("hello cliente");
				String usuario = input.readUTF();
				output.writeUTF("Usuario logeado");
				this.conexiones.put(usuario,new Conexion(usuario,so,this.conexiones));
				this.conexiones.get(usuario).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				cerrar=false;
				so.close();
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Server s= new Server(10000);
		s.iniciar();

	}

}
