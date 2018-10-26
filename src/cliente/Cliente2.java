package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente2 {
	
	String servidor = "localhost";
	int puerto;
	
	public Cliente2(String s ,int p) throws InterruptedException, IOException{
		
		
				this.servidor=s;
				this.puerto=p;
				
				 Socket so = new Socket( this.servidor,this.puerto );
				DataInputStream input = new DataInputStream(so.getInputStream());
				DataOutputStream  output = new DataOutputStream(so.getOutputStream());
				output.writeUTF("ebis20");
				System.out.println(input.readUTF());
				System.out.println(input.readUTF());
				output.writeUTF("holaa");
				for (int i = 0; i < 2; i++) {
					System.out.println(input.readUTF());
				}
					
				output.writeUTF("desconectar");
				
		
	}

	
	
	
	public static void main(String[] args) throws IOException, InterruptedException{
		
		new Cliente2("localhost",10000);

	}

}
