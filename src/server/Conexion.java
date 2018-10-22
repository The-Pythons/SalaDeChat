package server;

import java.net.Socket;

public class Conexion {
	Socket socket;
	Sala sala;
	int ultimomsjleido=-1;
	public Conexion(Socket socket, Sala sala) {
		this.socket=socket;
		this.sala=sala;
	}

}
