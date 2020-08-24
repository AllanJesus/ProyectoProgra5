/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccesoDatos;
import dao.SNMPExceptions;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.faces.context.FacesContext;
import model.Admision;
import model.AdmisionDB;
import model.Persona;
import model.PersonaEstatica;
import model.Usuario;

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
    private String promedio;
    
    private String mensajeError;

    private LinkedList<Admision> listaDetalleSolicitudes = new LinkedList<Admision>();
    private LinkedList<Admision> listaDetalleAspirantes = new LinkedList<Admision>();

    public beanAdmision() {
    }

    public beanAdmision(int idpersona, String nombre, String apellido1, String apellido2, String promedio) {
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

    public String getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }

    public void mostrarDetalleVotos(Admision per) throws SNMPExceptions, SQLException, IOException {
        AdmisionDB AdmisionDB = new AdmisionDB();

        this.setListaDetalleSolicitudes(AdmisionDB.listaDetalleSolicitudesApirantes());

    }

    public void mostrarDetalleAspirante(Admision per) throws SNMPExceptions, SQLException, IOException {
        AdmisionDB AdmisionDB = new AdmisionDB();
        this.setListaDetalleAspirantes(AdmisionDB.listaDetalleDatosApirantes(per.getIdentificacion()));
        FacesContext.getCurrentInstance().getExternalContext().redirect("rConsultaSolicitudes_1.xhtml");

    }

    public String guardarAdmision() throws SNMPExceptions, SQLException {
        Persona p = PersonaEstatica.getPersona();
        Admision a = new Admision();
        a.setId_admision(p.getIdentificacion());
        a.setIdentificacion(p.getIdentificacion());
        a.setNota(Integer.parseInt(this.getPromedio()));
        AdmisionDB aDB = new AdmisionDB();

        if (this.getPromedio().equals("")) {
            aDB.InsertarAdmision(a);
            mensajeError = "Se guardo correctamente";
            return "";
        }
        return mensajeError = "El campo no puede estar null";
    }

}
