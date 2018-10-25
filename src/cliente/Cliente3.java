package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente3 {
	
	String servidor = "localhost";
	int puerto;
	
	public Cliente3(String s ,int p) throws InterruptedException, IOException{
		
		
				this.servidor=s;
				this.puerto=p;
				
				 Socket so = new Socket( this.servidor,this.puerto );
				DataInputStream input = new DataInputStream(so.getInputStream());
				DataOutputStream  output = new DataOutputStream(so.getOutputStream());
				output.writeUTF("ebis20");
				System.out.println(input.readUTF());
				System.out.println(input.readUTF());
				output.writeUTF("holaa");
				while(true)
					System.out.println(input.readUTF());
					
				//output.writeUTF("desconectar");
				
				/*try {
					output.writeUTF("hello server");
				} catch (IOException e1) {
					System.out.println("Servidor no encontrado");;
				}
				
				for (int i = 0; i < 5; i++) {
					try {
						System.out.println(input.readUTF());
					} catch (IOException e) {
						System.out.println("desconectado del servidor");;
						
					}
					Thread.sleep(200);
				}
				output.writeUTF("hello server");*/
				
				//so.close();
		
	}

	
	
	
	public static void main(String[] args) throws IOException, InterruptedException{
		
		new Cliente3("localhost",10000);

	}

}
