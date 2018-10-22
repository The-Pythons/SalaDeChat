package server;

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
	
	public boolean nuevaConexion(Socket socket,String usuario){
		if(this.conexiones.containsKey(usuario))
			return false;
		this.conexiones.put(usuario, new Conexion(socket,this));
		return  true;
	}
	public void desconexion(String c) {
		this.conexiones.remove(c);
	}
	public void agregarMsj(Msj msj){
		this.msj.add(msj);
	}
	public Msj getMsj(){
		return this.msj.get(this.msj.size()-1);
	}

}
