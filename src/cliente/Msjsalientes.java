package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Msjsalientes  extends Thread {
	
	
	private DataInputStream input;
	private DataOutputStream output;

	public Msjsalientes(Socket socket) throws IOException{
		super("1");
		this.input = new  DataInputStream (socket.getInputStream());
		this.output =  new DataOutputStream (socket.getOutputStream()); 
		
	}
	
	public void run(){
		while(true) {
			try {
				this.output.writeUTF("hola");
				//System.out.println(this.input.readUTF());
				Thread.sleep(5000);
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	}
}
