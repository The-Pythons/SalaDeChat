package cliente;

import java.io.IOException;
import java.util.Scanner;

public class Msjsalientes  extends Thread {

	Msj m;
	public Msjsalientes(Msj m) throws IOException{
		super("1");
		this.m=m;
	}
	public void run(){
		Scanner mensajes = new Scanner(System.in);
		String  msj="hola";
		boolean dis=true;
		while(dis) {
			try {
				System.out.println(">>");
				msj=mensajes.nextLine();
				this.m.enviarMsj(msj);
				if(msj=="desconectar")
					dis=false;
			} catch (IOException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		
		mensajes.close();
	
	}
}
