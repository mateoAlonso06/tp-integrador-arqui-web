package com.integrador.factory.concret;

import com.integrador.dao.ClienteDAO;
import com.integrador.dao.ProductoDAO;
import com.integrador.factory.AbstractFactory;

import java.sql.Connection;

public class PostgresSQLDAOFactory extends AbstractFactory {
    private static PostgresSQLDAOFactory INSTANCE;

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String uri = "jdbc:mysql://localhost:3306/integrador";

    private static Connection conn;

    private PostgresSQLDAOFactory() {
        // Private constructor to prevent instantiation
    }

    public static PostgresSQLDAOFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (PostgresSQLDAOFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PostgresSQLDAOFactory();
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
