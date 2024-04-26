package com.codewithharman.chatapp.network;

import java.io.IOException;
import java.net.ServerSocket;

import java.net.Socket;
import java.util.ArrayList;

import com.codewithharman.chatapp.utils.ConfigReader;

public class Server {

	ServerSocket serverSocket;
	ArrayList<ServerWorker> workers = new ArrayList<>();

	public Server() throws IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		// creating instance of ServerScocket class
		serverSocket = new ServerSocket(PORT);
		System.out.println("Server Started and waiting for the clients...");
		handelClientRequest();

	}

	// Multiple Client HandShaking
	public void handelClientRequest() throws IOException {
		while (true) {
			Socket clientSocket = serverSocket.accept(); // HandShaking
			// Per Client per Thread
			ServerWorker serverWorker = new ServerWorker(clientSocket, this); // Creating a New Worker/Thread
			workers.add(serverWorker);
			serverWorker.start();
		}
	}

	public static void main(String[] args) throws IOException {
		new Server();
	}

}
