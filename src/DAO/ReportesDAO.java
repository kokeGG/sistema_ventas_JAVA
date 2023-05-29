/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import clases.Reportes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author koke
 */
public class ReportesDAO {

    int r;
    Conexion cn = new Conexion();

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        List<Reportes> lista = new ArrayList<>();
        String sql = "SELECT Venta.numeroSerie, Venta.fechaVenta, Venta.monto, Producto.nombre, detalleVenta.cantidad, detalleVenta.precioVenta\n"
                + "FROM detalleVenta\n"
                + "INNER JOIN Venta on Venta.idVenta = detalleVenta.idVenta\n"
                + "INNER JOIN Producto on detalleVenta.dni = Producto.dni\n"
                + "ORDER BY Venta.numeroSerie DESC";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Reportes rep = new Reportes();
                rep.setSerie(rs.getString(1));
                rep.setFecha(rs.getString(2));
                rep.setMonto(rs.getDouble(3));
                rep.setNombre(rs.getString(4));
                rep.setCantidad(rs.getInt(5));
                rep.setPrecioVenta(rs.getInt(6));
                lista.add(rep);
                System.out.println("Reportes mostrados");
            }

        } catch (Exception e) {
            System.out.println("Error al mostrar reportes" + e);
        }
        return lista;
    }

    public List listarReportesFiltro(int month, int year) {
        List<Reportes> lista = new ArrayList<>();
        String sql = "SELECT Venta.numeroSerie, Venta.fechaVenta, Venta.monto, Producto.nombre, detalleVenta.cantidad, detalleVenta.precioVenta\n"
                + "FROM detalleVenta\n"
                + "INNER JOIN Venta on Venta.idVenta = detalleVenta.idVenta\n"
                + "INNER JOIN Producto on detalleVenta.dni = Producto.dni\n"
                + "WHERE month(Venta.fechaVenta) = ? AND YEAR(Venta.fechaVenta) = ?";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, month);
            ps.setInt(2, year);
            rs = ps.executeQuery();
            while (rs.next()) {
                Reportes rep = new Reportes();
                rep.setSerie(rs.getString(1));
                rep.setFecha(rs.getString(2));
                rep.setMonto(rs.getDouble(3));
                rep.setNombre(rs.getString(4));
                rep.setCantidad(rs.getInt(5));
                rep.setPrecioVenta(rs.getInt(6));
                lista.add(rep);
            }
        } catch (Exception e) {
            System.out.println("Error al listar reportes");
        }
        return lista;
    }

}
