/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AccesoDatos;
import dao.SNMPExceptions;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author kevin
 */
public class AdmisionDB {
    
    Persona persona;
    float nota;
    float promedio;
    boolean estado;

    public AdmisionDB() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    //metodo que se trae toda la lista de Cadidatos

    public LinkedList<Admision> listaDetalleSolicitudesApirantes()
            throws SNMPExceptions, SQLException{
        
        String select= "";
        LinkedList<Admision> listaDetSolicitudes= new LinkedList<Admision>();
        
        try{
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos= new AccesoDatos();
            
            //Se crea la sentencia de Busqueda
            select=
            "SELECT Persona.id_persona, " +
            " Persona.nombre, Persona.apellido1," +
            " Persona.apellido2, Admision.promedio" +
            " FROM Persona INNER JOIN Admision ON Admision.id_persona = Persona.id_persona" ;
            
            ResultSet rsPA= accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while(rsPA.next()){
                
                
                
                int numIde=rsPA.getInt("id_persona");
                String nomPer=rsPA.getString("nombre");
                String nomApell=rsPA.getString("apellido1");
                String nomApell2=rsPA.getString("apellido2");
                
               
                
                float prom= rsPA.getFloat("promedio");
                
                  
                //se construye el objeto.
               Admision voto= new Admision(numIde,nomPer,nomApell,nomApell2,prom);
                
                listaDetSolicitudes.add(voto);
            }
            rsPA.close();//se cierra el ResultSeat.
            
        }catch(SQLException e){
            throw new SNMPExceptions (SNMPExceptions.SQL_EXCEPTION,
                                     e.getMessage(),e.getErrorCode());
        }catch(Exception e){
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,e.getMessage());
        }finally{
            
        }
        return listaDetSolicitudes;
    }
    
     public LinkedList<Admision> listaDetalleDatosApirantes(int identificacion)
            throws SNMPExceptions, SQLException{
        
        String select= "";
        LinkedList<Admision> listaDetSolicitudes= new LinkedList<Admision>();
        
        try{
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos= new AccesoDatos();
            
            //Se crea la sentencia de Busqueda
            select=
            "SELECT Persona.id_persona, " +
            " Persona.nombre, Persona.apellido1," +
            " Persona.apellido2,Persona.fecha_nacimiento, Persona.edad, Persona.correo, Admision.promedio" +
            " FROM Persona INNER JOIN Admision ON Admision.id_persona = Persona.id_persona"+
            "  where Persona.id_persona ='"+identificacion+"';";
            
            ResultSet rsPA= accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while(rsPA.next()){
                
                
                
                int numIde=rsPA.getInt("id_persona");
                String nomPer=rsPA.getString("nombre");
                String nomApell=rsPA.getString("apellido1");
                String nomApell2=rsPA.getString("apellido2");
            
                Date fec=rsPA.getDate("fecha_nacimiento");
                int edad=rsPA.getInt("edad");
                String corr=rsPA.getString("correo");
                
                float prom= rsPA.getFloat("promedio");
                  
                //se construye el objeto.
               Admision voto= new Admision(numIde,nomPer,nomApell,nomApell2,
               fec,edad,corr,prom);
                
                listaDetSolicitudes.add(voto);
            }
            rsPA.close();//se cierra el ResultSeat.
            
        }catch(SQLException e){
            throw new SNMPExceptions (SNMPExceptions.SQL_EXCEPTION,
                                     e.getMessage(),e.getErrorCode());
        }catch(Exception e){
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,e.getMessage());
        }finally{
            
        }
        return listaDetSolicitudes;
    }
    
    
}
