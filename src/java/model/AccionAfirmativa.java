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
    int lugarPresentar;

    public AccionAfirmativa(int puntos, String poblaciones, String documentos, int lugarPresentar) {
        this.puntos = puntos;
        this.poblaciones = poblaciones;
        this.documentos = documentos;
        this.lugarPresentar = lugarPresentar;
    }
 

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

    public int getLugarPresentar() {
        return lugarPresentar;
    }

    public void setLugarPresentar(int lugarPresentar) {
        this.lugarPresentar = lugarPresentar;
    }

    
    
}
