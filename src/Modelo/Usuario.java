/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USER
 */
public class Usuario {
    private int id;
    private String nombre;           
    private String usuario;
    private String correo;          
    private String password;        
    private String rol;
    private String preguntaSecreta;  
    private String respuestaSecreta;

    public Usuario() {
    }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRol() {
            return rol;
        }

        public void setRol(String rol) {
            this.rol = rol;
        }

        public String getPreguntaSecreta() {
            return preguntaSecreta;
        }

        public void setPreguntaSecreta(String preguntaSecreta) {
            this.preguntaSecreta = preguntaSecreta;
        }

        public String getRespuestaSecreta() {
            return respuestaSecreta;
        }

        public void setRespuestaSecreta(String respuestaSecreta) {
            this.respuestaSecreta = respuestaSecreta;
        }
    
}
