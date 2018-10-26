package servidorsimple;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map.Entry;

import server.Msj;

public class Conexion extends Thread{
	Socket socket;
	boolean conectado;
	private DataInputStream input;
	private DataOutputStream output;
	private HashMap<String,Conexion> conexiones;
	private String usuario;
	public Conexion(String usuario,Socket socket, HashMap conexiones) throws IOException {
		this.socket = socket;
		this.conectado = true;
		this.usuario=usuario;
		this.input = new DataInputStream(socket.getInputStream());
		this.output = new DataOutputStream(socket.getOutputStream());
		this.conexiones = conexiones;
		
	}
	
	public void run() {	
		String min;
		while(this.conectado){
				try {
					min = this.input.readUTF();
					if(min=="desconectar")
						conectado=false;
				
					for (Entry<String,Conexion> u : this.conexiones.entrySet()) {
						new DataOutputStream(u.getValue().socket.getOutputStream()).writeUTF(this.usuario+":"+min);
						}
					}
				catch (IOException e) {
					// TODO Auto-generated catch block
					this.conectado=false;
				}
		}
	}
	
	
	
	

}
