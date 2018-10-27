package servidorsimple;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class Conexion extends Thread{
	//Socket socket;
	
	boolean conectado;
	private DataInputStream input;
	private DataOutputStream output;
	private HashMap<String,Conexion> conexiones;
	private String usuario;
	
	
	public Conexion(String usuario, DataInputStream input, DataOutputStream output,
			HashMap<String, Conexion> conexiones){
		
		this.conectado = true;
		this.usuario=usuario;
		this.input = input;
		this.output = output;
		this.conexiones = conexiones;
		
	}

	public void run() {	
		String min;
		while(this.conectado){
				try {
					min = this.input.readUTF();
					System.out.println(min);
					if(min=="desconectar")
						conectado=false;
					for (Entry<String,Conexion> u : this.conexiones.entrySet()) {
						if(u.getKey()!=this.usuario)
							u.getValue().output.writeUTF(this.usuario+":"+min);
						}
					}
				catch (IOException e) {
					// TODO Auto-generated catch block
					this.conectado=false;
				}
		}
	}
	
	
	
	

}
