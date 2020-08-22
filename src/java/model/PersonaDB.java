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
                    = "INSERT INTO Persona(id_persona, nombre, apellido1, apellido2, fecha_nacimiento, edad,correo) VALUES "
                    + "(" + "'" + p.getIdentificacion() + "'" + ","
                    + "'" + p.getNombre() + "'" + ","
                    + "'" + p.getApellido1() + "'" + ","
                    + "'" + p.getApellido2() + "'" + ","
                    + "'" + p.getFechaNacimiento() + "'" + ","
                    + "'" + p.getEdad() + "'" + ")"
                    + "'" + p.getCorreo() + "'" + ")";

            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
    }
}
