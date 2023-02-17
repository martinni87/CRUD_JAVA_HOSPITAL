package com.elcampico.ad_di_practica_8.views;

import com.elcampico.ad_di_practica_8.controllers.ControladorPacientes;
import com.elcampico.ad_di_practica_8.models.Paciente;
import com.elcampico.ad_di_practica_8.services.CharacterLimiter;
import java.awt.Color;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class FormularioPacientes extends javax.swing.JFrame {
    
    /**
     * Todo:
     * En el formulario de pacientes sucede un error con mysql a la hora de modificar datos
     * (creación, edición y eliminación), ya que genera un SQException por la
     * existencia de constraints en el contenido de la BD.
     * Queda pendientes solucionar el problema de los constraints, por lo demás
     * las conexiones funcionan adecuadamente.
     */
    
    
    
    //Flag que indica si el formulario es de creación (true) o de edición (false)
    boolean formularioNuevo = true;
    
    //Variables globales
    Paciente paciente;
    ControladorPacientes controladorPacientes;

    public FormularioPacientes() {
        initComponents();
        
        this.setTitle("Formulario pacientes");
        
        //Modo creación nuevo, seteamos visibilidad de botones nuevo y editar
        btn_nuevo.setVisible(false);
        btn_editar.setVisible(false);
        
        //Inicializamos un paciente vacío
        paciente = new Paciente();
        controladorPacientes = new ControladorPacientes();
        
        //Definimos cantidad de caracteres máximos (segun BD) para:
        tf_sip.setDocument(new CharacterLimiter(10));
        tf_dni.setDocument(new CharacterLimiter(9));
        tf_telefono.setDocument(new CharacterLimiter(15));
    }
    public void setFormForCreate(long id){
        this.paciente.setUser_id(id);
        tf_id.setText(id + "");
        tf_id.setEditable(false);
        tf_id.setBackground(Color.LIGHT_GRAY);
        btn_nuevo.setVisible(true);
        btn_borrar.setVisible(false);
        tf_fecha_nacimiento.setText("1987-06-05"); //Ejemplo para el usuario
    }
    
    public void setFormForEdit(Paciente paciente){
        //Inicializamos médico a nivel global
        this.paciente = paciente;
        
        //Cambiamos texto del botón limpiar a resetear para el modo de edición
        btn_limpiar.setText("Resetear");
        
        //Seteamos el flag de formularioNuevo a false, para indicar que estamos en modo edición
        formularioNuevo = false;
        
        //Modificamos elementos que se ven, bloqueados, y colores para el caso de modo edición
        btn_editar.setVisible(true);
        tf_sip.setEditable(false);
        tf_id.setEditable(false);
        tf_sip.setBackground(Color.LIGHT_GRAY);
        tf_id.setBackground(Color.LIGHT_GRAY);
        
        //Seteamos valores de campos a datos existentes en la BD
        tf_sip.setText(Long.toString(paciente.getSip()));
        tf_dni.setText(paciente.getDni());
        tf_nombre.setText(paciente.getNombre());
        tf_apellido1.setText(paciente.getApellido1());
        tf_apellido2.setText(paciente.getApellido2());
        tf_telefono.setText(paciente.getTelefono());
        tf_sexo.setSelectedIndex(paciente.getSexo().equals("hombre")?0:1);
        tf_fecha_nacimiento.setText(paciente.getFecha_nacimiento());
        tf_localidad.setText(paciente.getLocalidad());
        tf_calle.setText(paciente.getCalle());
        tf_numero.setText(paciente.getNumero());
        tf_puerta.setText(paciente.getPuerta());
        tf_piso.setText(paciente.getPiso());
        tf_medico_id.setText(paciente.getMedico_id() + "");
        tf_enfermero_id.setText(paciente.getEnfermero_id() + "");
        tf_id.setText(paciente.getId() + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tf_sip = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tf_dni = new javax.swing.JTextField();
        tf_nombre = new javax.swing.JTextField();
        tf_apellido1 = new javax.swing.JTextField();
        tf_apellido2 = new javax.swing.JTextField();
        tf_telefono = new javax.swing.JTextField();
        tf_id = new javax.swing.JTextField();
        tf_sexo = new javax.swing.JComboBox<>();
        tf_fecha_nacimiento = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tf_enfermero_id = new javax.swing.JTextField();
        tf_medico_id = new javax.swing.JTextField();
        tf_piso = new javax.swing.JTextField();
        tf_puerta = new javax.swing.JTextField();
        tf_numero = new javax.swing.JTextField();
        tf_calle = new javax.swing.JTextField();
        tf_localidad = new javax.swing.JTextField();
        btn_nuevo = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_borrar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(228, 228, 228));
        setMinimumSize(new java.awt.Dimension(750, 330));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formulario de pacientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 18))); // NOI18N
        jPanel1.setToolTipText("");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));

        jLabel1.setText("SIP");

        jLabel2.setText("DNI (8+ letra)");

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellido 1");

        jLabel5.setText("Apellido 2");

        jLabel6.setText("Teléfono");

        jLabel7.setText("Sexo");

        jLabel8.setText("Localidad");

        jLabel9.setText("Calle");

        jLabel10.setText("ID");

        tf_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "hombre", "mujer" }));

        tf_fecha_nacimiento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        jLabel11.setText("F. nacimiento");

        jLabel12.setText("Número");

        jLabel13.setText("Puerta");

        jLabel14.setText("Piso");

        jLabel15.setText("Medico ID");

        jLabel16.setText("Enfermero ID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tf_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_sip, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_apellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_apellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_fecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_localidad)
                            .addComponent(tf_calle)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_numero)
                            .addComponent(tf_puerta)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel10)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_piso)
                            .addComponent(tf_medico_id)
                            .addComponent(tf_enfermero_id)
                            .addComponent(tf_id))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_sip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(tf_localidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(tf_calle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel12)
                            .addComponent(tf_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel13)
                            .addComponent(tf_puerta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_apellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel14)
                            .addComponent(tf_piso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_apellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(tf_medico_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tf_enfermero_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_fecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(5, Short.MAX_VALUE))
        );

        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_borrar.setText("Borrar");
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });

        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btn_volver.setText("Volver");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_volver)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_borrar, btn_editar, btn_limpiar, btn_nuevo, btn_volver});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_nuevo)
                    .addComponent(btn_editar)
                    .addComponent(btn_borrar)
                    .addComponent(btn_volver)
                    .addComponent(btn_limpiar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        //Comprobación inicial. Es obligatorio rellenar todos los campos
        if (!checkCamposRellenos()){
            JOptionPane.showMessageDialog(
                    this,
                    "Los siguientes campos son obligatorios:\n" +
                    "SIP / DNI / Nombre / Apellido 1 / Apellido 2 / Teléfono\n" + 
                    "Fecha de nacimiento / Localidad / Médico ID / Enfermero ID",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE, null);
        }
        else{
            HashMap<String,String> filtros = new HashMap<>();

            int userResponse = JOptionPane.showConfirmDialog(this,
                    "Está a punto de crear un registro nuevo. ¿Desea continuar?",
                    "ALERTA",
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE, null);

            // valor 0 == YES, valor 1 == NO
            if (userResponse == 0){
                filtros.put("sip", tf_sip.getText());
                filtros.put("dni", tf_dni.getText());
                filtros.put("nombre", tf_nombre.getText());
                filtros.put("apellido1", tf_apellido1.getText());
                filtros.put("apellido2", tf_apellido2.getText());
                filtros.put("telefono", tf_telefono.getText());
                filtros.put("sexo", (String) tf_sexo.getSelectedItem());
                filtros.put("fecha_nacimiento",tf_fecha_nacimiento.getText());
                filtros.put("localidad", tf_localidad.getText());
                filtros.put("calle",tf_calle.getText());
                filtros.put("numero",tf_numero.getText());
                filtros.put("puerta",tf_puerta.getText());
                filtros.put("piso",tf_piso.getText());
                filtros.put("medico_id", tf_medico_id.getText());
                filtros.put("enfermero_id", tf_enfermero_id.getText());
                filtros.put("id", tf_id.getText());

                controladorPacientes.createNew(filtros);
                String operacion = "Se ha creado un nuevo registro con id: " + tf_id.getText();
                JOptionPane.showMessageDialog(this,operacion, "Registro actualizado", JOptionPane.INFORMATION_MESSAGE,null);
                new Main().setVisible(true);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this,"Operación cancelada", "Operación cancelada", JOptionPane.INFORMATION_MESSAGE,null);
            }
        }
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        int userResponse = JOptionPane.showConfirmDialog(this,
                "¿Desea volver a la ventana anterior?\nToda la información no guardada se perderá",
                "Aviso",
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, null);
        
        //System.out.println("User response:" + userResponse);
        // valor 0 == YES, valor 1 == NO
        if (userResponse == 0){
            new Main().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        //Recuperamos valores iniciales del objeto médico.
        tf_sip.setText(Long.toString(paciente.getSip()));
        tf_dni.setText(paciente.getDni());
        tf_nombre.setText(paciente.getNombre());
        tf_apellido1.setText(paciente.getApellido1());
        tf_apellido2.setText(paciente.getApellido2());
        tf_telefono.setText(paciente.getTelefono());
        tf_sexo.setSelectedIndex(paciente.getSexo().equals("hombre")?0:1);
        tf_fecha_nacimiento.setText(paciente.getFecha_nacimiento());
        tf_localidad.setText(paciente.getLocalidad());
        tf_calle.setText(paciente.getCalle());
        tf_numero.setText(paciente.getNumero());
        tf_puerta.setText(paciente.getPuerta());
        tf_piso.setText(paciente.getPiso());
        tf_medico_id.setText(paciente.getMedico_id() + "");
        tf_enfermero_id.setText(paciente.getEnfermero_id() + "");
        tf_id.setText(paciente.getId() + "");
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        int userResponse = JOptionPane.showConfirmDialog(this,
                "Está a punto de eliminar un registro. Esta operación no puede deshacerse ¿Desea continuar?",
                "ALERTA",
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE, null);
        // valor 0 == YES, valor 1 == NO
        if (userResponse == 0){
            controladorPacientes.deleteData(paciente);
            String operacion = "Se ha eliminado el registro con id: " + paciente.getId();
            JOptionPane.showMessageDialog(this,operacion, "Borrado ejecutado", JOptionPane.INFORMATION_MESSAGE,null);
            new Main().setVisible(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(this,"Operación cancelada", "Operación cancelada", JOptionPane.INFORMATION_MESSAGE,null);
        }
    }//GEN-LAST:event_btn_borrarActionPerformed

    private boolean checkCamposRellenos(){
        if (tf_sip.getText().isEmpty()){
            return false;
        }
        if (tf_dni.getText().isEmpty()){
            return false;
        }
        if (tf_nombre.getText().isEmpty()){
            return false;
        }
        if (tf_apellido1.getText().isEmpty()){
            return false;
        }
        if (tf_apellido2.getText().isEmpty()){
            return false;
        }
        if (tf_telefono.getText().isEmpty()){
            return false;
        }
        if (tf_fecha_nacimiento.getText().isEmpty()){
            return false;
        }
        if (tf_localidad.getText().isEmpty()){
            return false;
        }
        
        //Calle, numero, puerta y piso no los hacemos obligatorios
        
        
        if (tf_medico_id.getText().isEmpty()){
            return false;
        }
        //if (tf_enfermero_id.getText().isEmpty()){
        //    return false;
        //}
        if (tf_id.getText().isEmpty()){
            return false;
        }
        return true;
    }
    
    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        //Comprobación inicial. Es obligatorio rellenar todos los campos
        if (!checkCamposRellenos()){
            JOptionPane.showMessageDialog(
                    this,
                    "Los siguientes campos son obligatorios:\n" +
                    "SIP / DNI / Nombre / Apellido 1 / Apellido 2 / Teléfono\n" + 
                    "Fecha de nacimiento / Localidad / Médico ID",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE, null);
        }
        else{
            HashMap<String,String> filtros = new HashMap<>();

            int userResponse = JOptionPane.showConfirmDialog(this,
                    "Está a punto de editar un registro. ¿Desea continuar?",
                    "ALERTA",
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE, null);

            // valor 0 == YES, valor 1 == NO
            if (userResponse == 0){
                filtros.put("id",paciente.getId() + "");
                filtros.put("sip", tf_sip.getText());
                filtros.put("dni", tf_dni.getText());
                filtros.put("nombre", tf_nombre.getText());
                filtros.put("apellido1", tf_apellido1.getText());
                filtros.put("apellido2", tf_apellido2.getText());
                filtros.put("telefono", tf_telefono.getText());
                filtros.put("sexo", (String) tf_sexo.getSelectedItem());
                filtros.put("fecha_nacimiento",tf_fecha_nacimiento.getText());
                filtros.put("localidad", tf_localidad.getText());
                filtros.put("calle",tf_calle.getText());
                filtros.put("numero",tf_numero.getText());
                filtros.put("puerta",tf_puerta.getText());
                filtros.put("piso",tf_piso.getText());
                filtros.put("medico_id", tf_medico_id.getText());
                filtros.put("enfermero_id", tf_enfermero_id.getText());
                filtros.put("id", tf_id.getText());

                controladorPacientes.updateData(filtros);
                String operacion = "Se ha actualizado el registro con id: " + paciente.getId();
                JOptionPane.showMessageDialog(this,operacion, "Registro actualizado", JOptionPane.INFORMATION_MESSAGE,null);
                new Main().setVisible(true);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this,"Operación cancelada", "Operación cancelada", JOptionPane.INFORMATION_MESSAGE,null);
            }
        }
    }//GEN-LAST:event_btn_editarActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioPacientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_volver;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tf_apellido1;
    private javax.swing.JTextField tf_apellido2;
    private javax.swing.JTextField tf_calle;
    private javax.swing.JTextField tf_dni;
    private javax.swing.JTextField tf_enfermero_id;
    private javax.swing.JFormattedTextField tf_fecha_nacimiento;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_localidad;
    private javax.swing.JTextField tf_medico_id;
    private javax.swing.JTextField tf_nombre;
    private javax.swing.JTextField tf_numero;
    private javax.swing.JTextField tf_piso;
    private javax.swing.JTextField tf_puerta;
    private javax.swing.JComboBox<String> tf_sexo;
    private javax.swing.JTextField tf_sip;
    private javax.swing.JTextField tf_telefono;
    // End of variables declaration//GEN-END:variables
}
