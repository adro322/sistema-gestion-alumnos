/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Dao.Interfaces.IAlumnosDao;
import Modelo.Alumnos;
import Modelo.Sedes;
import Conexion.ConexionPostgreSQL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */

/*
Lo importante aquí es que, siguiendo el principio SRP (Responsabilidad Única)
Simplemente hacen el trabajo sucio con la base de datos y entregan los resultados 
 */


public class alumnosDao implements IAlumnosDao {

    private final Connection cn = ConexionPostgreSQL.getInstancia().conectar();

    @Override
    public List<Sedes> obtenerSedes() {
        List<Sedes> lista = new ArrayList<>();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select id_sede, nombre, direccion from sedes");
            while (rs.next()) {
                Sedes s = new Sedes();
                s.setId_sede(rs.getInt("id_sede"));
                s.setNombre(rs.getString("nombre"));
                s.setDireccion(rs.getString("direccion"));
                lista.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista; // Retorna la lista, NO llena el ComboBox
    }

    @Override
    public boolean registrar(Alumnos a) {
        String sql = "INSERT INTO alumnos (codigo, dni, telefono, nombres, apellidos, carrera, ciclo, email, promedio, estado, fecha_ingreso, id_sede) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, a.getCodigo());
            pst.setString(2, a.getDni());
            pst.setString(3, a.getTelefono());
            pst.setString(4, a.getNombres());
            pst.setString(5, a.getApellidos());
            pst.setString(6, a.getCarrera());
            pst.setInt(7, Integer.parseInt(a.getCiclo()));
            pst.setString(8, a.getEmail());
            pst.setDouble(9, a.getPromedio());
            pst.setString(10, a.getEstado());
            pst.setInt(11, a.getId_sede());

            int rpta = pst.executeUpdate();
            return rpta == 1; // Devuelve true si guardó
        } catch (Exception e) {
            e.printStackTrace();    
            return false;
        }
    }

    // ---------------------------------------------------------
    // MÉTODO ACTUALIZAR
    // Recibe el objeto Alumno completo con los nuevos datos
    //---------------------------------------------------------
    @Override
    public boolean actualizar(Alumnos a) {
        String sql = "UPDATE alumnos SET "
                + "codigo = ?, dni = ?, telefono = ?, nombres = ?, apellidos = ?, "
                + "carrera = ?, ciclo = ?, email = ?, promedio = ?, estado = ?, id_sede = ? "
                + "WHERE id = ?";

        try (PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, a.getCodigo());
            pst.setString(2, a.getDni());
            pst.setString(3, a.getTelefono());
            pst.setString(4, a.getNombres());
            pst.setString(5, a.getApellidos());
            pst.setString(6, a.getCarrera());
            pst.setInt(7, Integer.parseInt(a.getCiclo()));
            pst.setString(8, a.getEmail());
            pst.setDouble(9, a.getPromedio());
            pst.setString(10, a.getEstado());
            pst.setInt(11, a.getId_sede());
            pst.setInt(12, a.getId()); 

            int filasAfectadas = pst.executeUpdate();
            return filasAfectadas > 0; 

        } catch (Exception e) {
            System.err.println("Error al actualizar alumno: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // ---------------------------------------------------------
    // MÉTODO ELIMINAR
    // Solo necesitamos el ID para saber a quién borrar
    // ---------------------------------------------------------
    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM alumnos WHERE id = ?";
        try (PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, id);

            int filasAfectadas = pst.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception e) {
            System.err.println("Error al eliminar alumno: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // ---------------------------------------------------------
    // MÉTODO LISTAR TODOS
    // Devuelve una LISTA de objetos, no modifica el JTable
    // ---------------------------------------------------------
    @Override
    public List<Alumnos> listarTodos() {
        List<Alumnos> lista = new ArrayList<>();
        String sql = "SELECT * FROM pa_mostrarAlumnos()";
        try (Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Alumnos a = new Alumnos();
                a.setId(rs.getInt("id"));
                a.setCodigo(rs.getString("codigo"));
                a.setDni(rs.getString("dni"));
                a.setTelefono(rs.getString("telefono"));
                a.setNombres(rs.getString("nombres"));
                a.setApellidos(rs.getString("apellidos"));
                a.setCarrera(rs.getString("carrera"));
                a.setCiclo(String.valueOf(rs.getInt("ciclo")));
                a.setEmail(rs.getString("email"));
                a.setPromedio(rs.getDouble("promedio"));
                a.setEstado(rs.getString("estado"));
                a.setFecha_ingreso(rs.getDate("fecha_ingreso").toString());
                a.setNombreSede(rs.getString("sede"));

                lista.add(a);
            }

        } catch (Exception e) {
            System.err.println("Error al listar alumnos: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }

    // ---------------------------------------------------------
    // MÉTODO BUSCAR POR APELLIDOS
    // Devuelve lista porque pueden haber varios con el mismo apellido
    // ---------------------------------------------------------
    @Override
    public List<Alumnos> buscarPorApellidos(String apellidos) {
        List<Alumnos> lista = new ArrayList<>();
        String sql = "SELECT * FROM pa_buscaralumnosApellidos(?::varchar)";

        try (PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, "%" + apellidos + "%"); 

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Alumnos a = new Alumnos();
                    a.setId(rs.getInt("id"));
                    a.setCodigo(rs.getString("codigo"));
                    a.setDni(rs.getString("dni"));
                    a.setTelefono(rs.getString("telefono"));
                    a.setNombres(rs.getString("nombres"));
                    a.setApellidos(rs.getString("apellidos"));
                    a.setCarrera(rs.getString("carrera"));
                    a.setCiclo(String.valueOf(rs.getInt("ciclo")));
                    a.setEmail(rs.getString("email"));
                    a.setPromedio(rs.getDouble("promedio"));
                    a.setEstado(rs.getString("estado"));
                    a.setFecha_ingreso(rs.getDate("fecha_ingreso").toString());
                    a.setNombreSede(rs.getString("sede"));

                    lista.add(a);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al buscar alumnos: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }

}
