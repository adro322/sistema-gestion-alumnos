/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static org.apache.commons.compress.harmony.pack200.PackingOptions.PASS;

/**
 *
 * @author
 */
public class ConexionPostgreSQL {

    private static ConexionPostgreSQL instancia;
    private Connection cx;

    //Configuración de la BD
    private final String DB = "base_project2";
    private final String URL = "jdbc:postgresql://localhost:5432/" + DB;
    private final String USER = "postgres";
    private final String PASSWORD = "root";
    private final String DRIVER = "org.postgresql.Driver";

    //Constructor PRIVADO: Nadie puede hacer "new ConexionPostgreSql()" desde fuera
    private ConexionPostgreSQL() {
        try {
            Class.forName("org.postgresql.Driver");
            this.cx = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("SE CONECTO A " + DB);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERROR DE CONEXION: " + ex.getMessage());
        }
    }

//Método público estático para obtener la instancia única
    public static ConexionPostgreSQL getInstancia() {
        if (instancia == null) {
            instancia = new ConexionPostgreSQL();
            return instancia;
        }
        try {
            if (instancia.cx == null || instancia.cx.isClosed()) {
                instancia = new ConexionPostgreSQL();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instancia;
    }

    public Connection conectar() {
        return cx;
    }

    public static void main(String[] args) {
        getInstancia();

    }

}
