package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Msj {
	
	DataInputStream in;
	DataOutputStream  out;
	public Msj(Socket so) throws IOException{
		this.in = new DataInputStream(so.getInputStream());
		this.out = new DataOutputStream(so.getOutputStream());
	}
	
	public  String recivirMsj() throws IOException{
		return this.in.readUTF();
	}
	public   void enviarMsj(String s) throws IOException{
		this.out.writeUTF(s);
	}

}
