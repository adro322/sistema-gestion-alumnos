package Dao.Interfaces;

import Modelo.Alumnos;
import Modelo.Sedes;
import java.util.List;

public interface IAlumnosDao {
    // CRUD Básico
    boolean registrar(Alumnos a);
    boolean actualizar(Alumnos a);
    boolean eliminar(int id); 
    
    // Búsquedas y Listados
    List<Alumnos> listarTodos(); 
    List<Alumnos> buscarPorApellidos(String apellidos);
    
    // Datos auxiliares
    List<Sedes> obtenerSedes(); 
    
}