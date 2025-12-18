/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USER
 */
public class Alumnos {
    private int id;
    private String codigo;
    private String dni;
    private String telefono;
    private String nombres;
    private String apellidos;
    private String carrera;
    private String ciclo;
    private String email;
    private double promedio;
    private String estado;
    private String fecha_ingreso;
    private int id_sede;
    private String nombreSede;

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
    this.nombreSede = nombreSede;
}
    
    public Alumnos(){
        
    }

    public Alumnos(int id, String codigo, String dni, String telefono, String nombres, String apellidos, String carrera, String ciclo, String email, double promedio, String estado, String fecha_ingreso, int id_sede) {
        this.id = id;
        this.codigo = codigo;
        this.dni = dni;
        this.telefono = telefono;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.carrera = carrera;
        this.ciclo = ciclo;
        this.email = email;
        this.promedio = promedio;
        this.estado = estado;
        this.fecha_ingreso = fecha_ingreso;
        this.id_sede = id_sede;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getId_sede() {
        return id_sede;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }
    
    
    
}

