package proyectoServidor;

import java.io.*;
import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Servidor implements Runnable {
	
	private ServerSocket serverSocket = null;
	private ServerThread usuarios[] = new ServerThread[50];
	private Thread thread = null;
	private int userCount = 0;
	Conexion c1 = null;
	
	public Servidor(int puerto){
		try{
			System.out.println("Conectando al puerto: "+ puerto +"...");
			serverSocket = new ServerSocket(puerto);
			System.out.println("Server encendido: " + serverSocket);
			c1 = new Conexion();
			start();
		}catch(IOException e){
			System.out.println("No se pudo establecer conexion con el puerto: " + puerto + " : " + e.getMessage());
		}
	}

	@Override
	public void run() {
		while(thread!=null){
			try{
				System.out.println("Estado: Esperando conexión...");
				addThread(serverSocket.accept());
			}catch(IOException e){
				System.out.println("Error en server.accept" + e.getMessage());
				stop();
			}		
		}
	}
	
	 public void start(){
		 if (thread == null){  
			 thread = new Thread(this); 
	         thread.start();
	     }
	 }
	  
	@SuppressWarnings("deprecation")
	public void stop(){
		if (thread != null){
			thread.stop();
	        thread = null;
	    }
	}
	
	private int findClient(int ID){
		for(int i=0; i<userCount; i++)
			if(usuarios[i].getID() == ID)
				return i;
		return -1;
	}
	
	public synchronized void manager(int ID, String entrada){
		if(entrada.equals("adios")){
			usuarios[findClient(ID)].send("adios");
			remove(ID);
		}else{
			for(int i=0; i<userCount; i++){
				usuarios[i].send(ID + ": " + entrada);
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public synchronized void remove(int ID){
		int pos = findClient(ID);
		if(pos >= 0 ){
			ServerThread toTerminate = usuarios[pos];
			System.out.println("Removiendo cliente thread "+ ID + "en posicion: " + pos);
			if(pos < userCount-1)
				for(int i=pos+1; i<userCount; i++)
					usuarios[i-1] = usuarios[i];
			userCount--;
			try{
				toTerminate.close();
			}catch(IOException e){
				System.out.println("Error al cerrar el thread: "+e);
			}
			toTerminate.stop();
		}
	}
	
	public void addThread(Socket cliente) throws IOException{

		if(userCount < usuarios.length){
			usuarios[userCount] = new ServerThread(this, cliente);	
			try{
				usuarios[userCount].open();
				usuarios[userCount].start();
				userCount++;
			}catch(IOException e){
				System.out.println("Error al abrir el thread: "+e);
			}
		}else{
			System.out.println("Se supero la capacidad para atender clientes, vuelva prontos");
		}
	}
	
	public synchronized Boolean verificarUsuario(String usuario, String contraseña) throws SQLException{
		Boolean condicion = false;

		c1.connectDatabase();

		Statement s = c1.connection.createStatement();
		ResultSet r;

		r = s.executeQuery("SELECT * FROM usuarios where usuario like'" + usuario + "' AND contraseña like'" + contraseña + "'");
		while(r.next()) {
			if(r.getString("usuario").equals(usuario) && r.getString("contraseña").equals(contraseña)){
				condicion = true;
			}else{
				condicion = false;
			}
		}
		r.close();
		s.close();
		notifyAll();
		return condicion;
	}

	
}
