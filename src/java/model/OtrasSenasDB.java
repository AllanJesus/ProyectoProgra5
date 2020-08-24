/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AccesoDatos;
import java.sql.Connection;

/**
 *
 * @author kevin
 */
public class OtrasSenasDB {
    
    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    public OtrasSenasDB() {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }
    
    
    
}
