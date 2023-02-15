package com.elcampico.ad_di_practica_8.models;

import java.util.Date;

public class Cita {
    private int id;
    private Date fecha;
    private int medico_id;
    private int enfermero_id;
    private Date created_at;
    private Date updated_at;

    //Constructor
    public Cita(int id, Date fecha, int medico_id, int enfermero_id, Date created_at, Date updated_at) {
        this.id = id;
        this.fecha = fecha;
        this.medico_id = medico_id;
        this.enfermero_id = enfermero_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    //Getters
    public int getId() {
        return id;
    }
    public Date getFecha() {
        return fecha;
    }
    public int getMedico_id() {
        return medico_id;
    }
    public int getEnfermero_id() {
        return enfermero_id;
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
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public void setMedico_id(int medico_id) {
        this.medico_id = medico_id;
    }
    public void setEnfermero_id(int enfermero_id) {
        this.enfermero_id = enfermero_id;
    }
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
