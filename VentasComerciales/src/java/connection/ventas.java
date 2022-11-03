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
public class ventas {
    private String fecha;
    private String Comercial;
    private double precio;
    private int cantidad;
    private double total,totalDescuento;
    private int descuento;
    
    private String codComercial;
    private String referenciaProducto;
    

    public ventas(String fecha, String Comercial, int cantidad, double precio, double total, int descuento, double totalDescuento) {
        this.fecha = fecha;
        this.Comercial = Comercial;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
        this.totalDescuento = totalDescuento;
        this.descuento = descuento;
    }

    public ventas(String fecha, int cantidad, String codComercial, String referenciaProducto) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.codComercial = codComercial;
        this.referenciaProducto = referenciaProducto;
    }

    public String getCodComercial() {
        return codComercial;
    }

    public void setCodComercial(String codComercial) {
        this.codComercial = codComercial;
    }

    public String getReferenciaProducto() {
        return referenciaProducto;
    }

    public void setReferenciaProducto(String referenciaProducto) {
        this.referenciaProducto = referenciaProducto;
    }
    
    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getComercial() {
        return Comercial;
    }

    public void setComercial(String Comercial) {
        this.Comercial = Comercial;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(double totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
}
    

