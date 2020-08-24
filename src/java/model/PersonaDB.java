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
public class PersonaDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    public PersonaDB() {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public void RegistrarPersona(Persona persona) throws SNMPExceptions, SQLException {
        String strSQL = "";

        try {
            //Se obtienen los valores del objeto Departamento
            Persona p = new Persona();
            p = persona;
            
            strSQL
                    = "insert into Persona values ("
                    + p.getIdentificacion() + ","
                    + "'" + p.getNombre() + "'" + ","
                    + "'" + p.getApellido1() + "'" + ","
                    + "'" + p.getApellido2()+ "'" + ","
                    + null+ ","
                    + null+ ","
                    + "'" + p.getCorreo() + "')";
            
            accesoDatos.ejecutaSQL(strSQL);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
    }

//------------------------------------------------------------------------------------------------------------------------------------------------------------

    public void ActualizarPersona(Usuario pUsuario)
            throws SNMPExceptions, SQLException {
        String strSQL = "";

        try {

            Usuario us = new Usuario();
            us = pUsuario;
            int estado = us.isEstado()? 1 : 0;
            

            strSQL
                    = "exec SP_ActualizarPersona "
                    + us.getId_usuario() + ","
                    + "'" + us.getCorreo()+ "'" + ","
                    + "'" + us.getContrasena()+ "'" + ","
                    + estado;

            accesoDatos.ejecutaSQL(strSQL);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
    }
//------------------------------------------------------------------------------------------------------------------------------------------------------------    
    public Persona SeleccionarPersonaPorID(String id) throws SNMPExceptions, 
            SQLException {
        
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "exec SP_SeleccionarPersonaPorID " + id;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            if (rsPA.next()) {
                Persona per = new Persona();
                per.identificacion = rsPA.getInt("id_persona");
                per.Nombre = rsPA.getString("nombre");
                per.apellido1= rsPA.getString("apellido1");
                per.apellido2 = rsPA.getString("apellido2");
                per.fechaNacimiento = rsPA.getString("fecha_nacimiento");
                per.edad = rsPA.getInt("edad");
                per.correo = rsPA.getString("correo");

                return per;
            }

            rsPA.close();

            return null;

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------------

}
