package com.elcampico.ad_di_practica_8.SingletonDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital";
    private static final String UNAME = "root";
    private static final String PASSWD = "";
    private static final Connection conn = null;
    
    public static Connection getConnection(){
        Connection conn = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL,UNAME,PASSWD);
            System.out.println("Conexión realizada con éxito.");
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        
        return conn;
    }
    
    public static void selectAll(String tableName){
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs;
        
        conn = getConnection();
        
        try{
            ps = conn.prepareStatement("SELECT * FROM " + tableName);
            rs = ps.executeQuery();
            
            if(rs.next()){
                System.out.println("Nombre: " + rs.getString("nombre") + " con DNI: " + rs.getString("dni"));
            }
            else{
                System.out.println("No se han encontrado datos. Revisa la conexión.");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}

