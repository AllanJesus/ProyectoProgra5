/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author kevin
 */
public class AccionAfirmativa {
    
    int puntos;
    String poblaciones;
    String documentos;
    String lugarPresentar;
    String descripcion;

    public AccionAfirmativa() {

    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getPoblaciones() {
        return poblaciones;
    }

    public void setPoblaciones(String poblaciones) {
        this.poblaciones = poblaciones;
    }

    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }

    public String getLugarPresentar() {
        return lugarPresentar;
    }

    public void setLugarPresentar(String lugarPresentar) {
        this.lugarPresentar = lugarPresentar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
