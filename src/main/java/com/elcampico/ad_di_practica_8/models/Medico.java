package com.elcampico.ad_di_practica_8.models;

import java.util.Date;

public class Medico extends Persona {
    private int numero_colegiado;
    private int especialidad_id;
    private int horario_id;

    /**
     * <h1>CONSTRUCTOR</h1>
     * @param id: integer autoincremental, valor único
     * @param numero_colegiado: integer, valor único
     * @param dni: String, valor único
     * @param nombre: String
     * @param apellido1: String
     * @param apellido2: String
     * @param telefono: String
     * @param sexo: String
     * @param especialidad_id: integer, opción 1,2,3,4,5
     * @param horario_id: integer, opción 1,2,3,4
     * @param user_id: integer, primary key, valor non-nullable, valor único
     * @param created_at: formato fecha
     * @param updated_at: formato fecha
     */
    public Medico(int id, int numero_colegiado, String dni, String nombre,
                   String apellido1, String apellido2, String telefono,
                   String sexo, int especialidad_id, int horario_id, int user_id,
                   Date created_at, Date updated_at) {
        super(id, dni, nombre, apellido1, apellido2, telefono, sexo, user_id,
                created_at, updated_at);
        this.numero_colegiado = numero_colegiado;
        this.especialidad_id = especialidad_id;
        this.horario_id = horario_id;
    }

    //Getters
    public int getNumero_colegiado() {
        return numero_colegiado;
    }

    public int getEspecialidad_id() {
        return especialidad_id;
    }

    public int getHorario_id() {
        return horario_id;
    }

    //Setters
    public void setNumero_colegiado(int numero_colegiado) {
        this.numero_colegiado = numero_colegiado;
    }
    public void setEspecialidad_id(int especialidad_id) {
        this.especialidad_id = especialidad_id;
    }
    public void setHorario_id(int horario_id) {
        this.horario_id = horario_id;
    }
}
