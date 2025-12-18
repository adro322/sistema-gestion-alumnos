/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Dao.Interfaces.IUsuarioDao;
import Modelo.Usuario;
import Servicio.Estrategias.IUsuarioEstrategia;
import Servicio.Estrategias.ValidacionUsuario;

public class UsuarioService {

    private final IUsuarioDao usuarioDao;
    private final IUsuarioEstrategia estrategiaValidacion;

    public UsuarioService(IUsuarioDao dao) {
        this.usuarioDao = dao;
        this.estrategiaValidacion = new ValidacionUsuario();
    }

    // ----------------------------------------------------------------
    // LOGIN 
    // ----------------------------------------------------------------
    public Usuario validarLogin(String usuario, String password) {
        if (usuario == null || usuario.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Por favor, complete todos los campos.");
        }

        Usuario usuarioEncontrado = usuarioDao.login(usuario, password);

        if (usuarioEncontrado == null) {
            throw new SecurityException("Usuario o contraseña incorrectos.");
        }
        return usuarioEncontrado;
    }

    // ----------------------------------------------------------------
    // REGISTRO 
    // ----------------------------------------------------------------
    public String registrarUsuario(Usuario u) {
        // 1. Delegamos la validación a la Estrategia
        String error = estrategiaValidacion.validarRegistro(u);
        if (error != null) {
            return error;
        }

        // 2. Si pasa, guardamos
        if (usuarioDao.registrar(u)) {
            return "Usuario registrado correctamente.";
        } else {
            return "Error: No se pudo registrar (¿Quizás el usuario ya existe?).";
        }
    }

    // ----------------------------------------------------------------
    // RECUPERACIÓN (Lógica simple de búsqueda)
    // ----------------------------------------------------------------
    public String buscarPregunta(String usuario) {
        if (usuario.isEmpty()) {
            throw new IllegalArgumentException("Ingrese un usuario.");
        }

        String pregunta = usuarioDao.obtenerPreguntaSecreta(usuario);
        if (pregunta == null) {
            throw new SecurityException("El usuario no existe.");
        }

        return pregunta;
    }

    public boolean verificarRespuesta(String usuario, String respuestaIngresada) {
        String respuestaReal = usuarioDao.obtenerRespuestaSecreta(usuario);
        return respuestaReal != null && respuestaReal.equalsIgnoreCase(respuestaIngresada);
    }

    // ----------------------------------------------------------------
    // CAMBIO DE CONTRASEÑA 
    // ----------------------------------------------------------------
    public String cambiarContrasena(String usuario, String nueva, String confirmacion) {
        String error = estrategiaValidacion.validarCambioClave(nueva, confirmacion);
        if (error != null) {
            return error;
        }

        // 2. Si pasa, actualizamos
        if (usuarioDao.actualizarContrasena(usuario, nueva)) {
            return "Contraseña actualizada correctamente.";
        } else {
            return "Error al actualizar contraseña.";
        }
    }
}
