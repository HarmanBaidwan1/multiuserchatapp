package com.codewithharman.chatapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.codewithharman.chatapp.dto.Encryption;
import com.codewithharman.chatapp.dto.UserDTO;

//DAO -> Database Operations

// User CRUD opetations
public class UserDAO {
    public boolean isLogin(UserDTO userDTO) throws SQLException,
            ClassNotFoundException, Exception {
        Connection connection = null;
        PreparedStatement pstmt = null; // it has precompiled SQL statement.
        ResultSet rs = null;
        final String SQL = "SELECT userid FROM users WHERE userid=? AND password=?";

        try {
            connection = CommonDAO.createConnection();
            pstmt = connection.prepareStatement(SQL);
            pstmt.setString(1, userDTO.getUserid());
            String encryptedPass = Encryption.passwordEncryption(new String(userDTO.getPassword()));
            pstmt.setString(2, encryptedPass);
            rs = pstmt.executeQuery();
            return rs.next();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException, Exception {
        Connection connection = null;
        Statement stmt = null;
        try {
            connection = CommonDAO.createConnection(); // Connection Create
            stmt = connection.createStatement();
            int record = stmt
                    .executeUpdate("INSERT INTO users (userid, password) VALUES ('" + userDTO.getUserid() + "','"
                            + Encryption.passwordEncryption(new String(userDTO.getPassword())) + "') "); // Insert ,
                                                                                                         // Delete,
                                                                                                         // Update
            return record;
        } finally {
            stmt.close();
            if (stmt != null) {
                connection.close();
            }
        }
    }

}