package servidorsimple;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
	
	private ServerSocket server;
	private Socket so;
	private HashMap<String,Conexion> conexiones;
	public Server(int puerto) throws IOException, InterruptedException{
		server = new ServerSocket(puerto);
		conexiones = new HashMap<String,Conexion>();
	
	}
	
	public void  iniciar() throws IOException {
		boolean cerrar=true;
		DataInputStream input;
		DataOutputStream  output;
		while(cerrar){
			try {
				so=server.accept();
				input = new DataInputStream(so.getInputStream());
				output = new DataOutputStream(so.getOutputStream());
				
				output.writeUTF("hello cliente");
				String usuario = input.readUTF();
				output.writeUTF("Usuario logeado");
				this.conexiones.put(usuario,new Conexion(usuario,input,output,this.conexiones));
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
