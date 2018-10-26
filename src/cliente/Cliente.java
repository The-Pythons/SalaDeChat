package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	
	String servidor = "localhost";
	int puerto;
	
	public Cliente(String s ,int p) throws InterruptedException, IOException{
		
				this.servidor=s;
				this.puerto=p;
				
				Socket so = new Socket( this.servidor,this.puerto );
				DataInputStream in = new DataInputStream(so.getInputStream());
				DataOutputStream  out = new DataOutputStream(so.getOutputStream());
				out.writeUTF("ebis19");
				System.out.println(in.readUTF());
				System.out.println(in.readUTF());
				Msjentrantes me = new Msjentrantes(in);
				Msjsalientes ms = new Msjsalientes(in,out);
				me.start();
				ms.start();
		
	}

	
	
	
	public static void main(String[] args) throws IOException, InterruptedException{
		
		new Cliente("localhost",10000);

	}

}
