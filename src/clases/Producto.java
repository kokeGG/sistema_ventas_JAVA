package clases;

/**
 *
 * @author koke
 */
public class Producto {
    int stock;
    String nombre, dni;
    double precio;

    public Producto() {
    }

    public Producto(double precio, int stock, String nombre, String dni) {
        this.precio = precio;
        this.stock = stock;
        this.nombre = nombre;
        this.dni = dni;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
}
