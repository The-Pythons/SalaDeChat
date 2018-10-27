package cliente;

import java.io.IOException;

import javax.swing.DefaultListModel;

public class Msjentrantes  extends Thread {
	
	
	//private DataInputStream input;

	Msj msj;
	DefaultListModel<String> list=null;
	
	public Msjentrantes(Msj msj) throws IOException{
		this.msj = msj  ;
	}
	public Msjentrantes(Msj msj,DefaultListModel<String> list ) throws IOException{
		this.msj = msj  ;
		this.list = list;
	}
	
	public void run(){
		String m;
		while(true) {
			try {
				m=msj.recivirMsj();
				System.out.println(m);
				if(list!=null)
					list.addElement(m);
				Thread.sleep(200);
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	}
}
