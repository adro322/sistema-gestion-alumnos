/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Dao.Interfaces.IAlumnosDao;
import Modelo.Alumnos;
import Modelo.Sedes;
import Utilidades.ExcelReader;
import java.io.File;
import java.util.List;
import Servicio.Estrategias.IAlumnosEstrategia;
import Servicio.Estrategias.ValidacionAlumno;

public class AlumnosService {

    private final IAlumnosDao alumnosDao;
    private final ExcelReader excelReader;
    private IAlumnosEstrategia estrategiaValidacion;

    // CONSTRUCTOR:
    // Instanciamos el ExcelReader porque es una utilidad simple.
    public AlumnosService(IAlumnosDao dao) {
        this.alumnosDao = dao;
        this.excelReader = new ExcelReader();
        this.estrategiaValidacion = new ValidacionAlumno();
    }
    
    public void setEstrategia(IAlumnosEstrategia nuevaEstrategia) {
        this.estrategiaValidacion = nuevaEstrategia;
    }
    // ---------------------------------------------------
    // LÓGICA PARA LISTADOS (La Vista pide datos, el servicio se los consigue)
    // ---------------------------------------------------
    public List<Sedes> obtenerListaSedes() {
        return alumnosDao.obtenerSedes();
    }

    public List<Alumnos> obtenerTodosLosAlumnos() {
        return alumnosDao.listarTodos();
    }

    public List<Alumnos> buscarPorApellido(String apellido) {
        return alumnosDao.buscarPorApellidos(apellido);
    }

    // ---------------------------------------------------
    // MÉTODOS PARA LA VISTA (CRUD)
    // ---------------------------------------------------
    public String registrarAlumno(Alumnos a) {
        String error = estrategiaValidacion.validar(a);

        if (error != null) {
            return error; // Si hay error (ej. promedio 25), lo devolvemos y NO guardamos
        }

        if (alumnosDao.registrar(a)) {
            return "Alumno registrado con éxito.";
        } else {
            return "Error al guardar en la base de datos.";
        }
    }

    public String actualizarAlumno(Alumnos a) {
        String error = estrategiaValidacion.validar(a);
        if (error != null) {
            return error;
        }

        return alumnosDao.actualizar(a) ? "Actualizado correctamente." : "Error al actualizar.";
    }

    public String eliminarAlumno(int id) {
        return alumnosDao.eliminar(id) ? "Eliminado correctamente." : "Error al eliminar.";
    }

    // ---------------------------------------------------
    // IMPORTACIÓN DE EXCEL
    // Este método oculta la complejidad de leer Excel, validar y guardar en BD
    // ---------------------------------------------------
    public String importarDesdeExcel(File archivo) {
        try {
            //Leer el archivo (Subsistema Excel)
            List<Alumnos> listaImportada = excelReader.leerExcel(archivo);

            if (listaImportada.isEmpty()) {
                return "El archivo Excel parece estar vacío o no tiene el formato correcto.";
            }
            int guardados = 0;
            int errores = 0;

            for (Alumnos alumno : listaImportada) {

                String errorValidacion = estrategiaValidacion.validar(alumno);

                if (errorValidacion == null) {
                    if (alumnosDao.registrar(alumno)) {
                        guardados++;
                    } else {
                        errores++;
                    }
                } else {
                    errores++; 
                    System.out.println("Omitido: " + errorValidacion);
                }
            }
            return "Proceso finalizado.\nRegistrados: " + guardados + "\nErrores: " + errores;

        } catch (Exception e) {
            e.printStackTrace();
            return "Ocurrió un error crítico al importar: " + e.getMessage();
        }
    }
}
