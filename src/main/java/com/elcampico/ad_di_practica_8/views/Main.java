package com.elcampico.ad_di_practica_8.views;

import com.elcampico.ad_di_practica_8.controllers.*;
import com.elcampico.ad_di_practica_8.models.Medico;
import static com.elcampico.ad_di_practica_8.services.DataExporter.exportTableData;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {

    ControladorMedicos controladorMedicos;
    DefaultTableModel tablaRegistros;
    
    public Main() {
        initComponents();
        this.setTitle("CRUD Java Hospital");
        controladorMedicos = new ControladorMedicos();
        tablaRegistros = (DefaultTableModel) tabla_medicos.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        tab_medicos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_medicos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_numColegiado_medicos = new javax.swing.JTextField();
        tf_nombre_medicos = new javax.swing.JTextField();
        tf_apellido1_medicos = new javax.swing.JTextField();
        btn_limpiar_medicos = new javax.swing.JButton();
        btn_nuevo_medicos = new javax.swing.JButton();
        btn_exportarCSV_medicos = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        btn_buscar_medicos = new javax.swing.JButton();
        btn_ayuda_medicos = new javax.swing.JToggleButton();
        btn_editar_medicos = new javax.swing.JButton();
        tab_pacientes = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tab_citas = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(745, 582));
        setSize(new java.awt.Dimension(745, 582));

        tabla_medicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num. Colegiado", "Nombre", "Apellido 1", "Apellido 2", "Telefono", "Especialidad", "Horario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_medicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_medicosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_medicos);
        if (tabla_medicos.getColumnModel().getColumnCount() > 0) {
            tabla_medicos.getColumnModel().getColumn(0).setHeaderValue("Nº Colegiado");
            tabla_medicos.getColumnModel().getColumn(1).setHeaderValue("Nombre");
            tabla_medicos.getColumnModel().getColumn(2).setHeaderValue("Apellido 1");
            tabla_medicos.getColumnModel().getColumn(3).setHeaderValue("Apellido 2");
            tabla_medicos.getColumnModel().getColumn(4).setHeaderValue("Teléfono");
            tabla_medicos.getColumnModel().getColumn(5).setHeaderValue("Especialidad");
            tabla_medicos.getColumnModel().getColumn(6).setHeaderValue("Horario");
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Filtros de búsqueda");

        jLabel4.setText("Nº Colegiado");

        jLabel5.setText("Nombre");

        jLabel6.setText("Apellido 1");

        btn_limpiar_medicos.setText("Limpiar");
        btn_limpiar_medicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiar_medicosActionPerformed(evt);
            }
        });

        btn_nuevo_medicos.setText("Nuevo");
        btn_nuevo_medicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo_medicosActionPerformed(evt);
            }
        });

        btn_exportarCSV_medicos.setText("Exportar a *.csv");
        btn_exportarCSV_medicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportarCSV_medicosActionPerformed(evt);
            }
        });

        btn_salir.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(255, 51, 51));
        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        btn_buscar_medicos.setText("Buscar");
        btn_buscar_medicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_medicosActionPerformed(evt);
            }
        });

        btn_ayuda_medicos.setText("Ayuda");
        btn_ayuda_medicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ayuda_medicosActionPerformed(evt);
            }
        });

        btn_editar_medicos.setText("Editar");
        btn_editar_medicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar_medicosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_numColegiado_medicos, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                            .addComponent(tf_nombre_medicos)
                            .addComponent(tf_apellido1_medicos))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(317, 317, 317)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_exportarCSV_medicos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_nuevo_medicos, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btn_ayuda_medicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_buscar_medicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_limpiar_medicos, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(btn_salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_editar_medicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_buscar_medicos, btn_limpiar_medicos});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_salir)
                        .addComponent(btn_ayuda_medicos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_limpiar_medicos)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(tf_numColegiado_medicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_buscar_medicos)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_nombre_medicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_nuevo_medicos)
                    .addComponent(btn_editar_medicos))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_apellido1_medicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exportarCSV_medicos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tab_medicosLayout = new javax.swing.GroupLayout(tab_medicos);
        tab_medicos.setLayout(tab_medicosLayout);
        tab_medicosLayout.setHorizontalGroup(
            tab_medicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_medicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_medicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        tab_medicosLayout.setVerticalGroup(
            tab_medicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_medicosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Médicos", tab_medicos);

        jLabel2.setText("Pacientes");

        javax.swing.GroupLayout tab_pacientesLayout = new javax.swing.GroupLayout(tab_pacientes);
        tab_pacientes.setLayout(tab_pacientesLayout);
        tab_pacientesLayout.setHorizontalGroup(
            tab_pacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_pacientesLayout.createSequentialGroup()
                .addGap(0, 329, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(0, 330, Short.MAX_VALUE))
        );
        tab_pacientesLayout.setVerticalGroup(
            tab_pacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_pacientesLayout.createSequentialGroup()
                .addGap(0, 254, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(0, 254, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pacientes", tab_pacientes);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Citas");

        javax.swing.GroupLayout tab_citasLayout = new javax.swing.GroupLayout(tab_citas);
        tab_citas.setLayout(tab_citasLayout);
        tab_citasLayout.setHorizontalGroup(
            tab_citasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_citasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        tab_citasLayout.setVerticalGroup(
            tab_citasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_citasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Citas", tab_citas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_limpiar_medicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiar_medicosActionPerformed
        tf_numColegiado_medicos.setText("");
        tf_nombre_medicos.setText("");
        tf_apellido1_medicos.setText("");
        tablaRegistros.setRowCount(0);
    }//GEN-LAST:event_btn_limpiar_medicosActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        JFrame frame = new JFrame ("Salir");
        if (JOptionPane.showConfirmDialog(frame, "¿Desea salir? Los datos no guardados se perderán","CRUD Java Hospital",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            System.out.println("Se sale del programa");
            System.exit(0);
        }
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_buscar_medicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_medicosActionPerformed
        //DefaultTableModel tablaRegistros = (DefaultTableModel) tabla_medicos.getModel();
        tablaRegistros.setRowCount(0);        
        
        ArrayList<String> filtros = new ArrayList<>();
        filtros.add(tf_numColegiado_medicos.getText());
        filtros.add(tf_nombre_medicos.getText());
        filtros.add(tf_apellido1_medicos.getText());
        
        controladorMedicos.doSelectSQL(tablaRegistros, filtros);
    }//GEN-LAST:event_btn_buscar_medicosActionPerformed

    private void btn_nuevo_medicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo_medicosActionPerformed
        /*String numero_colegiado = tf_numColegiado_medicos.getText();
        String nombre = tf_nombre_medicos.getText();
        String apellido1 = tf_apellido1_medicos.getText();
        new FormularioMedicos(numero_colegiado, nombre, apellido1).setVisible(true);*/
        this.setVisible(false);
        new FormularioMedicos().setVisible(true);
    }//GEN-LAST:event_btn_nuevo_medicosActionPerformed

    private void btn_exportarCSV_medicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportarCSV_medicosActionPerformed
        //Creamos una ventana para guardar un archivo con algunos parámetros de entrada.
        JFileChooser fc = new JFileChooser();
        fc.setDialogType(JFileChooser.SAVE_DIALOG);
        fc.setDialogTitle("Exportando en formato CSV");
        Date currentDate = new Date();
        String fileName = "tableExport_" + currentDate.toString() + ".csv";
        File file = new File (fileName);
        fc.setSelectedFile(file);
        fc.setFileFilter(new FileNameExtensionFilter("csv file","csv"));

        //Variable que almacena la selección del usuario en la ventana de diálogo.
        int userSelection = fc.showSaveDialog(this);
        
        //Verificación de la extensión (ya que el usuario puede cambiarla u omitirla
        if(userSelection == JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().toString();
            if (!filename .endsWith(".csv")){
                filename += ".csv";
            }
        }
        
        //Pasadas las verificaciones previas ya tenemos el archivo que se va a guardar.
        File fileToSave = fc.getSelectedFile();       
        
        //Pasamos el archivo y la tabla al método exportTableData y guardamos el resultado en un booleano
        boolean fileHasBeenSaved = exportTableData(tabla_medicos, fileToSave);
        
        //Si el booleano es true, significa que se ha guardado con éxito. Lo notificamos al usuario.
        if (fileHasBeenSaved){
            JOptionPane.showMessageDialog(this, "Se ha exportado correctamente", "Resultado de exportación", JOptionPane.INFORMATION_MESSAGE,null);
        }
    }//GEN-LAST:event_btn_exportarCSV_medicosActionPerformed

    private void tabla_medicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_medicosMouseClicked
        //Detectando doble click sobre una celda
        if (evt.getClickCount() == 2){
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
            int column = target.getSelectedColumn();
            JOptionPane.showMessageDialog(null, tabla_medicos.getValueAt(row, column)); // get the value of a row and column.

        }
    }//GEN-LAST:event_tabla_medicosMouseClicked

    private void btn_ayuda_medicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ayuda_medicosActionPerformed
        String ayuda = """
                       En el presente menú puede realizar las siguientes acciones:
                       1. Realizar búsquedas con o sin filtros activos.
                       2. Acceder al formulario de creación de registros.
                       3. Acceder al formulario de edición de registros (es necesario un Nº de colegiado).
                       4. Exportar la tabla mostrada a formato CSV.
                       5. Puede cerrar el programa pulsando en el botón salir."""; 
        JOptionPane.showMessageDialog(null, ayuda);
    }//GEN-LAST:event_btn_ayuda_medicosActionPerformed

    private void btn_editar_medicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar_medicosActionPerformed
        String value = "";
        String mensaje = "Escribe el Nº de colegiado del registro a editar";
        String titulo = "Edición de registros existentes.";
        
        value = JOptionPane.showInputDialog(this,mensaje,titulo,JOptionPane.QUESTION_MESSAGE);
 
        //Verificamos que el valor introducido devuelve resultados desde la BD
        //y guardamos null o el valor devuelto en la variable Medico.
        Medico medico = controladorMedicos.checkExistingReg(tablaRegistros,value);
        
        //Verificamos que podemos pasar ese valor a una nueva instancia de Formulario
        if (medico != null){
            FormularioMedicos nuevoFormulario = new FormularioMedicos();
            nuevoFormulario.setValores(medico);
            this.setVisible(false);
            nuevoFormulario.setVisible(true);
        }
        //Caso contrario, se informa de que es necesario pasar un valor correcto.
        else{
            JOptionPane.showMessageDialog(
                    this,"Nº de colegiado no válido. Es obligatorio para ir al formulario de edición",
                    titulo,JOptionPane.INFORMATION_MESSAGE,null);
        }
    }//GEN-LAST:event_btn_editar_medicosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_ayuda_medicos;
    private javax.swing.JButton btn_buscar_medicos;
    private javax.swing.JButton btn_editar_medicos;
    private javax.swing.JButton btn_exportarCSV_medicos;
    private javax.swing.JButton btn_limpiar_medicos;
    private javax.swing.JButton btn_nuevo_medicos;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel tab_citas;
    private javax.swing.JPanel tab_medicos;
    private javax.swing.JPanel tab_pacientes;
    private javax.swing.JTable tabla_medicos;
    private javax.swing.JTextField tf_apellido1_medicos;
    private javax.swing.JTextField tf_nombre_medicos;
    private javax.swing.JTextField tf_numColegiado_medicos;
    // End of variables declaration//GEN-END:variables
}
