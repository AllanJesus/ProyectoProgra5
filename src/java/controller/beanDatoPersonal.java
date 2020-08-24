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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import javafx.beans.property.IntegerProperty;
import model.Persona;
import model.PersonaDB;
import model.PersonaEstatica;
import model.Usuario;
import model.UsuarioEstatico;

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
    String identificacion;
    String tipoIdentificacion;
    String nombre;
    String primerApellido;
    String segundoApellido;
    String fechaNacimiento;

    String edad;
    String correo;
    String resultado;
    String otras;
    String mensajeError;
    String Provincia;

    Usuario usuario = UsuarioEstatico.getUsuario();
    Persona persona = PersonaEstatica.getPersona();

    public beanDatoPersonal() {

    }

    public String cargarDatos() throws SNMPExceptions, SQLException, ParseException, Exception {
        if (persona != null) {
            try {
                this.setIdentificacion(Integer.toString(persona.getIdentificacion()));
                this.setTipoIdentificacion("Nacional");
                this.setNombre(persona.getNombre());
                this.setPrimerApellido(persona.getApellido1());
                this.setSegundoApellido(persona.getApellido2());
                this.setFechaNacimiento(persona.getFechaNacimiento());
                this.setEdad(Integer.toString(persona.getEdad()));
                this.setCorreo(persona.getCorreo());
                mensajeError = "Datos cargado Correctamente";
                return mensajeError;
            } catch (Exception e) {
            }
        }

        mensajeError = "No hay persona Seleccionada";
        return mensajeError;
    }

    public String ActualizarPersona() throws SNMPExceptions, SQLException {

        validarDatosPersonales();
        if (mensajeError.equals("")) {
            try {
                PersonaDB pDB = new PersonaDB();
                persona.setIdentificacion(Integer.parseInt(this.getIdentificacion()));
                persona.setNombre(this.nombre);
                persona.setApellido1(this.getPrimerApellido());
                persona.setApellido2(this.getSegundoApellido());
                persona.setFechaNacimiento(this.getFechaNacimiento());
                persona.setEdad(Integer.parseInt(this.getEdad()));
                persona.setCorreo(this.getCorreo());
                pDB.ActualizarPersona(persona);
                mensajeError = "Se guardo correctamente";
                return mensajeError;
            } catch (Exception e) {
                mensajeError = "No se pudo guardar";
                return mensajeError;
            }
        }
        return validarDatosPersonales();
    }

    public int calcularEdad(Calendar dob) throws Exception {
        Calendar today = Calendar.getInstance();

        int curYear = today.get(Calendar.YEAR);
        int dobYear = dob.get(Calendar.YEAR);

        int age = curYear - dobYear;

        // if dob is month or day is behind today's month or day
        // reduce age by 1
        int curMonth = today.get(Calendar.MONTH);
        int dobMonth = dob.get(Calendar.MONTH);
        if (dobMonth > curMonth) { // this year can't be counted!
            age--;
        } else if (dobMonth == curMonth) { // same month? check for day
            int curDay = today.get(Calendar.DAY_OF_MONTH);
            int dobDay = dob.get(Calendar.DAY_OF_MONTH);
            if (dobDay > curDay) { // this year can't be counted!
                age--;
            }
        }

        return age;
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String validarDatosPersonales() {
        if (validacionIdentificacion()) {
            mensajeError = "Debe escribir una identificacion";
            return mensajeError;
        }
        if (validacionTipoIdentificacion()) {
            mensajeError = "Debe escribir un Tipo de identificacion";
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

        mensajeError = "";
        return mensajeError;
    }

    ////////////////////////////Patrones para Validar DatosPersonales////////////////////////////
    private boolean validacionIdentificacion() { // Valida Usuario en Blanco    
        if (this.getIdentificacion().matches("")) {
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

    public void limpiar() {
        this.setTipoIdentificacion("");
        this.setFechaNacimiento("");
        this.setEdad("");
        this.setCorreo("");
        this.setOtras("");
        this.setResultado("");
        this.setMensajeError("");
    }

}
