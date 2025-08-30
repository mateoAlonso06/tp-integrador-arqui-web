package com.integrador.dao;

import com.integrador.entity.Producto;

public interface ProductoDAO extends DAO<Producto, Integer> {
    public Producto getMostExpensiveProduct();
}
