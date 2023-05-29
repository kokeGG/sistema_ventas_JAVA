package DAO;

import clases.DetalleVentas;
import clases.Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author koke
 */
public class VentasDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    int r = 0;
    
    public String noSerieVentas(){
        String serie = "";
        String sql = "SELECT MAX(numeroSerie) FROM Venta";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                serie = rs.getString(1);
                
            }
        } catch (Exception e) {
            System.out.println("Error en el numero de serie" + e);
        }
        return serie;
    }
    
    public String idVenta(){
        String idV = "";
        String sql = "SELECT MAX(idVenta) FROM Venta";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                idV = rs.getString(1);
                
            }
        } catch (Exception e) {
            System.out.println("Error en el numero de serie" + e);
        }
        return idV;
    }
    
    public int guardarVentas(Ventas v){
        String sql = "INSERT INTO Venta(idVendedor, numeroSerie, fechaVenta, monto) VALUES(?, ?, ?, ?)";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getIdVendedor());
            ps.setString(2, v.getSerie());
            ps.setString(3, v.getFecha());
            ps.setDouble(4, v.getMonto());
            r = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al guardar venta" + e);
        }
        return r;
    }
    
    
    /*public int guardarVentas(Ventas v){
        String sql = "INSERT INTO ventas(IdCliente, IdVendedor, NumeroSerie, FechaVentas, Monto, Estado) VALUES(?, ?, ?, ?, ?, ?)";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getIdCliente());
            ps.setInt(2, v.getIdVendedor());
            ps.setString(3, v.getSerie());
            ps.setString(4, v.getFecha());
            ps.setDouble(5, v.getMonto());
            ps.setString(6, v.getEstado());
            r = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al guardar venta" + e);
        }
        return r;
    }*/
    
    public int guardarDetalleVenta(DetalleVentas dv){
        String sql = "INSERT INTO detalleVenta(idVenta, dni, cantidad, precioVenta) VALUES (?, ?, ?, ?)";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dv.getIdVentas());
            ps.setString(2, dv.getIdProducto());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getPreVenta());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al generar detalle ventas" + e);
        }
        return r;
    }
    
}
