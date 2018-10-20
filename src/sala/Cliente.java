package sala;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	
	String servidor = "localhost";
	int puerto;
	
	public Cliente(String s ,int p) throws UnknownHostException , IOException{
		
		
				this.servidor=s;
				this.puerto=p;
				 Socket so = new Socket( this.servidor,this.puerto );
				DataInputStream input = new DataInputStream(so.getInputStream());
				DataOutputStream  output = new DataOutputStream(so.getOutputStream());
				output.writeUTF("hello server");
				System.out.println(input.readUTF());
				 
		
	}

	
	
	
	public static void main(String[] args) throws IOException{
		
		new Cliente("localhost",10001);

	}

}
