import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;


public class lame {

//public static void ejecutar(String args[]) {
	public void ejecutar(){
	try {
		Process p = Runtime.getRuntime().exec("free");
		p.waitFor();
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line=reader.readLine();

		File file = new File("log.out");
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);

		while (line != null){
			
			bw.write(line);
			line = reader.readLine();
			bw.write("\n");
		}
	
	bw.close();
	}
	catch(IOException e1) {}
	catch(InterruptedException e2) {}
	System.out.println("finished.");
	}

}
