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
import java.util.Date;
import java.util.LinkedList;
import javax.naming.NamingException;

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
    //metodo que se trae toda la lista de Cadidatos
    public LinkedList<AccionAfirmativa> moTodo() throws SNMPExceptions, SQLException{
        String select= "";
        LinkedList<AccionAfirmativa> listaAcciones= new LinkedList<AccionAfirmativa>();
        
        try{
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos= new AccesoDatos();
            
            //Se crea la sentencia de Busqueda
            select=
                    "SELECT AccionAfirmativa.id_accionafirmativa, AccionAfirmativa.puntos,AccionAfirmativa.Poblaciones,AccionAfirmativa.Documentos, AccionAfirmativa.lugar FROM AccionAfirmativa";
            //se ejecuta la sentencia sql
            ResultSet rsPA= accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while(rsPA.next()){
                
                int id= rsPA.getInt("id_accionafirmativa");
                int puntos= rsPA.getInt("puntos");
                String poblaciones = rsPA.getString("Poblaciones");                
                String documentos= rsPA.getString("Documentos");
                String lugar = rsPA.getString("lugar");
                //se construye el objeto.
                AccionAfirmativa perAccionAfirmativa= new AccionAfirmativa(id,puntos,poblaciones,documentos,lugar);
                
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
      //insertar telefonos en la base de datos.
    public void InsertarTelefono(AccionAfirmativa pVoto) 
                throws SNMPExceptions, SQLException {
        String strSQL = "";

         
         try {
         //Se obtienen los valores del objeto Departamento
        AccionAfirmativa voto = new AccionAfirmativa();
        voto=pVoto;
        
            strSQL = 
            "INSERT INTO AccionAfirmativa(id_accionafirmativa,puntos,Poblaciones,Documentos,lugar) VALUES"
                   
         + "(" + "'" + voto.getId()+ "'" + "," 
               + "'"+ voto.getPuntos()+"'"+ ","
               + "'"+ voto.getPoblaciones()+"'"+ ","
               + "'"+ voto.getDocumentos()+"'" + ","
               + "'"+ voto.getLugarPresentar()+"'"+ ")";
                            
   
                     //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL);


        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
    }

    public void actualizarDepartamento(AccionAfirmativa accionp) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
           //Se obtienen los valores del objeto Cliente
           AccionAfirmativa d = new AccionAfirmativa();
           d = accionp;
           
           //Datos de CLiente         
            int id = d.getId();
            int punt = d.getPuntos();
            String pob = d.getPoblaciones();
            String doc = d.getDocumentos();
            String lug = d.getLugarPresentar();
            
            
         
           //Se crea la sentencia de actualización
           String update = 
                   "UPDATE AccionAfirmativa SET puntos = '" + punt + "' , Poblaciones = '" + pob + "'"
                   + " , Documentos = '" + doc + "', lugar= '" + lug + "' where id_accionafirmativa = '"+id+"';";
           //Se ejecuta la sentencia SQL
           accesoDatos.ejecutaSQL(update);
               
     }
}
