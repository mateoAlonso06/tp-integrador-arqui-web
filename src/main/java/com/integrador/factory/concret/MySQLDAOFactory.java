package com.integrador.factory.concret;

import com.integrador.dao.ClienteDAO;
import com.integrador.dao.ProductoDAO;
import com.integrador.factory.AbstractFactory;

public class MySQLDAOFactory extends AbstractFactory {
    private static MySQLDAOFactory INSTANCE;

    private MySQLDAOFactory() {}

    public static MySQLDAOFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (MySQLDAOFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MySQLDAOFactory();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public ClienteDAO getClienteDao() {
        return null;
    }

    @Override
    public ProductoDAO getProductoDao() {
        return null;
    }
}
