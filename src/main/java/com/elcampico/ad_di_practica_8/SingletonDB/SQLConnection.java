package com.elcampico.ad_di_practica_8.SingletonDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class SQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital";
    private static final String UNAME = "root";
    private static final String PASSWD = "";
    private static final Connection conn = null;
    
    public static Connection getConnection(){
        Connection conn = null;
        
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL,UNAME,PASSWD);
            System.out.println("Conexión realizada con éxito.");
            
            /**
             * Importante.
             * A partir de esta línea se llama en los controladores a diferentes métodos
             * para realizar queries CREATE, SELECT, UPDATE, DELETE en mysql.
             * Se debe llamar directamente a este método static en los controladores
             */
            
        } catch (SQLException | ClassNotFoundException e){
            System.err.println("Error en la conexión a la base de datos: " + e.getMessage());
        }
        
        return conn;
    }
}

