import java.net.*;
import java.io.*;
 
public class EchoServer {
    public static void main(String[] args) throws IOException {
         
        try {
      ServerSocket server = new ServerSocket(5566);
      while (true) {
        
        Socket client = server.accept();
	lame l = new lame();
	l.ejecutar();
        miThread thread = new miThread(client);
        thread.start();

      }
    }
    catch (Exception e) {
      System.err.println("Exception caught:" + e);
    }
  }

	
}

