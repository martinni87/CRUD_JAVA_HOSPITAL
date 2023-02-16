package com.elcampico.ad_di_practica_8.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class DataExporter {
    
    public static boolean exportTableData(JTable table, File file) {
        try{
            TableModel model = table.getModel();
            FileWriter newFile = new FileWriter(file);
            
            //Imprimimos las cabeceras
            for (int i = 0; i < model.getColumnCount(); i++){
                newFile.write(model.getColumnName(i) + ";");//Excel reconoce ; como simbolo tabulador. En otros programas poner \t es suficiente
            }
            
            //Salto de línea
            newFile.write("\n");
            
            //Imprimimos el cuerpo de la tabla
            for (int i = 0; i < model.getRowCount(); i ++){
                for (int j = 0; j < model.getColumnCount(); j++){
                    //Imprimimos valor de celda en coordenada i,j. j avanza en columnas, e i avanza en filas.
                    //Para evitar un error de celda "null" sin valor, predefinimos un value = "No data"
                    String value = "No data";
                    //Si la celda contiene data, entonces se cambia el value y se guarda.
                    if (model.getValueAt(i,j) != null){
                        value = model.getValueAt(i,j).toString();
                    }
                    newFile.write(value + ";"); //Excel reconoce ; como simbolo tabulador. En otros programas poner \t es suficiente
                }
                //Salto de línea
                newFile.write("\n");
            }
            newFile.close();
            return true;
        }
        catch (IOException e) {
            System.err.println("Error en la exportación del archivo. Revise los datos: " + e.getMessage());
            return false;
        }
    }
}
