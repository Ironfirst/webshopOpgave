package com.example.demo.util;

import java.sql.Connection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private static String user;
    private static String password;
    private static String url;
    private static Connection conn;

    public static Connection getDatabaseConnection(){
        if(conn != null) return conn;
        Properties prop = new Properties();

        try{
            FileInputStream PropertyFile = new FileInputStream("src/main/resources/application.properties");
            prop.load(PropertyFile);
            user = prop.getProperty("db.user");
            password = prop.getProperty("db.password");
            url = prop.getProperty("db.url");
        }
        catch (FileNotFoundException e) {
            System.out.println("Filen kunne ikke findes");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Property kunne ikke loades");
            e.printStackTrace();
        }

        try{
            conn = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException throwables) {
            System.out.println("der er gået noget galt med at oprette forbindelse, check/ret connectionManager");
            throwables.printStackTrace();
        }
        return conn;

    }

}
