    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Servicio.Estrategias;
import Modelo.Alumnos;

/**
 *
 * @author USER
 */

public interface IAlumnosEstrategia {
    // Si devuelve NULL, el alumno es válido.
    // Si devuelve TEXTO, es el mensaje de error.
    String validar(Alumnos a);
}
