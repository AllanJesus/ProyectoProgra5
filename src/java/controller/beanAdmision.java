/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SNMPExceptions;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.faces.context.FacesContext;
import model.Admision;
import model.AdmisionDB;

/**
 *
 * @author kevin
 */
@Named(value = "beanAdmision")
@SessionScoped
public class beanAdmision implements Serializable {
    

    private int idpersona;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int promedio;
    
    private LinkedList<Admision>listaDetalleSolicitudes= new LinkedList<Admision>();
    private LinkedList<Admision>listaDetalleAspirantes= new LinkedList<Admision>();
    
    public beanAdmision() {
    }

    public beanAdmision(int idpersona, String nombre, String apellido1, String apellido2, int promedio) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.promedio = promedio;
    }

    public LinkedList<Admision> getListaDetalleAspirantes() {
        return listaDetalleAspirantes;
    }

    public void setListaDetalleAspirantes(LinkedList<Admision> listaDetalleAspirantes) {
        this.listaDetalleAspirantes = listaDetalleAspirantes;
    }
    

    public LinkedList<Admision> getListaDetalleSolicitudes() {
        return listaDetalleSolicitudes;
    }

    public void setListaDetalleSolicitudes(LinkedList<Admision> listaDetalleSolicitudes) {
        this.listaDetalleSolicitudes = listaDetalleSolicitudes;
    }
    

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
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

    public int getPromedio() {
        return promedio;
    }
    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

   public void mostrarDetalleVotos(Admision per)throws SNMPExceptions, SQLException,IOException {
        AdmisionDB AdmisionDB= new AdmisionDB();
        
        this.setListaDetalleSolicitudes(AdmisionDB.listaDetalleSolicitudesApirantes());

    }

    public void mostrarDetalleAspirante(Admision per) throws SNMPExceptions, SQLException, IOException {
        AdmisionDB AdmisionDB = new AdmisionDB();
        this.setListaDetalleAspirantes(AdmisionDB.listaDetalleDatosApirantes(per.getIdentificacion()));
        FacesContext.getCurrentInstance().getExternalContext().redirect("rConsultaSolicitudes_1.xhtml");

    }

}

