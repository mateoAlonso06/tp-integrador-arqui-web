package com.integrador.factory.concret;

import com.integrador.dao.ClienteDAO;
import com.integrador.dao.ProductoDAO;
import com.integrador.dao.db.MySQLClienteDAO;
import com.integrador.dao.db.MySQLProductoDAO;
import com.integrador.factory.AbstractFactory;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAOFactory extends AbstractFactory {
    private static MySQLDAOFactory INSTANCE;

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String uri = "jdbc:mysql://localhost:3306/integrador";

    private static Connection conn;

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

    public static Connection createConnection() {
        if (conn != null) {
            return conn;
        }
        String driver = DRIVER;
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                 | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            conn = DriverManager.getConnection(uri, "root", "");
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ClienteDAO getClienteDao() {
        return new MySQLClienteDAO(createConnection());
    }

    @Override
    public ProductoDAO getProductoDao() {
        return new MySQLProductoDAO(createConnection());
    }
}
