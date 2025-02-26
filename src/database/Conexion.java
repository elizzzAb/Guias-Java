/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*---------------------------------
/**
 *
 * @author Elizabeth
 */


public class Conexion {
    private final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private final String URL="jdbc:mysql://localhost:3306/";  
    private final String DB = "puntoventa";
    private final String USER = "root";
    private final String PASSWORD = "1234"; 
    
    Connection connection;
    
    public static Conexion singleConnection;
    
    private Conexion(){
        this.connection = null;
    }
    
    public Connection conectar(){
        try{
           Class.forName(DB_DRIVER);
           this.connection = DriverManager.getConnection(
           URL + DB, USER, PASSWORD
           );
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
        return this.connection;
    }
    
    public void desconectar(){
        try{
            this.connection.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public synchronized static Conexion getInstance(){
        if(singleConnection == null){
            singleConnection = new Conexion();
        }
        return singleConnection;
    }
    
    
}

