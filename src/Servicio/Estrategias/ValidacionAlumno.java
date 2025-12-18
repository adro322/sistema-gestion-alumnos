/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio.Estrategias;

import Modelo.Alumnos;

public class ValidacionAlumno implements IAlumnosEstrategia {

    @Override
    public String validar(Alumnos a) {
        // Validar Promedio (Debe ser entre 0 y 20)
        if (a.getPromedio() < 0 || a.getPromedio() > 20) {
            return "Error: El promedio debe estar entre 0 y 20.";
        }

        // Validar Ciclo (Debe ser numérico y entre 1 y 10)
        try {
            int ciclo = Integer.parseInt(a.getCiclo()); 
            if (ciclo < 1 || ciclo > 10) {
                return "Error: El ciclo debe estar entre 1 y 10.";
            }
        } catch (NumberFormatException e) {
            return "Error: El ciclo debe ser un número válido.";
        }

        // Si pasa todas las reglas, retornamos null (Todo OK)
        return null; 
    }
}
