package server;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Sala {
	HashMap<String,Conexion> conexiones;
	ArrayList<Msj> msj;
	
	/*se debe cambiar para implementar una forma 
	 *  para avisar sobre los cambio de usuarios 
	 *  a los mismos
	 */
	
	public Sala(){
		conexiones = new  HashMap<String,Conexion>();
		msj = new ArrayList<Msj>();
	}
	
	public boolean nuevaConexion(Socket socket,String usuario) throws IOException{
		if(this.conexiones.containsKey(usuario))
			return false;
		Conexion c =new Conexion(usuario, socket,this);
		this.conexiones.put(usuario, c);
		return  true;
	}
	public synchronized  void desconexion(String c) {
		this.conexiones.remove(c);
	}
	public  synchronized void agregarMsj(Msj msj){
		this.msj.add(msj);
	}
	public synchronized Msj getLastMsj(){
		return this.msj.get(this.msj.size()-1);
	}
	public synchronized Msj getMsj(int index){
		return this.msj.get(index);
	}

}
