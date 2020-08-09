/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kevin
 */
public class DetalleAdmisionDB {
    
    Admision adminsion;
    AccionAfirmativa accion;
    int puntos;

    public DetalleAdmisionDB() {
    }

    public Admision getAdminsion() {
        return adminsion;
    }

    public void setAdminsion(Admision adminsion) {
        this.adminsion = adminsion;
    }

    public AccionAfirmativa getAccion() {
        return accion;
    }

    public void setAccion(AccionAfirmativa accion) {
        this.accion = accion;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
    
}
