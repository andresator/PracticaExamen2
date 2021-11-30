
package modelo;

import java.util.Date;

public class Estudiante {
    
    private String id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechaNaci;
    private Date fechaIngr;
    private char genero;

    public Estudiante(String id, String nombre, String apellido1, String apellido2, Date fechaNaci, Date fechaIngr, char genero) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNaci = fechaNaci;
        this.fechaIngr = fechaIngr;
        this.genero = genero;
    }

    public String getNombreCompleto(){
        
        String texto="";
        
        texto+= this.nombre!=null?this.nombre+" ":"";
        texto+= this.apellido1!=null?this.apellido1+" ":"";
        texto+= this.apellido2!=null?this.apellido2+" ":"";
        
        return texto;
        
    }
    
    
    public Estudiante() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Date getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(Date fechaNaci) {
        this.fechaNaci = fechaNaci;
    }

    public Date getFechaIngr() {
        return fechaIngr;
    }

    public void setFechaIngr(Date fechaIngr) {
        this.fechaIngr = fechaIngr;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
    
    
    
    
    
    
}
