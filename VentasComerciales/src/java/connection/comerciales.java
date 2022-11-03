/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Date;

/**
 *
 * @author Andres
 */
public class comerciales {
    
    private String codigo;
    private String nombre;
    private double salario;
    private int hijos;
    private java.sql.Date fechaNacimiento;

    public comerciales(String codigo, String nombre, double salario, int hijos, Date fechaNacimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salario = salario;
        this.hijos = hijos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public comerciales(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public comerciales(String codigo, String nombre, double salario, int hijos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salario = salario;
        this.hijos = hijos;
    }
    
    

    
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getHijos() {
        return hijos;
    }

    public void setHijos(int hijos) {
        this.hijos = hijos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
    
}
