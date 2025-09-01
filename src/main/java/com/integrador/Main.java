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
        HelperMySQL dbMySQL = new HelperMySQL();

        dbMySQL.dropTables();
        dbMySQL.createTables();
        dbMySQL.populateDB();
        dbMySQL.closeConnection();

        AbstractFactory chosenFactory = AbstractFactory.getFactory(DBType.MYSQL);
        System.out.println();
        System.out.println("////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////");
        System.out.println();

        ClienteDAO clienteDAO = chosenFactory.getClienteDao();
        ProductoDAO productoDAO = chosenFactory.getProductoDao();

        System.out.println("Producto que mas recaudo");
        Producto productoMasRecaudo = productoDAO.getMostExpensiveProduct();

        System.out.println(productoMasRecaudo);

        System.out.println("nahuel kukita");

        System.out.println("Listado de clientes ordenado por facturas");
        for (Cliente cliente : clienteDAO.getClientesOrderByFacturas()) {
            System.out.println(cliente);
        }
    }
}
