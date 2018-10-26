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
				DataInputStream input = new DataInputStream(so.getInputStream());
				DataOutputStream  output = new DataOutputStream(so.getOutputStream());
				output.writeUTF("ebis19");
				System.out.println(input.readUTF());
				System.out.println(input.readUTF());
				Msjentrantes me = new Msjentrantes(so);
				Msjsalientes ms = new Msjsalientes(so);
				me.start();
				ms.start();
		
	}

	
	
	
	public static void main(String[] args) throws IOException, InterruptedException{
		
		new Cliente("localhost",10000);

	}

}
