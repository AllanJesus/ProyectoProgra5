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
public class PersonaEstatica {
    private static Persona persona;

    public PersonaEstatica() {
    }

    public static Persona getPersona() {
        return persona;
    }

    public static void setPersona(Persona persona) {
        PersonaEstatica.persona = persona;
    }
    
}
