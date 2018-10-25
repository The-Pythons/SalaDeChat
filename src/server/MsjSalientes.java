package server;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MsjSalientes  extends Thread {
	
	Sala sala;
	int ultimomsjleido;
	DataInputStream input;
	DataInput in;
	DataOutputStream output; 
	public MsjSalientes(String usuario,Socket socket, Sala sala) throws IOException {
		super(usuario);
		this.sala=sala;
		ultimomsjleido=0;
		input = new DataInputStream(socket.getInputStream());
		output = new DataOutputStream(socket.getOutputStream());
	}
	
	public void run() {	
		boolean conectado=true;
		Msj mout=null;
		while(conectado){
				try {
					while(this.ultimomsjleido<this.sala.msj.size()) {
							mout=sala.getMsj(this.ultimomsjleido);
							this.ultimomsjleido++;
					if(mout.usuario!=super.getName())
							output.writeUTF(mout.usuario+":"+mout.msj);
					}
					Thread.sleep(100);
				} catch (IOException | InterruptedException e1) {
					conectado=false;
				}
				
		}
	}

}
