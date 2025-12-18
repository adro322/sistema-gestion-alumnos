/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
package Dao.Interfaces;

import Modelo.Usuario;

public interface IUsuarioDao {
    
    Usuario login(String usuario, String password);
    boolean registrar(Usuario u);
    String obtenerPreguntaSecreta(String usuario);
    String obtenerRespuestaSecreta(String usuario);
    boolean actualizarContrasena(String usuario, String nuevaContrasena);
    
}