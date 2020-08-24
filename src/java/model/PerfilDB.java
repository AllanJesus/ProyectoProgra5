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

/**
 *
 * @author kevin
 */
public class PerfilDB {
    
    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;
    
    public PerfilDB(){
        accesoDatos= new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }
    
    public void InsertarPerfil(Usuario u) throws SNMPExceptions, SQLException {
        String strSQL = "";

        try {
            //Se obtienen los valores del objeto Departamento
            
            strSQL
                    = "insert into Usuario_Perfil values("
                    + u.getId_usuario() + ","
                    + "2" + ")";

            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
    }
//------------------------------------------------------------------------------------------------------------------------------------------------------------
    public Perfil SeleccionarUsuario_PerfilPorID(String id) throws SNMPExceptions, 
            SQLException {
        
        String select = "";
        try {

            AccesoDatos accesoDatos = new AccesoDatos();

            select = "exec SP_SeleccionarUsuario_PerfilPorID " + id;

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);

            if (rsPA.next()) {
                Perfil per = new Perfil();
                per.id_usuario = rsPA.getInt("id_usuario");
                per.id_perfil = rsPA.getInt("id_perfil");

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
