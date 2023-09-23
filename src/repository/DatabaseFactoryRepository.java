/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Vuk
 */
public class DatabaseFactoryRepository {
    
    private Connection connection;
    private static DatabaseFactoryRepository instance;
    
    private DatabaseFactoryRepository(){
        
    }
    
    public static DatabaseFactoryRepository getInstance(){
        if(instance==null) instance = new DatabaseFactoryRepository();
        return instance;
    }
    
    public Connection getConnection() throws Exception{
         if (connection == null || connection.isClosed()) {
            Properties properties = new Properties();
            properties.load(new FileInputStream("config/dbconfig.properties"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        }
        return connection;
    }
}
