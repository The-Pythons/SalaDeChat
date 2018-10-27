package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MsjEntrantes extends Thread{
	boolean conectado=true;
	DataInputStream input;
	DataOutputStream output;
	private Sala sala;
	public MsjEntrantes(String usuario,Socket socket, Sala sala) throws IOException {
		super(usuario);
		this.sala=sala;
		input = new DataInputStream(socket.getInputStream());
		output = new DataOutputStream(socket.getOutputStream());
	}
	public void run() {	
		String min;
		while(this.conectado){
			try {
				min = input.readUTF();
				if(min=="desconectar")
					conectado=false;
				sala.agregarMsj(new Msj(super.getName(),min));
				//output.writeUTF("msj recivido");
				Thread.sleep(100);
				
			} catch (IOException | InterruptedException e1) {
				conectado=false;
			}
		}
	}
}
