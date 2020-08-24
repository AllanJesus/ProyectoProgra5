/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kevin
 */
public class UsuarioEstatico {
    private static Usuario usuario;

    public UsuarioEstatico() {
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        UsuarioEstatico.usuario = usuario;
    }
}
