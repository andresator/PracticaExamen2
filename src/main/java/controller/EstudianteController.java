
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import gestion.LibroGestion;
import java.util.List;
import modelo.Libro;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "estudianteController")
@SessionScoped
public class EstudianteController extends Libro implements Serializable {

  
    public EstudianteController() {
    }
    
    public String inserta (){
        
        if (LibroGestion.insertar(this)){
            return "list.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error","Posible Identificación Duplicada");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", mensaje);
            return "edita.xhtml";
        }
    }
    
    public String modifica (){
        
        if (LibroGestion.actualiza(this)){
            return "list.xhtml";
            
        }else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Posible Identificación Duplicada");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", mensaje);
            return "edita.xhtml";
        }
        
    }
    
    public String elimina (){
        
        if (LibroGestion.eliminar(this)){
            return "list.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error", "Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", mensaje);
            return "edita.xhtml";
        }
        
    }
    
    public String edita (String id){
        
        Estudiante estudiante=  LibroGestion.getEstudiante(id);
        
        if (estudiante !=null){
            
            this.setId(estudiante.getId());
            this.setNombre(estudiante.getNombre());
            this.setApellido1(estudiante.getApellido1());
            this.setApellido2(estudiante.getApellido2());
            this.setFechaNaci(estudiante.getFechaNaci());
            this.setFechaIngr(estudiante.getFechaIngr());
            this.setGenero(estudiante.getGenero());
            return "edita.xhtml";
        }else{
            
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Posiblemente el id no exista");
            FacesContext.getCurrentInstance().addMessage("listForm", mensaje);
            return "list.xhtml";
        }
        
    }
    
    
    public List<Estudiante> getEstudiantes(){
        return LibroGestion.getEstudiantes();
    }
    
    private boolean noImprimir = true; // Para habilitar o deshabilitar el botón que imprime la certificación
    
    public boolean isNoImprimir(){
        return noImprimir;
    }
    
    public void setNoImprimir (boolean noImprimir){
        this.noImprimir=noImprimir;
    }
    
    public void buscaEstudiante (String id){
        
        Estudiante estudiante = LibroGestion.getEstudiante(id);
        
        if (estudiante!=null){
            this.setId(estudiante.getId());
            this.setNombre(estudiante.getNombre());
            this.setApellido1(estudiante.getApellido1());
            this.setApellido2(estudiante.getApellido2());
            this.setFechaNaci(estudiante.getFechaNaci());
            this.setFechaIngr(estudiante.getFechaIngr());
            this.noImprimir= false;
        }else{
            
            this.setId("");
            this.setNombre("");
            this.setApellido1("");
            this.setApellido2("");
            this.setFechaNaci(null);
            this.setFechaIngr(null);
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_WARN, "No Encontrado",
            "Estudiante no Encontrado");
            FacesContext.getCurrentInstance().addMessage("certificacionEstudianteForm:identificacion", mensaje);
            this.noImprimir=true;
            
        }
   
        
    }
    
    
}
