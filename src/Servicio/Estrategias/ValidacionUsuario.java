/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio.Estrategias;

import Modelo.Usuario;

/**
 *
 * @author USER
 */
public class ValidacionUsuario implements IUsuarioEstrategia{

    @Override
    public String validarRegistro(Usuario u) {
        if (u.getNombre().isEmpty() || u.getUsuario().isEmpty() || u.getPassword().isEmpty()) {
            return "Error: Todos los campos son obligatorios.";
        }
        return null; // Todo OK
    }

    @Override
    public String validarCambioClave(String nueva, String confirmacion) {
        if (nueva.isEmpty() || confirmacion.isEmpty()) {
            return "Complete los campos de contraseña.";
        }
        if (!nueva.equals(confirmacion)) {
            return "Las contraseñas no coinciden.";
        }
        return null; // Todo OK
    }
}
