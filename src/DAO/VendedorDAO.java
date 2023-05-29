package DAO;

import clases.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author koke
 */
public class VendedorDAO implements CRUD{
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Conexion cn = new Conexion();
    
    public Vendedor listarVendedorID(String dni){
        Vendedor v = new Vendedor();
        String sql = "SELECT * FROM Vendedor";
        
        try {
            
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            while (rs.next()) {
                v.setId(rs.getInt(1));
                v.setPass(rs.getString(2));
                v.setNom(rs.getString(3));
                v.setUser(rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println("Error al listar ID de los vendedores");
        }
        return v;
    }
    
    public Vendedor validarVendedor(String pass, String user){
        Vendedor v = new Vendedor();
        String sql = "SELECT * FROM Vendedor WHERE pass = ? AND user = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, user);
            rs = ps.executeQuery();
            
            while (rs.next()) {      
                v.setId(rs.getInt(1));
                v.setPass(rs.getString(2));
                v.setNom(rs.getString(3));
                v.setUser(rs.getString(4));
                
               
            }
        } catch (Exception e) {
            System.out.println(v.getId() + " " + v.getPass() + " " + v.getNom() + " " + v.getUser());
            System.out.println("Error to validate user");
            
        }
        return v;
    }

    @Override
    public List listar() {
        List<Vendedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vendedor";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                Vendedor ven = new Vendedor();
                ven.setId(rs.getInt(1));
                ven.setPass(rs.getString(2));
                ven.setNom(rs.getString(3));
                ven.setUser(rs.getString(4));
                
                lista.add(ven);
                System.out.println("Vendedores mostrados");
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar vendedores " + e);
        }
        
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "INSERT INTO Vendedor (pass, nombre, user) VALUES (?, ?, ?)";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            r = ps.executeUpdate();
            System.out.println("Vendedores insertados");
        } catch (Exception e) {
            System.out.println("Error al insertar vendedores" + e);
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE Vendedor SET pass = ?, nombre = ?, user = ? WHERE idVendedor = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            r = ps.executeUpdate();
            System.out.println("Vendedores Modificados");
        } catch (Exception e) {
            System.out.println("Error al modificar vendedores" + e);
        }
        
        return r;
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM Vendedor WHERE idVendedor = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            ps.executeUpdate();
            System.out.println("Vendedor eliminado");
            
        } catch (Exception e) {
            System.out.println("Error al eliminar vendedor" + e);
        }
    }
    
}
