import java.io.*;
import java.net.*;

public class EchoClient {

public static void main(String[] args) throws IOException {

String hostName = "192.168.236.132";
	int portNumber = 5566;
 	int num1=50;
        int num2=120;


try (
	Socket echoSocket = new Socket(hostName, portNumber);
	PrintWriter out =
	new PrintWriter(echoSocket.getOutputStream(), true);
	BufferedReader in =
	new BufferedReader(
	new InputStreamReader(echoSocket.getInputStream()))
) {
String userInput;

int numAleatorio=(int)Math.floor(Math.random()*(num1-num2)+num2);
                out.println(numAleatorio);
                System.out.println("echo: " + in.readLine());
          	

} catch (UnknownHostException e) {
System.err.println("Don't know about host " + hostName);
System.exit(1);
} catch (IOException e) {
System.err.println("Couldn't get I/O for the connection to " +
hostName);
System.exit(1);
}
}
}
