
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import gestion.LibroGestion;
import java.util.List;
import modelo.Libro;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "libroController")
@SessionScoped
public class LibroController extends Libro implements Serializable {

  
    public LibroController() {
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
        
        Libro libro=  LibroGestion.getLibro(id);
        
        if (libro !=null){
            
            this.setId(libro.getId());
            this.setTitulo(libro.getTitulo());
            this.setEditorial(libro.getEditorial());
            this.setYear(libro.getYear());
            this.setVersion(libro.getVersion());
            this.setAutor(libro.getAutor());
            this.setTematica(libro.getTematica());
            return "edita.xhtml";
        }else{
            
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Posiblemente el id no exista");
            FacesContext.getCurrentInstance().addMessage("listForm", mensaje);
            return "list.xhtml";
        }
        
    }
    
    
    public List<Libro> getLibros(){
        return LibroGestion.getLibros();
    }
    
    private boolean noImprimir = true; // Para habilitar o deshabilitar el botón que imprime la certificación
    
    public boolean isNoImprimir(){
        return noImprimir;
    }
    
    public void setNoImprimir (boolean noImprimir){
        this.noImprimir=noImprimir;
    }
    
    public void buscaEstudiante (String id){
        
        Libro libro = LibroGestion.getLibro(id);
        
        if (libro!=null){
            this.setId(libro.getId());
            this.setTitulo(libro.getTitulo());
            this.setEditorial(libro.getEditorial());
            this.setYear(libro.getYear());
            this.setVersion(libro.getVersion());
            this.setAutor(libro.getAutor());
            this.setTematica(libro.getTematica());
            this.noImprimir= false;
        }else{
            
            this.setId("");
            this.setTitulo("");
            this.setEditorial("");
            this.setYear(0);
            this.setVersion(0);
            this.setAutor("");
            this.setTematica("");
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_WARN, "No Encontrado",
            "Estudiante no Encontrado");
            FacesContext.getCurrentInstance().addMessage("certificacionEstudianteForm:identificacion", mensaje);
            this.noImprimir=true;
            
        }
   
        
    }
    
    
}
