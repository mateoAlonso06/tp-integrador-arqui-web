package com.integrador.factory;

import com.integrador.dao.ClienteDAO;
import com.integrador.dao.ProductoDAO;
import com.integrador.entity.DBType;
import com.integrador.factory.concret.MySQLDAOFactory;
import com.integrador.factory.concret.PostgresSQLDAOFactory;

public abstract class AbstractFactory {
    public abstract ClienteDAO getClienteDao();

    public abstract ProductoDAO getProductoDao();

    public static AbstractFactory getFactory(DBType type) {
        return switch (type) {
            case MYSQL -> MySQLDAOFactory.getInstance();
            case POSTGRESQL -> PostgresSQLDAOFactory.getInstance();
            // case DERBY -> new DerbyDAOFactory();
            // case MONGODB -> new MongoDBDAOFactory();
        };
    }
}
