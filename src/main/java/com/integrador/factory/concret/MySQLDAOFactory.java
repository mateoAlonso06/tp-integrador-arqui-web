package com.integrador.factory.concret;

import com.integrador.dao.ClienteDAO;
import com.integrador.dao.ProductoDAO;
import com.integrador.dao.db.MySQLClienteDAO;
import com.integrador.dao.db.MySQLProductoDAO;
import com.integrador.factory.AbstractFactory;

import java.sql.Connection;

public class MySQLDAOFactory extends AbstractFactory {
    private static MySQLDAOFactory INSTANCE;

    private MySQLDAOFactory() {
    }

    public static MySQLDAOFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (MySQLDAOFactory.class) {
            /*El uso del synchronized es debido a la posible creacion de dos
            * instancias en un entorno multithread por lo que es conveniente usarlo*/
                if (INSTANCE == null) {
                    INSTANCE = new MySQLDAOFactory();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public ClienteDAO getClienteDao(Connection connection) {
        return new MySQLClienteDAO(connection);
    }

    @Override
    public ProductoDAO getProductoDao(Connection connection) {
        return new MySQLProductoDAO(connection);
    }
}
