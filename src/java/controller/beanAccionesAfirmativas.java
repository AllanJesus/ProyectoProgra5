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
import javax.naming.NamingException;
import model.AccionAfirmativa;
import model.AccionAfirmativaDB;
import model.Admision;
import model.AdmisionDB;

/**
 *
 * @author kevin
 */
@Named(value = "beanAccionesAfirmativas")
@SessionScoped
public class beanAccionesAfirmativas implements Serializable {
    
    private int id;
    private int puntos;
    private String poblaciones;
    private String documentos;
    private String lugar;
    private String mensaje;
    String mensajeAlerta;

    public String getMensajeAlerta() {
        return mensajeAlerta;
    }

    public void setMensajeAlerta(String mensajeAlerta) {
        this.mensajeAlerta = mensajeAlerta;
    }
    
    
    private LinkedList<AccionAfirmativa> listaAcciones= new LinkedList<AccionAfirmativa>();
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
     public beanAccionesAfirmativas() {
    }
    

    public LinkedList<AccionAfirmativa> getListaAcciones() {
        return listaAcciones;
    }

    public void setListaAcciones(LinkedList<AccionAfirmativa> listaAcciones) {
        this.listaAcciones = listaAcciones;
    }
    /**
     * Creates a new instance of beanAccionesAfirmativas
     */
   

    public void mostrarLista() throws SNMPExceptions, SQLException {
        AccionAfirmativaDB AccionAfirmativaDB = new AccionAfirmativaDB();

        this.setListaAcciones(listaAcciones);
    }
    
    
    public void FiltroTabla() throws SNMPExceptions, SQLException{
        LinkedList<AccionAfirmativa> listaD = new LinkedList<AccionAfirmativa>();
        AccionAfirmativaDB AccionAfirmativaDB = new AccionAfirmativaDB();

                    
                listaD = AccionAfirmativaDB.moTodo();
                this.setListaAcciones(listaD);
          
    }
    
     public void insertarCampos() throws SNMPExceptions, SQLException{
       
        AccionAfirmativa oAccionAfirmativa= new AccionAfirmativa(this.id,this.puntos,this.poblaciones,this.documentos,
            this.lugar);
        
         if (this.documentos.equals("") || this.poblaciones.equals("")
                || this.lugar.equals("")) {

            this.setMensaje("Campos Obligatorios!");

        } else {
        
            AccionAfirmativaDB vDB= new AccionAfirmativaDB();
            vDB.InsertarTelefono(oAccionAfirmativa);  
            this.setMensaje("Accion Afirmativa ingresada correctamente!");
            
        }
     }

    public void limpiarCampos(){
        this.setId(0);
        this.setPuntos(0);
        this.setDocumentos("");
        this.setPoblaciones("");
        this.setLugar("");
    }
    public void actualizaDatos() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException{
        AccionAfirmativaDB dDB = new AccionAfirmativaDB();
        AccionAfirmativa depUTN = new AccionAfirmativa();
        
        depUTN.setId(this.getId());
        depUTN.setPuntos(this.getPuntos());
        depUTN.setPoblaciones(this.getPoblaciones());
        depUTN.setDocumentos(this.getDocumentos());
        depUTN.setLugarPresentar(this.getLugar());

        dDB.actualizarDepartamento(depUTN);
        this.setMensajeAlerta("Actualizacion Realizada");
        this.FiltroTabla();
    }

    public void asignaDatos(AccionAfirmativa dep){
        this.setId(dep.getId());
        this.setPuntos(dep.getPuntos());
        this.setPoblaciones(dep.getPoblaciones());
        this.setDocumentos(dep.getDocumentos());
        this.setLugar(dep.getLugarPresentar());

        
    }
      


}
