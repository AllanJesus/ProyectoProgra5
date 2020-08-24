/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SNMPExceptions;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import model.Persona;
import model.PersonaDB;

/**
 *
 * @author allanquesada
 */
@Named(value = "beanDatoPersonal")
@SessionScoped
public class beanDatoPersonal implements Serializable {
    
        /**
     * Creates a new instance of beanDatoPersonal
     */
    
    int identificacion;
    String tipoIdentificacion;
    String nombre; 
    String primerApellido;
    String segundoApellido;
    String fechaNacimiento;
    int edad;
    String correo;
    String resultado;
    String otras;
    String mensajeError;
    String Provincia;
     
   
    public beanDatoPersonal() {
        
    }
    
    public void insertarPersona() throws SNMPExceptions, SQLException{
       
        Persona persona= new Persona(this.identificacion,this.nombre,this.primerApellido,
                        this.segundoApellido,this.fechaNacimiento,this.edad,this.correo);
        
            PersonaDB pDB= new PersonaDB();
            
            
                try {
            pDB.RegistrarPersona(persona);  
               this.mensajeError ="Persona instertada Correctamente";
        } catch (Exception e) {
            this.mensajeError ="Persona instertada Incorrectamente";
        }
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }
    
     public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getOtras() {
        return otras;
    }

    public void setOtras(String otras) {
        this.otras = otras;
    }
    
    
    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
        public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String validarDatosPersonales(){
        if (validacionIdentificacion()) {
            mensajeError = "Debe escribir una identificacion";
            return mensajeError;
        }
        if (validacionTipoIdentificacion()) {
            mensajeError = "Debe escribir un Tipo de identificacion"
         ;
            return mensajeError;
        }     
        if (validacionNombreVacio()) {
            mensajeError = "El campo de Nombre no puede estar vacio";
            return mensajeError;
        }
        
        if (validacionPrimerApellidoVacio()) {
            mensajeError = "Debe escribir primer apellido";
            return mensajeError;
        }
        if (validacionSegundoApellidoVacio()) {
            mensajeError = "Debe escribir el segundo apellido";
            return mensajeError;
        }
        if (validacionFechaNacimientoVacio()) {
            mensajeError = "Debe escribir una fecha de Nacimiento";
            return mensajeError;
        }
        if (validacionCorreoVacio()) {
            mensajeError = "Debe escribir el correo";
            return mensajeError;
        }
        if (validacionOtrasVacio()) {
            mensajeError = "Debe escribir el correo";
            return mensajeError;
        }
        if (validacionProvinciaSeleccionada()) {
            mensajeError = "Debe Seleccionar una Provincia";
            return mensajeError;
        }
        
        return "aMensajeRegistro";
    }
    ////////////////////////////Patrones para Validar DatosPersonales////////////////////////////
    private boolean validacionIdentificacion() { // Valida Usuario en Blanco    
        if (Integer.toString(this.identificacion).matches("")) {
            return true;
        }
        return false;
    }
    private boolean validacionTipoIdentificacion() { // Valida Usuario en Blanco    
        if ((this.tipoIdentificacion.matches(""))) {
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
    private boolean validacionPrimerApellidoVacio() { // Valida Usuario en Blanco    
        if ((this.primerApellido.matches(""))) {
            return true;
        }
        return false;
    }
    private boolean validacionSegundoApellidoVacio() { // Valida Usuario en Blanco    
        if ((this.segundoApellido.matches(""))) {
            return true;
        }
        return false;
    }
    private boolean validacionFechaNacimientoVacio() { // Valida Usuario en Blanco    
        if ((this.fechaNacimiento.matches(""))) {
            return true;
        }
        return false;
    }
    private boolean validacionCorreoVacio() { // Valida Usuario en Blanco    
        if ((this.correo.matches(""))) {
            return true;
        }
        return false;
    }
    private boolean validacionOtrasVacio() { // Valida Usuario en Blanco    
        if ((this.otras.matches(""))) {
            return true;
        }
        return false;
    
    }
    private boolean validacionProvinciaSeleccionada() { // Valida Usuario en Blanco    
        if ((this.Provincia.matches(""))) {
            return true;
        }
        return false;
    
    }
    public void guardar() {
       this.setResultado(this.getIdentificacion()+" "+ this.getTipoIdentificacion()+" "+ this.getNombre()+ " " + this.getPrimerApellido()+ " " + this.getSegundoApellido()+ " "+ 
                         this.getFechaNacimiento()+ " " + this.getCorreo()+this.getOtras());
    }
    public void limpiar() {
       this.setIdentificacion(0);
       this.setTipoIdentificacion("");
       this.setNombre("");
       this.setPrimerApellido("");
       this.setSegundoApellido("");
       this.setFechaNacimiento("");
       this.setCorreo("");
       this.setOtras("");
       this.setResultado("");
       this.setMensajeError("");
      
    }
    
    
}
