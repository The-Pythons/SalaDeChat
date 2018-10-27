package cliente;

import java.io.IOException;

public class Msjentrantes  extends Thread {
	
	
	//private DataInputStream input;

	Msj msj;
	
	public Msjentrantes(Msj msj) throws IOException{
		this.msj = msj  ;
	}
	
	public void run(){
		while(true) {
			try {
				System.out.println(msj.recivirMsj());
				Thread.sleep(200);
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	}
}
