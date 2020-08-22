/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AccesoDatos;
import dao.SNMPExceptions;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author kevin
 */


public class UsuarioDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    public UsuarioDB() {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public void RegistrarUsuario(Usuario usuario) throws SNMPExceptions, SQLException {
        String strSQL = "";

        try {
            //Se obtienen los valores del objeto Departamento
            Usuario u = new Usuario();
            u = usuario;

            strSQL
                    = "INSERT INTO Persona(id_usuario, id_persona, correo, contraseña, estado) VALUES "
                    + "(" + "'" + u.getPersona().getIdentificacion() + "'" + ","
                    + "'" + u.getPersona().getIdentificacion() + "'" + ","
                    + "'" + u.getPersona().getCorreo() + "'" + ","
                    + "'" + u.getContrasena() + "'" + ","
                    + "'" + u.estadoToInt() + "'" + ")";

            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
    }
    
    public void ActualizarUsuario(Usuario usuario) throws SNMPExceptions, SQLException {

        String strSQL = "";

        try {

            Usuario usu = new Usuario();
            usu = usuario;

            strSQL
                    = "UPDATE Usuario SET "
                    + "correo = " + usuario.getCorreo()+ ","
                    + "contrasena = " + usuario.getContrasena()+ ","
                    + "estado = " + usuario.estadoToInt()+","
                    + " WHERE id_usuario = " + usuario.getPersona().identificacion;

            accesoDatos.ejecutaSQL(strSQL);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
    }

}
