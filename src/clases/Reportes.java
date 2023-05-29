/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author koke
 */
public class Reportes {
    String serie, fecha, nombre;
    double monto;
    int cantidad, precioVenta, month, year;

    public Reportes() {
    }

    public Reportes(String serie, String fecha, String nombre, double monto, int cantidad, int precioVenta, int month, int year) {
        this.serie = serie;
        this.fecha = fecha;
        this.nombre = nombre;
        this.monto = monto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.month = month;
        this.year = year;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    public int getMonth() {
        return month;
    }
    
    public void setMonth (int month) {
        this.month = month;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear (int year) {
        this.year = year;
    }
}
