package com.integrador.factory;

import com.integrador.dao.ClienteDAO;
import com.integrador.dao.ProductoDAO;
import com.integrador.entity.DBType;
import com.integrador.factory.concret.MySQLDAOFactory;
import com.integrador.factory.concret.PostgresSQLDAOFactory;

public abstract class AbstractFactory {
    public abstract ClienteDAO getClienteDao();

    public abstract ProductoDAO getProductoDao();

    public abstract void closeConnection();

    public static AbstractFactory getFactory(DBType type) {
        AbstractFactory resultado = null;
        switch (type) {
            case MYSQL:
                resultado = MySQLDAOFactory.getInstance();
                break;
            case POSTGRESQL:
                resultado = PostgresSQLDAOFactory.getInstance();
                break;
            // case DERBY -> new DerbyDAOFactory();
            // case MONGODB -> new MongoDBDAOFactory();
            default:
                resultado = null;
                break;
        }
        return resultado;
    }
}
