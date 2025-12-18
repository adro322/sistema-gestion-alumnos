/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio.Estrategias;

import Modelo.Usuario;

public interface IUsuarioEstrategia {

    // Validar datos al registrarse
    String validarRegistro(Usuario u);

    // Validar cambio de contraseña (reglas de coincidencia y fortaleza)
    String validarCambioClave(String nueva, String confirmacion);
}
