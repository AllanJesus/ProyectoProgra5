/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AccesoDatos;
import dao.SNMPExceptions;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author kevin
 */
public class AccionAfirmativaDB {
    
    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;
    
    
    public AccionAfirmativaDB(){
        accesoDatos= new AccesoDatos();
        accesoDatos.setDbConn(conn);
    
    }
    
    int puntos;
    String poblaciones;
    String documentos;
    int lugarPresentar;

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

 
     //metodo que se trae toda la lista de Cadidatos
    public LinkedList<AccionAfirmativa> moTodo() throws SNMPExceptions, SQLException{
        String select= "";
        LinkedList<AccionAfirmativa> listaAcciones= new LinkedList<AccionAfirmativa>();
        
        try{
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos= new AccesoDatos();
            
            //Se crea la sentencia de Busqueda
            select=
                    "SELECT puntos,Poblaciones,Documentos, lugar FROM AccionAfirmativa";
            //se ejecuta la sentencia sql
            ResultSet rsPA= accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while(rsPA.next()){
                
                int puntos= rsPA.getInt("puntos");
                
                String poblaciones = rsPA.getString("Poblaciones");
                
                
                String documentos= rsPA.getString("Documentos");
                
                int lugar = rsPA.getInt("lugar");
                //se construye el objeto.
                AccionAfirmativa perAccionAfirmativa= new AccionAfirmativa(puntos,poblaciones,documentos,lugar);
                
                listaAcciones.add(perAccionAfirmativa);
            }
            rsPA.close();//se cierra el ResultSeat.
            
        }catch(SQLException e){
            throw new SNMPExceptions (SNMPExceptions.SQL_EXCEPTION,
                                     e.getMessage(),e.getErrorCode());
        }catch(Exception e){
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,e.getMessage());
        }finally{
            
        }
        return listaAcciones;
    }

    
}
