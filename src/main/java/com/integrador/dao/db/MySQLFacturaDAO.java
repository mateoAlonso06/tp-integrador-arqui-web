package com.integrador.dao.db;

import com.integrador.dao.FacturaDAO;
import com.integrador.entity.Factura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MySQLFacturaDAO implements FacturaDAO {
    private Connection conn;

    public MySQLFacturaDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Factura entity) {
        String query = "INSERT INTO facturas (id, cliente_id) VALUES (?, ?)";
        // Implement JDBC code to execute the insert statement
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, entity.getIdFactura());
            ps.setInt(2, entity.getIdCliente());
            ps.executeUpdate();
            System.out.println("Factura inserted successfully.");
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
    public void delete(Integer id) {

    }

    @Override
    public Factura getById(Integer id) {
        return null;
    }

    @Override
    public List<Factura> getAll() {
        return null;
    }
}
