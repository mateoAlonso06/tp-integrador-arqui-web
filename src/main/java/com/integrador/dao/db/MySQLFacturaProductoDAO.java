package com.integrador.dao.db;

import com.integrador.dao.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MySQLFacturaProductoDAO implements DAO {
    private final Connection conn;

    public MySQLFacturaProductoDAO(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void insert(Object entity) {
        String query = "INSERT INTO facturas_producto (factura_id, producto_id, cantidad) VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public Object getById(Object id) {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }
}
