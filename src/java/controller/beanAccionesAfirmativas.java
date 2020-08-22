/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SNMPExceptions;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedList;
import model.AccionAfirmativa;
import model.AccionAfirmativaDB;

/**
 *
 * @author kevin
 */
@Named(value = "beanAccionesAfirmativas")
@SessionScoped
public class beanAccionesAfirmativas implements Serializable {

    private LinkedList<AccionAfirmativa> listaAcciones= new LinkedList<AccionAfirmativa>();
    
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

        this.setListaAcciones(AccionAfirmativaDB.moTodo());
    }

    
}
