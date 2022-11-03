/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

/**
 *
 * @author Andres
 */
public class Producto {

    private String referencia,nombre,descripcion;
    private double precio;
    private int descuento;

    public Producto(String referencia, String nombre, String descripcion, double precio, int descuento) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuento = descuento;
    }

    public Producto(String referencia, String nombre, String descripcion) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Producto(String referencia) {
        this.referencia = referencia;
    }
    

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
    
    
}
