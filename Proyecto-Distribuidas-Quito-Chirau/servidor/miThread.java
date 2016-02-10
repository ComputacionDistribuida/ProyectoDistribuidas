import java.io.*;
import java.net.*;
import java.lang.Thread;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class miThread extends Thread{
    Socket client;
     miThread (Socket client) {
        this.client = client;
     }
    public void run(){
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
      PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
      while (true) {
        String line = reader.readLine();
         System.out.println(line);
        Integer n = Integer.valueOf(line);
	writer.println(miThread.obtenerPalabras(n));
      }
    }
    catch (Exception e) {
      System.err.println("Exception caught: client disconnected.");
    }
    finally {
      try { client.close(); }
      catch (Exception e ){ ; }
    }
  
    }

	public static String obtenerPalabras(Integer n){
		String mensaje="";
		try {
		// Conexión
		Class.forName("org.sqlite.JDBC");
		Connection connection = DriverManager.getConnection("jdbc:sqlite:/home/lubuntu/Escritorio/java/bd.db");
		
		// Consulta
		PreparedStatement st = connection.prepareStatement("select * from palabras where numero=?");
		st.setInt(1, n);
		st.execute();
		ResultSet rs = st.getResultSet();
		while (rs.next()) {
			mensaje = rs.getString("palabras");
		}
		st.close();
		connection.close();
		}
		catch(Exception e){}
		return mensaje;
	}
}
