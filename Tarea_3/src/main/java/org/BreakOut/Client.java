package org.BreakOut;

import java.net.*;
import java.io.*;

public class Client {
    static private Client client = null;
    private Client() { }
    static public Client getClient() {
        if (client == null) {
            client = new Client();
        }
        return client;
    }

    public java.lang.String client(java.lang.String message)  throws IOException{
        Socket s = new Socket("localhost", 8888);

        PrintWriter pr = new PrintWriter((s.getOutputStream()));
        pr.println(message);
        pr.flush();
        InputStreamReader in = new InputStreamReader((s.getInputStream()));
        BufferedReader bf = new BufferedReader(in);
        String str = bf.readLine();
        System.out.println("server: " + str);
        return str;
    }

}


