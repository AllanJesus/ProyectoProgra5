/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.regex.Pattern;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author kevin
 */
@Named(value = "beanLogin")
@SessionScoped
public class beanLogin implements Serializable {

    String usuario;
    String contrasena;
    String contrasena1;
    String contrasena2;
    String tipoUsuario;
    String mensajeError;
    
    String identificacion;
    String nombre;
    String correo;
    String apellido1;
    String apellido2;

    ////////////////////////////Patrones para Validar Login \\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    Pattern matchesCaracterEspecial = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE); //Validar Caracteres Especiales
    Pattern matchesMayuscula = Pattern.compile("[A-Z ]"); //Validar Mayuscula 
    Pattern matchesMinuscula = Pattern.compile("[a-z ]"); //Validar minuscula
    Pattern matchesNumero = Pattern.compile("[0-9 ]"); //Validar Numero
    Pattern matchesCorreo = Pattern.compile("^(.+)@(.+)$"); //Validar Correo

    public beanLogin() {
    }

    
    ////////////////////////////Validaciones Login////////////////////////////
    public String validacionLogin() {
        if (validacionUsuarioVacio()) {
            mensajeError = "Campo de usuario no debe estar en blanco";
            return mensajeError;
        }
        
        if (validacionContrasenaVacio()) {
            mensajeError = "Campo de Contraseñas no debe estar en blanco";
            return mensajeError;
        }
        
//        if (tipoUsuario.equals("Registro")) {
//            return "rMenuRegistro.xhtml";
//        }
        return "aMenuAspirante.xhtml";
//        return "aAutoRegistro.xhtml";
//        return "aRegistroConstrasena.xhtml";
    }

////////////////////////////Patrones para Validar Login////////////////////////////
    private boolean validacionUsuarioVacio() { // Valida Usuario en Blanco    
        if ((this.usuario.matches(""))) {
            return true;
        }
        return false;
    }
    
    private boolean validacionContrasenaVacio() { // Valida Contraseña en Blanco

        if (this.contrasena.equals("")) {
            return true;
        }
        return false;
    }   
    
////////////////////////////Validacion AutoRegistro ////////////////////////////
    public String validarAutoRegistro(){
        if (validacionIdentificacion()) {
            mensajeError = "Debe escribir una identificacion";
            return mensajeError;
        }
        
        if (validacionCorreoVacio()) {
            mensajeError = "El campo de correo no puede estar vacio";
            return mensajeError;
        }
        
        if (validacionFormatoCorreo()) {
            mensajeError = "Debe escribir un correo valido";
            return mensajeError;
        }
        
        if (validacionNombreVacio()) {
            mensajeError = "El campo de Nombre no puede estar vacio";
            return mensajeError;
        }
        
        if (validacionApellidosVacio()) {
            mensajeError = "Debe escribir ambos apellidos";
            return mensajeError;
        }
        
        return "aMensajeRegistro";
    }
    
////////////////////////////Patrones para Validar AutoRegistro////////////////////////////
private boolean validacionIdentificacion() { // Valida Usuario en Blanco    
        if ((this.identificacion.matches(""))) {
            return true;
        }
        return false;
    }

private boolean validacionCorreoVacio() { // Valida Usuario en Blanco    
        if ((this.usuario.matches(""))) {
            return true;
        }
        return false;
    }

private boolean validacionFormatoCorreo() { // Valida Usuario en Blanco    
        if (matchesCorreo.matcher(this.correo).find()) {
            return true;
        }
        return false;
    }

    
    private boolean validacionNombreVacio() { // Valida Usuario en Blanco    
        if ((this.nombre.matches(""))) {
            return true;
        }
        return false;
    }
    
    private boolean validacionApellidosVacio() { // Valida Usuario en Blanco    
        if ((this.apellido1.matches("")) || (this.apellido2.matches("")) ) {
            return true;
        }
        return false;
    }
    
////////////////////////////Validar Contraseña ////////////////////////////
    
    public String validacionContraseña(){
        if (validacionTamanoCorrecto()) {
            mensajeError = "La Contraseñas debe tener minimo 8 caracteres y no mas de 12";
            return mensajeError;
        }
        
        if (validacionNumeros()) {
            mensajeError = "La Contraseñas debe tener por lo menos un numero";
            return mensajeError;
        }

        if (ValidacionCaracteresInvalidos()) {
            mensajeError = "La Contraseñas no debe tener caracteres especiales";
            return mensajeError;
        }

        if (validacionMayusculas()) {
            mensajeError = "La Contraseñas debe tener por lo menos una letra mayuscula";
            return mensajeError;
        }      
        
        if (validacionMinusculas()) {
            mensajeError = "La Contraseñas debe tener por lo menos una letra minuscula";
            return mensajeError;
        }      
        
        if (validacionContrasenaVacio()) {
            mensajeError = "Debe Escribir amabas Contraseñas";
            return mensajeError;
        }      
        
        if (validacionConstrasenasIguales()) {
            mensajeError = "Las contrasenas no coiciden";
            return mensajeError;
        }      
        
        return "aMensajeConstrasena.xhtml";
        
    }
    
    
    
    
////////////////////////////Patrones para Validar Contraseña ////////////////////////////
    private boolean validacionTamanoCorrecto() { // Valida que el tamaño de la contraseña sea correcto
        if (this.contrasena1.length() <= 8 || this.contrasena1.length() >= 12) {
            return true;
        }
        return false;
    }

    private boolean ValidacionCaracteresInvalidos() { // Valida que no haya caracteres invalidos
        if (matchesCaracterEspecial.matcher(this.contrasena1).find()) {
            return true;
        }
        return false;
    }

    private boolean validacionMayusculas() { // Valida que haya por lo menos una mayuscula
        if (!matchesMayuscula.matcher(this.contrasena1).find()) {
            return true;
        }
        return false;
    }

    private boolean validacionMinusculas() { // Valida que haya por lo menos una minuscula
        if (!matchesMinuscula.matcher(this.contrasena1).find()) {
            return true;
        }
        return false;
    }

    private boolean validacionNumeros() { // Valida que haya por lo menos un numero
        if (!matchesNumero.matcher(this.contrasena1).find()) {
            return true;
        }
        return false;
    }
    
    private boolean validacionConstrasenasIguales() { // Valida que haya por lo menos un numero
        if (!(this.contrasena1.equals(this.contrasena2))) {
            return true;
        }
        return false;
    }
    
    private boolean validacionContrasena1Vacio() { // Valida que haya por lo menos un numero
        if ((this.contrasena1.matches(""))||(this.contrasena2.matches(""))) {
            return true;
        }
        return false;
    }
    
////////////////////////////Getters y Setters////////////////////////////
    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena1() {
        return contrasena1;
    }

    public void setContrasena1(String contrasena1) {
        this.contrasena1 = contrasena1;
    }

    public String getContrasena2() {
        return contrasena2;
    }

    public void setContrasena2(String contrasena2) {
        this.contrasena2 = contrasena2;
    }
    
    

}
