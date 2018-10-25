package server;


import java.io.IOException;
import java.net.Socket;

public class Conexion{
	Socket socket;
	Sala sala;
	MsjEntrantes msjentrantes;
	MsjSalientes msjsalientes;
	public Conexion(String usuario,Socket socket, Sala sala) throws IOException {
		this.socket=socket;
		this.sala=sala;
		msjentrantes= new MsjEntrantes(usuario,socket,sala);
		msjsalientes= new MsjSalientes(usuario,socket,sala);
		msjentrantes.start();
		System.out.println("nueva connexión");
		//msjsalientes.start();
		
		
	}
	
	
	
	
	
	

}
