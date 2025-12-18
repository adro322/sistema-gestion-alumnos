/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author USER
 */
import Dao.Interfaces.IUsuarioDao;
import Modelo.Usuario;
import Conexion.ConexionPostgreSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class usuarioDao implements IUsuarioDao {

    private final Connection cn = ConexionPostgreSQL.getInstancia().conectar();

    @Override
    public Usuario login(String usuario, String password) {
        Usuario u = null;
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";

        try ( PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setNombre(rs.getString("nombre"));
                    u.setUsuario(rs.getString("usuario"));
                    u.setCorreo(rs.getString("correo"));
                    u.setRol(rs.getString("rol"));
                    u.setPreguntaSecreta(rs.getString("pregunta_secreta"));
                    u.setRespuestaSecreta(rs.getString("respuesta_secreta"));
                    // u.setPassword(rs.getString("contraseña")); // Opcional por seguridad
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public boolean registrar(Usuario u) {
        String sql = "INSERT INTO usuarios (nombre, usuario, correo, contraseña, rol, pregunta_secreta, respuesta_secreta) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try ( PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getUsuario());
            ps.setString(3, u.getCorreo());
            ps.setString(4, u.getPassword());
            ps.setString(5, u.getRol());
            ps.setString(6, u.getPreguntaSecreta());
            ps.setString(7, u.getRespuestaSecreta());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String obtenerPreguntaSecreta(String usuario) {
        String sql = "SELECT pregunta_secreta FROM usuarios WHERE usuario = ?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, usuario);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("pregunta_secreta");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Retorna null si no existe usuario
    }

    @Override
    public String obtenerRespuestaSecreta(String usuario) {
        String sql = "SELECT respuesta_secreta FROM usuarios WHERE usuario = ?";
        try ( PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, usuario);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("respuesta_secreta");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean actualizarContrasena(String usuario, String nueva) {
        String sql = "UPDATE usuarios SET contraseña = ? WHERE usuario = ?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nueva);
            ps.setString(2, usuario);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
