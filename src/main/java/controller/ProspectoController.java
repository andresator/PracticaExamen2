/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import modelo.Prospecto;
import gestion.ProspectoGestion;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "prospectoController")
@SessionScoped
public class ProspectoController extends Prospecto implements Serializable {

   
    public ProspectoController() {
    }
    
    public String inserta (){
        
        //Si puede inserta el prospecto
        
        if (ProspectoGestion.insertar(this)){
            return "confirmacion.xhtml";
        }else{
            FacesMessage mensaje = new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible Cédula Duplicada...");
            FacesContext.getCurrentInstance().addMessage("registroProspectoForm:cedula", mensaje);
            return "registro.xhtml";
        }
        
    }
    
}
