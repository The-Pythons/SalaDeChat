package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

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
				Scanner mensajes = new Scanner(System.in);
				output.writeUTF("desconectar");
				mensajes.close();
				so.close();
				
		
	}

	
	
	
	public static void main(String[] args) throws IOException, InterruptedException{
		
		new Cliente2("localhost",10000);

	}

}
