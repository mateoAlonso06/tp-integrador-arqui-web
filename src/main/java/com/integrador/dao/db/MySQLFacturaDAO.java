package com.integrador.dao.db;

import com.integrador.dao.FacturaDAO;
import com.integrador.entity.Factura;

import java.util.List;

public class MySQLFacturaDAO implements FacturaDAO {
    @Override
    public void insert(Factura entity) {

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
        return List.of();
    }
}
