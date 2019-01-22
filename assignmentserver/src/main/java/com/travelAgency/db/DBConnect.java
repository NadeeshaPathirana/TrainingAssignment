package com.travelAgency.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static void main(String[] args){
        String host="jdbc:mysql://192.168.4.53/travelbox/TestDB";
        String user_name = "TRAINING";
        String password = "TRAINING";

        try {
            Connection con = DriverManager.getConnection(host, user_name,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
