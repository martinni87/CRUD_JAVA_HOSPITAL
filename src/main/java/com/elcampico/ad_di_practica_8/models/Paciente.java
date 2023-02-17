package com.elcampico.ad_di_practica_8.models;

import java.util.Date;

public class Paciente extends Persona {
    private long sip;
    private String fecha_nacimiento;
    private String localidad;
    private String calle;
    private String numero;
    private String puerta;
    private String piso;
    private int medico_id;
    private int enfermero_id;
    
    public Paciente(){
        super();
        sip = 0;
        fecha_nacimiento = "";
        localidad = "";
        calle = "";
        numero = "";
        puerta = "";
        piso = "";
        medico_id = 0;
        enfermero_id = 0;
    }
    
    /**
     * <h1>CONSTRUCTOR</h1>
     * @param id int autoincremental, valor único
     * @param sip long, valor único
     * @param dni String, valor único
     * @param nombre String
     * @param apellido1 String
     * @param apellido2 String
     * @param telefono String
     * @param sexo String
     * @param fecha_nacimiento String (por facilidad de trabajo)
     * @param localidad String (los valores de address pueden contener letras)
     * @param calle String (los valores de address pueden contener letras)
     * @param numero String (los valores de address pueden contener letras)
     * @param puerta String (los valores de address pueden contener letras)
     * @param piso String (los valores de address pueden contener letras)
     * @param medico_id int
     * @param enfermero_id int nullable
     * @param user_id int
     * @param created_at Date
     * @param updated_at Date
     */

    public Paciente(int id, long sip, String dni, String nombre, String apellido1,
                    String apellido2, String telefono, String sexo, String fecha_nacimiento,
                    String localidad, String calle, String numero, String puerta,
                    String piso, int medico_id, int enfermero_id, long user_id,
                    Date created_at, Date updated_at) {
        super(id, dni, nombre, apellido1, apellido2, telefono, sexo, user_id,
                created_at, updated_at);
        this.sip = sip;
        this.fecha_nacimiento = fecha_nacimiento;
        this.localidad = localidad;
        this.calle = calle;
        this.numero = numero;
        this.puerta = puerta;
        this.piso = piso;
        this.medico_id = medico_id;
        this.enfermero_id = enfermero_id;
    }
    
    //Getters
    public long getSip() {
        return sip;
    }
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public String getLocalidad() {
        return localidad;
    }
    public String getCalle() {
        return calle;
    }
    public String getNumero() {
        return numero;
    }
    public String getPuerta() {
        return puerta;
    }
    public String getPiso() {
        return piso;
    }
    public int getMedico_id() {
        return medico_id;
    }
    public int getEnfermero_id() {
        return enfermero_id;
    }
    
    //Setters
    public void setSip(long sip) {
        this.sip = sip;
    }
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }
    public void setPiso(String piso) {
        this.piso = piso;
    }
    public void setMedico_id(int medico_id) {
        this.medico_id = medico_id;
    }
    public void setEnfermero_id(int enfermero_id) {
        this.enfermero_id = enfermero_id;
    }
    
    //Printall

    @Override
    public String toString() {
        return "Paciente{" + "sip=" + sip + ", fecha_nacimiento=" + fecha_nacimiento + 
                ", localidad=" + localidad + ", calle=" + calle + ", numero=" + numero + 
                ", puerta=" + puerta + ", piso=" + piso + ", medico_id=" + medico_id + 
                ", enfermero_id=" + enfermero_id + '}';
    }
    
}
