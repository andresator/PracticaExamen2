
package gestion;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Libro;
import java.util.ArrayList;

public class LibroGestion {

    private static final String SQL_INSERT_LIBRO = "insert into libros (idLibro, titulo,"
            + "editorial,year,version,autor,tematica) values (?,?,?,?,?,?,?)";
    
    public static boolean insertar (Libro libro){
        
        try{
            PreparedStatement sentencia=  Conexion.getConexion().prepareCall(SQL_INSERT_LIBRO);
            sentencia.setString(1,libro.getId());
            sentencia.setString(2,libro.getTitulo());
            sentencia.setString(3,libro.getEditorial());
            sentencia.setInt(4,libro.getYear());
            sentencia.setInt(5,libro.getVersion());
            sentencia.setString(6,libro.getAutor());
            sentencia.setString(7,libro.getTematica());
            
            return sentencia.executeUpdate()>0;//Devuelve un true en caso de que sea posible insertar el registro
            
        }catch (SQLException ex){
            Logger.getLogger(LibroGestion.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        return false;
    }
    
    private static final String SQL_SELECT_LIBRO = "select * from libros where idLibro=?";
    
    public static Libro getLibro(String id){
        
        Libro libro = null; 
        
        try{
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_SELECT_LIBRO);
            consulta.setString(1, id);
            ResultSet datos=  consulta.executeQuery();
            
            if (datos.next()){
                libro = new Libro(
                datos.getString(2),
                datos.getString(3),
                datos.getString(4),
                datos.getInt(5),
                datos.getInt(6),
                datos.getString(7),
                datos.getString(8));
            }
            
        }catch (SQLException ex){
            Logger.getLogger(LibroGestion.class.getName()).log(Level.SEVERE,null,ex);
        }
            
        return libro;
    } 
    
    private static final String SQL_UPDATE_LIBRO = "update libros set titulo=?,editorial=?,"
            + "year=?,version=?,autor=?,tematica=? where idLibro=?";
    
    public static boolean actualiza (Libro libro){
        
        try{
            PreparedStatement sentencia= Conexion.getConexion().prepareCall(SQL_UPDATE_LIBRO);
            sentencia.setString(1, libro.getTitulo());
            sentencia.setString(2, libro.getEditorial());
            sentencia.setInt(3, libro.getYear());
            sentencia.setInt(4, libro.getVersion());
            sentencia.setString(5, libro.getAutor());
            sentencia.setString(6, libro.getTematica());
            sentencia.setString(7, libro.getId());
            
            return sentencia.executeUpdate()>0;
            
        }catch (SQLException ex){
            Logger.getLogger(LibroGestion.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return false; 
        
    }
    
    private static final String SQL_DELETE_LIBRO = "delete from libros where idLibro=?";
    
    public static boolean eliminar (Libro libro){
        
        try{
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_DELETE_LIBRO);
            consulta.setString(1, libro.getId());
            
            return consulta.executeUpdate()>0;
        }catch (SQLException ex){
            Logger.getLogger(LibroGestion.class.getName()).log(Level.SEVERE,null, ex);
        }
        return false;
    }
    
   
    private static final String SQL_SELECT_LIBROS= "Select * from libros";
    
    public static ArrayList<Libro> getLibros (){
        
        ArrayList<Libro> lista= new ArrayList<>();
        
        try{
            
            PreparedStatement consulta=Conexion.getConexion().prepareStatement(SQL_SELECT_LIBROS);
            ResultSet rs= consulta.executeQuery();
            
            while (rs!=null && rs.next()){
                lista.add(new Libro (rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getInt(6),
                            rs.getString(7),
                            rs.getString(8)));
            }
            
        }catch(SQLException ex){
            Logger.getLogger(LibroGestion.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return lista;
    }
    
}
