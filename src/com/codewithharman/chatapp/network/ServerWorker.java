package com.codewithharman.chatapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerWorker extends Thread {
    private Socket clientSocket;
    private InputStream in;
    private OutputStream out;
    private Server server;

    public ServerWorker(Socket clientSocket, Server server) throws IOException {
        this.server = server;
        this.clientSocket = clientSocket;
        in = clientSocket.getInputStream(); // Client Data Read
        out = clientSocket.getOutputStream(); // Client Data Write
        System.out.println("New Client Comes.");
    }

    @Override
    public void run() {
        // Read Data from the Client/user and Broadcast the data to all
        BufferedReader br = new BufferedReader(new InputStreamReader(in)); // read the one line data
        String line;
        try {
            while (true) {
                line = br.readLine();
                // System.out.println("Line read.... " + line);
                if (line.equalsIgnoreCase("quit")) {
                    break;
                }
                // broadcasting message to all users
                for (ServerWorker serverWorker : server.workers) {
                    line = line + "\n";
                    serverWorker.out.write(line.getBytes());
                }
            }
        } catch (IOException e) {
            System.out.println("I am executing");
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
                if (clientSocket != null) {
                    clientSocket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}