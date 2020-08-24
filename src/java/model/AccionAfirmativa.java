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
    
    private int id;
    private int puntos;
    private String poblaciones;
    private String documentos;
    private String lugarPresentar;

    public AccionAfirmativa(int id, int puntos, String poblaciones, String documentos, String lugarPresentar) {
       
        this.setId(id);
        this.setPuntos(puntos);
        this.setPoblaciones(poblaciones);
        this.setDocumentos(documentos);
        this.setLugarPresentar(lugarPresentar);
    }
    public AccionAfirmativa(int puntos, String poblaciones, String documentos, String lugarPresentar) {
      
        this.setPuntos(puntos);
        this.setPoblaciones(poblaciones);
        this.setDocumentos(documentos);
        this.setLugarPresentar(lugarPresentar);
    }
  
    public AccionAfirmativa() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    
    
}
