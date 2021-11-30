

package modelo;

public class Libro {
    
    private String id;
    private String titulo;
    private String editorial;
    private int year;
    private int version;
    private String autor;
    private String tematica;

    
    public Libro() {
    }

    public Libro(String id, String titulo, String editorial, int year, int version, String autor, String tematica) {
        this.id = id;
        this.titulo = titulo;
        this.editorial = editorial;
        this.year = year;
        this.version = version;
        this.autor = autor;
        this.tematica = tematica;
    }
    
    
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }
    
    
    
    
}
