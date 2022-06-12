package org.BreakOut;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class client {
    public static java.lang.String client(java.lang.String message)  throws IOException{
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

    public static java.lang.Void clientGameInfo(java.lang.String message)  throws IOException{
        Socket s = new Socket("localhost", 8888);

        PrintWriter pr = new PrintWriter((s.getOutputStream()));
        pr.println(message);
        pr.flush();
        InputStreamReader in = new InputStreamReader((s.getInputStream()));
        return null;
    }

}


