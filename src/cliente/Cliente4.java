package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente4 {
	
	String servidor = "localhost";
	int puerto;
	
	public Cliente4(String s ,int p) throws InterruptedException, IOException{
		
		
		
		this.servidor=s;
		this.puerto=p;
		
		Socket so = new Socket( this.servidor,this.puerto );
		DataInputStream input = new DataInputStream(so.getInputStream());
		DataOutputStream output = new DataOutputStream(so.getOutputStream());
		Msj m =new Msj(so);
		m.enviarMsj("ebis4");
		
		//out.writeUTF("ebis19");
		System.out.println(m.recivirMsj());
		System.out.println(m.recivirMsj());
		
		Msjentrantes me = new Msjentrantes(m);
		Msjsalientes ms = new Msjsalientes(m);
		me.start();
		ms.start();
		
	}

	
	
	
	public static void main(String[] args) throws IOException, InterruptedException{
		
		new Cliente4("localhost",10000);

	}

}
