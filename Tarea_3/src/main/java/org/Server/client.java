import java.net.*;
import java.io.*;
import java.util.Scanner;

public class client {
    public static void main(String[] args)  throws IOException{
        Socket s = new Socket("localhost", 8888);

        while(true) {
            String txt;
            Scanner leer = new Scanner(System.in);
            System.out.println("Cliente: ");
            txt = leer.next();

            PrintWriter pr = new PrintWriter((s.getOutputStream()));
            pr.println(txt);
            pr.flush();

            InputStreamReader in = new InputStreamReader((s.getInputStream()));
            BufferedReader bf = new BufferedReader(in);

            String str = bf.readLine();
            System.out.println("server: " + str);

        }

    }
}
