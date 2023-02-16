package com.elcampico.ad_di_practica_8.controllers;

import static com.elcampico.ad_di_practica_8.services.SQLConnection.getConnection;
import com.elcampico.ad_di_practica_8.models.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class ControladorMedicos {
    //Atributos de clase necesarios inicializamos a null
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private int q, id, deleteItem;
    
    public ControladorMedicos(){
        conn = getConnection();
    }
    
    //Métodos de ayuda    
    //Verificar que un registro existe previo a lanzar la vista de edición
    public Medico checkExistingReg(DefaultTableModel tablaRegistros, String numero_colegiado){
        Medico medico = null;
        try {
            String query = "SELECT * FROM medicos WHERE numero_colegiado = ?";
            String filtro = numero_colegiado;
        
            ps = conn.prepareStatement(query);
            ps.setString(1, filtro);
            rs = ps.executeQuery();

            if(rs.next()){
                medico = new Medico(
                        rs.getInt("id"), rs.getInt("numero_colegiado"), rs.getString("dni"),
                        rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),
                        rs.getString("telefono"),rs.getString("sexo"),rs.getInt("especialidad_id"),
                        rs.getInt("horario_id"),rs.getInt("user_id"),
                        rs.getDate("created_at"),rs.getDate("updated_at")
                );
            }
        }
        catch (SQLException e) {
            System.err.println("Error en la conexión a la base de datos: " + e.getMessage());
        }
        finally{
            return medico;
        }
    }
    
    //Método select para obtener resultados con o sin filtros
    //'SELECT * from medicos WHERE TRUE AND numero_colegiado = '%?%' AND nombre = '%?%' AND apellido1 = '%?%';
    public void doSelectSQL(DefaultTableModel tablaRegistros, ArrayList<String> arrayFiltros){   
        try{
            //Guardamos filtros en variables locales añadiendo % a cada lado.
            String filtro1 = "%" + arrayFiltros.get(0) + "%";
            String filtro2 = "%" + arrayFiltros.get(1) + "%";
            String filtro3 = "%" + arrayFiltros.get(2) + "%";
            
            //Creamos la query principal sin filtros
            String query = "SELECT * FROM medicos WHERE TRUE";
            
            //Añadimos filtros a la query
            query += " AND numero_colegiado LIKE ?";
            query += " AND nombre LIKE ?";
            query += " AND apellido1 LIKE ?";
            
            //Inicializamos preparedStatement: Preparamos la query con la conexión.
            ps = conn.prepareStatement(query);
            
            //Seteamos los filtros al preparedStatement
            ps.setString(1, filtro1);
            ps.setString(2, filtro2);
            ps.setString(3, filtro3); 
            
            //Llamamos al método makePetition para realizar la petición y pintar resultados en la tabla registro
            makePetition(ps, tablaRegistros);
        }
        catch (SQLException e){
            System.err.println("Error en la conexión a la base de datos: " + e.getMessage());

        }
    }
    
    //Método para hacer petición SELECT a la BD
    private void makePetition(PreparedStatement preparedStatement, DefaultTableModel tablaRegistros) throws SQLException{
        rs = preparedStatement.executeQuery();
            
        //Creamos objetos para registro de datos en la tabla
        ResultSetMetaData metaData = rs.getMetaData();
        q = metaData.getColumnCount();

        while(rs.next()){
            Medico medico = new Medico(
                    rs.getInt("id"), rs.getInt("numero_colegiado"), rs.getString("dni"),
                    rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),
                    rs.getString("telefono"),rs.getString("sexo"),rs.getInt("especialidad_id"),
                    rs.getInt("horario_id"),rs.getInt("user_id"),
                    rs.getDate("created_at"),rs.getDate("updated_at")
            );

            Vector data = new Vector();
            for (int i = 1; i <= q; i++){
                data.add(medico.getNumero_colegiado());
                data.add(medico.getNombre());
                data.add(medico.getApellido1());
                data.add(medico.getApellido2());
                data.add(medico.getTelefono());
                data.add(medico.getEspecialidad_id());
                data.add(medico.getHorario_id());
            }

            tablaRegistros.addRow(data);
        }
    }
    
    //Método para eliminar registro
    public void deleteData(Medico medico){
        try {
            //JOptionPane.showMessageDialog(null,medico.getId());
            String filtro = String.valueOf(medico.getId());
            String query = "DELETE FROM medicos WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, filtro);
            System.out.print(ps.toString());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Error en la conexión a la base de datos: " + e.getMessage());
        }
    }
    
    //Método para petición de edición de registro existente
    public void updateData(HashMap<String,String> filtros){
        try {

            String filtro1 = filtros.get("dni");
            String filtro2 = filtros.get("nombre");
            String filtro3 = filtros.get("apellido1");
            String filtro4 = filtros.get("apellido2");
            String filtro5 = filtros.get("telefono");
            String filtro6 = filtros.get("sexo");
            String filtro7 = filtros.get("especialidad_id");
            String filtro8 = filtros.get("horario_id");
            String filtro9 = filtros.get("id");
            
            String query =  "UPDATE medicos " +
                            "SET dni = ?, nombre = ?, apellido1 = ?, apellido2 = ?, telefono = ?, " +
                            "sexo = ?, especialidad_id = ?, horario_id = ?, updated_at = CURRENT_TIMESTAMP " +
                            "WHERE id = ?";
            
            ps = conn.prepareStatement(query);
            
            ps.setString(1, filtro1);
            ps.setString(2, filtro2);
            ps.setString(3, filtro3);
            ps.setString(4, filtro4);
            ps.setString(5, filtro5);
            ps.setString(6, filtro6);
            ps.setString(7, filtro7);
            ps.setString(8, filtro8);
            ps.setString(9, filtro9);

            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Error en la conexión a la base de datos: " + e.getMessage());
        }
    }
    
    //Método para petición de creación de nuevo registro
    public void createNew(HashMap<String,String> filtros){
        try{
            
            String filtro1 = filtros.get("numero_colegiado");
            String filtro2 = filtros.get("dni");
            String filtro3 = filtros.get("nombre");
            String filtro4 = filtros.get("apellido1");
            String filtro5 = filtros.get("apellido2");
            String filtro6 = filtros.get("telefono");
            String filtro7 = filtros.get("sexo");
            String filtro8 = filtros.get("especialidad_id");
            String filtro9 = filtros.get("horario_id");
            String filtro10 = filtros.get("user_id");
            
            String query =  "INSERT INTO medicos " +
                            "VALUES (?,?,?,?,?,?,?,?,?,?, " + 
                            "CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
            
            ps = conn.prepareStatement(query);
            
            ps.setString(1, filtro1);
            ps.setString(2, filtro2);
            ps.setString(3, filtro3);
            ps.setString(4, filtro4);
            ps.setString(5, filtro5);
            ps.setString(6, filtro6);
            ps.setString(7, filtro7);
            ps.setString(8, filtro8);
            ps.setString(9, filtro9);
            ps.setString(10, filtro10);

            ps.executeUpdate();
        }
        catch(SQLException e){
            System.err.println("Error en la conexión a la base de datos: " + e.getMessage());
        }
    }
}
