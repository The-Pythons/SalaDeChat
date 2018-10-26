package cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Msjentrantes  extends Thread {
	
	
	private DataInputStream input;

	public Msjentrantes(DataInputStream input) throws IOException{
		this.input =input ;
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
