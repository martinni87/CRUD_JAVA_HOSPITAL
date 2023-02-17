package com.elcampico.ad_di_practica_8.models;

import java.util.Date;
import java.util.logging.Logger;

public class Persona extends Object {
    private int id;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String sexo;
    private long user_id;
    private Date created_at;
    private Date updated_at;

    //Constructor vacío
    public Persona(){
        this.id = 0;
        this.dni = "";
        this.nombre = "";
        this.apellido1 = "";
        this.apellido2 = "";
        this.telefono = "";
        this.sexo = "";
        this.user_id = 0;
        this.created_at = new Date();
        this.updated_at = new Date();
    }
    
    //Constructor con parámetros
    public Persona(int id, String dni, String nombre, String apellido1, String apellido2, String telefono, String sexo, long user_id, Date created_at, Date updated_at) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.sexo = sexo;
        this.user_id = user_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido1() {
        return apellido1;
    }
    public String getApellido2() {
        return apellido2;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getSexo() {
        return sexo;
    }
    public long getUser_id() {
        return user_id;
    }
    public Date getCreated_at() {
        return created_at;
    }
    public Date getUpdated_at() {
        return updated_at;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
    
    //Print all

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", telefono=" + telefono + ", sexo=" + sexo + ", user_id=" + user_id + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }
    
}
