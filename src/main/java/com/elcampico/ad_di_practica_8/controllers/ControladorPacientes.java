package com.elcampico.ad_di_practica_8.controllers;

import static com.elcampico.ad_di_practica_8.services.SQLConnection.getConnection;
import com.elcampico.ad_di_practica_8.models.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorPacientes {
    //Atributos de clase necesarios inicializamos a null
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private int q, id, deleteItem;
    
    public ControladorPacientes(){
        conn = getConnection();
    }
    
    //Métodos de ayuda    
    //Verificar que un registro existe previo a lanzar la vista de edición
    public Paciente checkExistingReg(String sip){
        Paciente paciente = null;
        try {
            String query = "SELECT * FROM pacientes WHERE sip = ?";
            String filtro = sip;
        
            ps = conn.prepareStatement(query);
            ps.setString(1, filtro);
            rs = ps.executeQuery();

            if(rs.next()){
                paciente = new Paciente(
                        rs.getInt("id"), rs.getLong("sip"), rs.getString("dni"),
                        rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),
                        rs.getString("telefono"),rs.getString("sexo"),rs.getString("fecha_nacimiento"),
                        rs.getString("localidad"),rs.getString("calle"),rs.getString("numero"),
                        rs.getString("puerta"),rs.getString("piso"),rs.getInt("medico_id"),
                        rs.getInt("enfermero_id"), rs.getInt("user_id"),
                        rs.getDate("created_at"),rs.getDate("updated_at")
                );
            }
        }
        catch (SQLException e) {
            System.err.println("Error en la conexión a la base de datos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos: " + e.getMessage());
        }
        finally{
            return paciente;
        }
    }
    
    //Método para obtener el mayor user_id (al no asignarse de forma automática).
    public long greaterUserId(){
        try {
            long id = 0;
            String query = "SELECT id FROM pacientes ORDER BY id DESC LIMIT 0, 1";
            
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            if(rs.next()){
                id = rs.getInt("id");
            }
            return id;
        }
        catch (SQLException e) {
            System.err.println("Error en la conexión a la base de datos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos: " + e.getMessage());
            return 0;
        }
    }
    
    //Método select para obtener resultados con o sin filtros
    //'SELECT * from pacientes WHERE TRUE AND sip = '%?%' AND nombre = '%?%' AND apellido1 = '%?%';
    public void doSelectSQL(DefaultTableModel tablaRegistros, ArrayList<String> arrayFiltros){   
        try{
            //Guardamos filtros en variables locales añadiendo % a cada lado.
            String filtro1 = "%" + arrayFiltros.get(0) + "%";
            String filtro2 = "%" + arrayFiltros.get(1) + "%";
            String filtro3 = "%" + arrayFiltros.get(2) + "%";
            
            //Creamos la query principal sin filtros
            String query = "SELECT * FROM pacientes WHERE TRUE";
            
            //Añadimos filtros a la query
            query += " AND sip LIKE ?";
            query += " AND nombre LIKE ?";
            query += " AND apellido1 LIKE ?";
            query += " ORDER BY id DESC"; //VEMOS LOS ULTIMOS REGISTROS AL INICIO
            
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
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos: " + e.getMessage());

        }
    }
    
    //Método para hacer petición SELECT a la BD
    private void makePetition(PreparedStatement preparedStatement, DefaultTableModel tablaRegistros) throws SQLException{
        rs = preparedStatement.executeQuery();
            
        //Creamos objetos para registro de datos en la tabla
        ResultSetMetaData metaData = rs.getMetaData();
        q = metaData.getColumnCount();

        while(rs.next()){
            Paciente paciente = new Paciente(
                        rs.getInt("id"), rs.getLong("sip"), rs.getString("dni"),
                        rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),
                        rs.getString("telefono"),rs.getString("sexo"),rs.getString("fecha_nacimiento"),
                        rs.getString("localidad"),rs.getString("calle"),rs.getString("numero"),
                        rs.getString("puerta"),rs.getString("piso"),rs.getInt("medico_id"),
                        rs.getInt("enfermero_id"), rs.getInt("user_id"),
                        rs.getDate("created_at"),rs.getDate("updated_at")
            );

            Vector data = new Vector();
            for (int i = 1; i <= q; i++){
                data.add(paciente.getSip());
                data.add(paciente.getNombre());
                data.add(paciente.getApellido1());
                data.add(paciente.getApellido2());
                data.add(paciente.getTelefono());
                data.add(paciente.getLocalidad());
                data.add(paciente.getMedico_id());
            }

            tablaRegistros.addRow(data);
        }
    }
    
    //Método para eliminar registro
    public void deleteData(Paciente paciente){
        try {
            //JOptionPane.showMessageDialog(null,paciente.getId());
            String filtro = String.valueOf(paciente.getId());
            String query = "DELETE FROM pacientes WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, filtro);

            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Error en la conexión a la base de datos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos: " + e.getMessage());
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
            String filtro7 = filtros.get("fecha_nacimiento");
            String filtro8 = filtros.get("localidad");
            String filtro9 = filtros.get("calle");
            String filtro10 = filtros.get("numero");
            String filtro11 = filtros.get("puerta");
            String filtro12 = filtros.get("piso");
            String filtro13 = filtros.get("medico_id");
            //String filtro14 = filtros.get("enfermero_id");
            //String filtro15 = filtros.get("id");
            String filtro14 = filtros.get("id");
            
            /*
            String query =  "UPDATE pacientes " +
                            "SET dni = ?, nombre = ?, apellido1 = ?, apellido2 = ?, telefono = ?, " +
                            "sexo = ?, fecha_nacimiento = ?, localidad = ?, calle = ?, numero = ?, " + 
                            "puerta = ?, piso = ?, medico_id = ?, enfermero_id = ?, " +
                            "updated_at = CURRENT_TIMESTAMP WHERE id = ?";
            */
            
            String query =  "UPDATE pacientes " +
                            "SET dni = ?, nombre = ?, apellido1 = ?, apellido2 = ?, telefono = ?, " +
                            "sexo = ?, fecha_nacimiento = ?, localidad = ?, calle = ?, numero = ?, " + 
                            "puerta = ?, piso = ?, medico_id = ?, " +
                            "updated_at = CURRENT_TIMESTAMP WHERE id = ?";
            
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
            ps.setString(11, filtro11);
            ps.setString(12, filtro12);
            ps.setString(13, filtro13);
            ps.setString(14, filtro14);
           // ps.setString(15, filtro15);

            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Error en la conexión a la base de datos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos: " + e.getMessage());
        }
    }
    
    //Método para petición de creación de nuevo registro
    public void createNew(HashMap<String,String> filtros){
        try{
            
            String filtro1 = filtros.get("sip");
            String filtro2 = filtros.get("dni");
            String filtro3 = filtros.get("nombre");
            String filtro4 = filtros.get("apellido1");
            String filtro5 = filtros.get("apellido2");
            String filtro6 = filtros.get("telefono");
            String filtro7 = filtros.get("sexo");
            String filtro8 = filtros.get("fecha_nacimiento");
            String filtro9 = filtros.get("localidad");
            String filtro10 = filtros.get("calle");
            String filtro11 = filtros.get("numero");
            String filtro12 = filtros.get("puerta");
            String filtro13 = filtros.get("piso");
            String filtro14 = filtros.get("medico_id");
            //String filtro15 = filtros.get("enfermero_id");
            //String filtro16 = filtros.get("user_id");
            //String filtro15 = filtros.get("user_id");
            
            /*
            String query =  "INSERT INTO pacientes " + 
                            "(sip, dni, nombre, apellido1, apellido2, " +
                            "telefono, sexo, fecha_nacimiento, localidad, calle, " +
                            "numero, puerta, piso, medico_id, enfermero_id, user_id, " +
                            "created_at, updated_at) " + 
                            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
            */
            String query =  "INSERT INTO pacientes " + 
                            "(sip, dni, nombre, apellido1, apellido2, " +
                            "telefono, sexo, fecha_nacimiento, localidad, calle, " +
                            "numero, puerta, piso, medico_id, " +
                            "created_at, updated_at) " + 
                            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
                        
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
            ps.setString(11, filtro11);
            ps.setString(12, filtro12);
            ps.setString(13, filtro13);
            ps.setString(14, filtro14);
            //ps.setString(15,filtro15);
            //ps.setString(16, filtro16);


            ps.executeUpdate();
        }
        catch(SQLException e){
            System.err.println("Error en la conexión a la base de datos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos: " + e.getMessage());
        }
    }
}
