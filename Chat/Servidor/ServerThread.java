package proyectoServidor;

import java.io.*;
import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServerThread extends Thread{
	private Servidor server = null;
	private Socket socket = null;
	private int ID = -1;
	private DataInputStream  streamIn  =  null;
	private DataOutputStream streamOut = null;
	DataOutputStream salida;
	BufferedReader entrada;
	
	public ServerThread(Servidor _server, Socket _socket){
		super();
		server = _server;
		socket = _socket;
		ID = socket.getPort();
	}
	
	 @SuppressWarnings("deprecation")
	public void send(String msg)
	   {   try
	       {  streamOut.writeUTF(msg);
	          streamOut.flush();
	       }
	       catch(IOException ioe)
	       {  System.out.println(ID + " ERROR sending: " + ioe.getMessage());
	          server.remove(ID);
	          stop();
	       }
	   }
	 
	   public int getID()
	   {  return ID;
	   }
	   
	   @SuppressWarnings("deprecation")
	   public void run(){  
		   Boolean request = false;
		   Boolean condicion = false;
		   System.out.println("Server Thread " + ID + " running.");
		   
		   try {
			   do {
				   salida = new DataOutputStream(socket.getOutputStream());
				   entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				   String usuario = entrada.readLine();
				   String contraseña = entrada.readLine();

				   System.out.println(usuario);
				   System.out.println(contraseña);

				   request = server.verificarUsuario(usuario, contraseña);

				   if(request){
					   salida.writeBytes("0\n");
				   }else{
					   salida.writeBytes("1\n");
					   System.out.println("Usuario ingresado incorrecto");
				   }
			   }while(request);

		   } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
		   } catch (SQLException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
		   }
		    
		    while (true)
		      {  try
		         {  server.manager(ID, streamIn.readUTF());
		         }
		         catch(IOException ioe)
		         {  System.out.println(ID + " ERROR reading: " + ioe.getMessage());
		            server.remove(ID);
		            try {
						close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		         }
		      }
		   
	   }
	   public void open() throws IOException
	   {  streamIn = new DataInputStream(new 
	                        BufferedInputStream(socket.getInputStream()));
	      streamOut = new DataOutputStream(new
	                        BufferedOutputStream(socket.getOutputStream()));
	   }
	   public void close() throws IOException
	   {  if (socket != null)    socket.close();
	      if (streamIn != null)  streamIn.close();
	      if (streamOut != null) streamOut.close();
	   }

}
