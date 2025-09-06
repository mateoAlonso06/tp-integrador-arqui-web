package com.integrador;

import com.integrador.dao.ClienteDAO;
import com.integrador.dao.ProductoDAO;
import com.integrador.entity.Cliente;
import com.integrador.entity.DBType;
import com.integrador.entity.Producto;
import com.integrador.factory.AbstractFactory;
import com.integrador.utils.HelperMySQL;

public class Main {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/integrador";
        String username = "root";
        String password = "";

        HelperMySQL dbMySQL = new HelperMySQL(driver, url, username, password);

//        dbMySQL.dropTables();
//        dbMySQL.createTables();
//        dbMySQL.populateDB();
//        dbMySQL.closeConnection();

        // 1. Elegir la fabrica
        AbstractFactory chosenFactory = AbstractFactory.getFactory(DBType.MYSQL);

        // 2. Obtengo el dao
        ClienteDAO clienteDAO = chosenFactory.getClienteDao();
        ProductoDAO productoDAO = chosenFactory.getProductoDao();

        // Consigna nº3
        System.out.println("Producto que mas recaudo");
        Producto productoMasRecaudo = productoDAO.getMostExpensiveProduct();

        System.out.println(productoMasRecaudo);

        // Consigna nº4
        System.out.println("Listado de clientes ordenado por facturas");
        for (Cliente cliente : clienteDAO.getClientesOrderByFacturas()) {
            System.out.println(cliente);
        }
    }
}
