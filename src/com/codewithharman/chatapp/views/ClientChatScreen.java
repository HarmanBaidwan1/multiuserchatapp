package com.codewithharman.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.codewithharman.chatapp.network.Client;
import com.codewithharman.chatapp.utils.UserInfo;

public class ClientChatScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private Client client;

	public static void main(String[] args) throws UnknownHostException, IOException {
		ClientChatScreen frame = new ClientChatScreen();
		frame.setVisible(true);

	}

	private void sendIt() {
		String message = textField.getText();
		try {
			client.sendMessage(UserInfo.USER_NAME + " - " + message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ClientChatScreen() throws UnknownHostException, IOException {
		textArea = new JTextArea();
		client = new Client(textArea);
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setType(Type.POPUP);
		setTitle("Chit Chat");
		setBackground(new Color(0, 191, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 10, 766, 444);
		contentPane.add(scrollPane);

		textArea.setBounds(10, 24, 734, 423);
		scrollPane.setViewportView(textArea);

		textField = new JTextField();
		textField.setBounds(20, 475, 621, 32);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Send Message");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendIt();
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 10));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setBounds(651, 477, 105, 25);
		contentPane.add(btnNewButton);
	}
}
