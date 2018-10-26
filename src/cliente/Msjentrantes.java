package cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Msjentrantes  extends Thread {
	
	
	private DataInputStream input;

	public Msjentrantes(Socket socket) throws IOException{
		//this.input =input ;
		input= new  DataInputStream (socket.getInputStream());
	}
	
	public void run(){
		while(true) {
			try {
				System.out.println(input.readUTF());
				Thread.sleep(200);
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	}
}
