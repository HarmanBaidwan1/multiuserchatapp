package com.codewithharman.chatapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JTextArea;

// Client Data Read
public class ClientWorker extends Thread {
    private InputStream in;

    private JTextArea textArea;

    public ClientWorker(InputStream in, JTextArea textArea) { // read
        this.in = in;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while (true) { // open for infinite time to write the text
                line = br.readLine();
                // System.out.println("Line read.... " + line);
                textArea.setText(textArea.getText() + line + "\n"); // previous data/chat + new message
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
