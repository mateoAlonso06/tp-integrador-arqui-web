package com.integrador.dao.db;

import com.integrador.dao.ProductoDAO;
import com.integrador.entity.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class MySQLProductoDAO implements ProductoDAO {
    private final Connection conn;

    public MySQLProductoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Producto getMostExpensiveProduct() {
        String query = "SELECT p.idProducto, p.nombre, p.valor, " +
                "COALESCE(SUM(fp.cantidad * p.valor), 0) AS recaudacion " +
                "FROM Producto p " +
                "LEFT JOIN Factura_Producto fp ON p.idProducto = fp.idProducto " +
                "GROUP BY p.idProducto, p.nombre, p.valor " +
                "ORDER BY recaudacion DESC " +
                "LIMIT 1";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Producto producto = null;
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setValor(rs.getFloat("valor"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return producto;
    }

    @Override
    public void insert(Producto entity) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Producto getById(Integer id) {
        return null;
    }

    @Override
    public List<Producto> getAll() {
        return null;
    }
}
