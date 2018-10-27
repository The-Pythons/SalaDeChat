package cliente;


import java.io.IOException;
import java.net.Socket;

public class Cliente {
	
	String servidor = "localhost";
	int puerto;
	
	public Cliente(String s ,int p) throws InterruptedException, IOException{
		
				this.servidor=s;
				this.puerto=p;
				
				Socket so = new Socket( this.servidor,this.puerto );
				Msj m =new Msj(so);
				m.enviarMsj("ebis1");
				
				//out.writeUTF("ebis19");
				System.out.println(m.recivirMsj());
				System.out.println(m.recivirMsj());
				
				Msjentrantes me = new Msjentrantes(m);
				Msjsalientes ms = new Msjsalientes(m);
				me.start();
				ms.start();
				//so.close();
		
	}

	
	
	
	public static void main(String[] args) throws IOException, InterruptedException{
		
		new Cliente("localhost",10000);

	}

}
