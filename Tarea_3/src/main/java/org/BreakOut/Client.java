package org.BreakOut;

import java.net.*;
import java.io.*;

/**
 * Clase Client implementa Singleton
 */
public class Client {
    /**
     * client: objeto singleton
     */
    static private Client client = null;

    /**
     * Constructor privado de la clase Client
     */
    private Client() { }

    /**
     * Constructor publico del singleton
     * @return client, si existia con atelacion regresa el mismo client
     */
    static public Client getClient() {
        if (client == null) {
            client = new Client();
        }
        return client;
    }

    /**
     * Funcion para comunicarse con el servidor atraves de un mensaje, dependiendo del mensaje se dara la respuesta adecuada
     * @param message mensaje que se desea enviar al servidor
     * @return retorna la respuesta del servidor
     * @throws IOException debido al uso de sockets
     */
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


