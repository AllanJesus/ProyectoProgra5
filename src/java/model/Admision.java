/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author kevin
 */
public class Admision {

    private int puntosAcciones;
    private float nota;
    private float promedio;
    String estado;
    private int usuarioId;
    private Date fecha;
    
    
   // para detalle de los datos del aspirante

     private int identificacion;
     int id_admision;
     private String nombre;
     private String apellido1;
     private String apellido2;
     private Date fechaNacimiento;
     private int edad;
     private String correo;
     
 
    public Admision() {

    }

    public Admision(int identificacion, String nombre, String apellido1, String apellido2,float promedio) {
        
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.promedio = promedio;
    }

    public Admision(int identificacion, String nombre, String apellido1, String apellido2, Date fechaNacimiento, int edad, String correo ,float promedio) {
        this.promedio = promedio;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.correo = correo;
    }

    public int getId_admision() {
        return id_admision;
    }

    public void setId_admision(int id_admision) {
        this.id_admision = id_admision;
    }
    
    public int getPuntosAcciones() {
        return puntosAcciones;
    }

    public void setPuntosAcciones(int puntosAcciones) {
        this.puntosAcciones = puntosAcciones;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    

    

}