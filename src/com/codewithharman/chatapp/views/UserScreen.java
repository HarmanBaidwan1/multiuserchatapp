package com.codewithharman.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.codewithharman.chatapp.dao.UserDAO;
import com.codewithharman.chatapp.dto.UserDTO;
import com.codewithharman.chatapp.utils.UserInfo;

public class UserScreen extends JFrame {
	private JTextField useridtxt;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		new UserScreen();
	}

	// creating userDAO object
	UserDAO userDAO = new UserDAO();

	private void login() {
		String userid = useridtxt.getText(); // reading values...
		char[] password = passwordField.getPassword();
		UserDTO userDTO = new UserDTO(userid, password);
		try {
			String message = "";
			if (userDAO.isLogin(userDTO)) {
				UserInfo.USER_NAME = userid;
				message = "Welcome " + userid;
				JOptionPane.showMessageDialog(this, message);
				setVisible(false);
				dispose(); // removing userScreen from memory
				DashBoard dashBoard = new DashBoard(message);
				dashBoard.setVisible(true);
			} else {
				message = "Invalid Userid or Password";
				JOptionPane.showMessageDialog(this, message);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		String userid = useridtxt.getText(); // reading values...
		char[] password = passwordField.getPassword();
		UserDTO userDTO = new UserDTO(userid, password);

		try {
			int result = userDAO.add(userDTO);
			if (result > 0) {
				JOptionPane.showMessageDialog(this, "Register Successfully");
			} else {
				JOptionPane.showMessageDialog(this, "Register Fail");
			}
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println("DB Issue ....");
			ex.printStackTrace();
		} catch (Exception e) { // for all other exception
			System.out.println("Some Generic exception Raised...");
			e.printStackTrace();
		}
	}

	// UserScreen just a class constructor here
	public UserScreen() {
		setResizable(false);
		setTitle("LOGIN");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);

		JLabel logintf = new JLabel("LOGIN");
		logintf.setFont(new Font("Lucida Bright", Font.BOLD, 28));
		logintf.setHorizontalAlignment(SwingConstants.CENTER);
		logintf.setBounds(196, 20, 177, 45);
		getContentPane().add(logintf);

		useridtxt = new JTextField();
		useridtxt.setBounds(325, 97, 219, 37);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);

		JLabel useridlbl = new JLabel("User Id");
		useridlbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		useridlbl.setBounds(142, 90, 93, 44);
		getContentPane().add(useridlbl);

		JLabel pwdlbl = new JLabel("Password");
		pwdlbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pwdlbl.setBounds(142, 168, 93, 45);
		getContentPane().add(pwdlbl);

		passwordField = new JPasswordField();
		passwordField.setBounds(325, 175, 219, 37);
		getContentPane().add(passwordField);

		// initializing login button and adding functionality
		JButton loginbt = new JButton("Login");
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		loginbt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginbt.setBounds(177, 272, 86, 29);
		getContentPane().add(loginbt);

		// initializing register button and adding event listener
		JButton registerbt = new JButton("Register");
		registerbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		registerbt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		registerbt.setBounds(297, 272, 93, 29);
		getContentPane().add(registerbt);
		setBackground(new Color(0, 140, 255));
		setBounds(0, 0, 647, 379);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
