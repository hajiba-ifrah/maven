package org.supmti.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
    //private static final String URL = "jdbc:mysql://localhost:3306/gestion_stock";
    private static final String URL = "jdbc:postgresql://localhost:5432/gestion_stock";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin"; // selon ton mot de passe MySQL

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
