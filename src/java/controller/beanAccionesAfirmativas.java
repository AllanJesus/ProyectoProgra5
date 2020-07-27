/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedList;
import model.AccionAfirmativa;

/**
 *
 * @author kevin
 */
@Named(value = "beanAccionesAfirmativas")
@SessionScoped
public class beanAccionesAfirmativas implements Serializable {

    /**
     * Creates a new instance of beanAccionesAfirmativas
     */
    public beanAccionesAfirmativas() {

    }

    
}
