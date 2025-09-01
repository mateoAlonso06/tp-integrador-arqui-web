package com.integrador.utils;

import com.integrador.entity.Cliente;
import com.integrador.entity.Factura;
import com.integrador.entity.FacturaProducto;
import com.integrador.entity.Producto;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HelperMySQL {
    private Connection conn = null;

    public HelperMySQL() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String uri = "jdbc:mysql://localhost:3306/integrador";

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dropTables() throws SQLException {
        String dropCliente = "DROP TABLE IF EXISTS clientes";
        this.conn.prepareStatement(dropCliente).execute();
        this.conn.commit();

        String dropProducto = "DROP TABLE IF EXISTS productos";
        this.conn.prepareStatement(dropProducto).execute();
        this.conn.commit();

        String dropFactura = "DROP TABLE IF EXISTS facturas";
        this.conn.prepareStatement(dropFactura).execute();
        this.conn.commit();

        String dropfacturaProducto = "DROP TABLE IF EXISTS facturas_producto";
        this.conn.prepareStatement(dropfacturaProducto).execute();
        this.conn.commit();
    }


    public void createTables() throws SQLException {
        String createCliente = "CREATE TABLE IF NOT EXISTS clientes ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "nombre VARCHAR(100) NOT NULL,"
                + "email VARCHAR(100) NOT NULL UNIQUE"
                + ")";
        this.conn.prepareStatement(createCliente).execute();
        this.conn.commit();

        String createProducto = "CREATE TABLE IF NOT EXISTS productos ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "nombre VARCHAR(100) NOT NULL,"
                + "valor FLOAT(10, 2) NOT NULL"
                + ")";
        this.conn.prepareStatement(createProducto).execute();
        this.conn.commit();

        String createFactura = "CREATE TABLE IF NOT EXISTS facturas ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "cliente_id INT,"
                + "FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE CASCADE"
                + ")";
        this.conn.prepareStatement(createFactura).execute();
        this.conn.commit();

        String createFacturaProducto = "CREATE TABLE IF NOT EXISTS facturas_producto ("
                + "factura_id INT,"
                + "producto_id INT,"
                + "cantidad INT NOT NULL,"
                + "PRIMARY KEY (factura_id, producto_id),"
                + "FOREIGN KEY (factura_id) REFERENCES facturas(id) ON DELETE CASCADE,"
                + "FOREIGN KEY (producto_id) REFERENCES productos(id) ON DELETE CASCADE"
                + ")";
        this.conn.prepareStatement(createFacturaProducto).execute();
        this.conn.commit();
    }

    private Iterable<CSVRecord> getData(String archivo) throws IOException {
        String path = "src\\main\\resources\\" + archivo;
        Reader in = new FileReader(path);
        String[] header = {};
        CSVParser csvParser = CSVFormat.EXCEL.withHeader(header).parse(in);

        Iterable<CSVRecord> records = csvParser.getRecords();
        return records;
    }

    public void populateDB() throws Exception {
        System.out.println("Populating DB...");
        try {
            // 1) Clientes
            for (CSVRecord row : getData("clientes.csv")) {
                // header: idCliente,nombre,email
                if (row.size() >= 3) {
                    String idS = row.get(0).trim();
                    String nombre = row.get(1).trim();
                    String email = row.get(2).trim();
                    if (!idS.isEmpty() && !nombre.isEmpty()) {
                        try {
                            int id = Integer.parseInt(idS);
                            Cliente c = new Cliente(id, nombre, email); // adapta constructor si es otro
                            insertCliente(c, conn);
                        } catch (NumberFormatException e) {
                            System.err.println("Cliente: formato inválido en fila -> " + e.getMessage());
                        }
                    }
                }
            }
            System.out.println("Clientes insertados");

            // 2) Productos
            for (CSVRecord row : getData("productos.csv")) {
                // header: idProducto,nombre,valor
                if (row.size() >= 3) {
                    String idS = row.get(0).trim();
                    String nombre = row.get(1).trim();
                    String valorS = row.get(2).trim();
                    if (!idS.isEmpty() && !valorS.isEmpty()) {
                        try {
                            int id = Integer.parseInt(idS);
                            float valor = Float.parseFloat(valorS); // si usás BigDecimal, parseá con new BigDecimal(valorS)
                            Producto p = new Producto(id, nombre, valor);
                            insertProducto(p, conn);
                        } catch (NumberFormatException e) {
                            System.err.println("Producto: formato inválido en fila -> " + e.getMessage());
                        }
                    }
                }
            }
            System.out.println("Productos insertados");

            // 3) Facturas
            for (CSVRecord row : getData("facturas.csv")) {
                // header: idFactura,idCliente
                if (row.size() >= 2) {
                    String idFS = row.get(0).trim();
                    String idClienteS = row.get(1).trim();
                    if (!idFS.isEmpty() && !idClienteS.isEmpty()) {
                        try {
                            int idFactura = Integer.parseInt(idFS);
                            int idCliente = Integer.parseInt(idClienteS);
                            Factura f = new Factura(idFactura, idCliente);
                            insertFactura(f, conn);
                        } catch (NumberFormatException e) {
                            System.err.println("Factura: formato inválido en fila -> " + e.getMessage());
                        }
                    }
                }
            }
            System.out.println("Facturas insertadas");

            // 4) Factura_Producto (relación)
            for (CSVRecord row : getData("facturas-productos.csv")) {
                // header: idFactura,idProducto,cantidad
                if (row.size() >= 3) {
                    String idFS = row.get(0).trim();
                    String idProdS = row.get(1).trim();
                    String cantS = row.get(2).trim();
                    if (!idFS.isEmpty() && !idProdS.isEmpty() && !cantS.isEmpty()) {
                        try {
                            int idFactura = Integer.parseInt(idFS);
                            int idProducto = Integer.parseInt(idProdS);
                            int cantidad = Integer.parseInt(cantS);
                            FacturaProducto fp = new FacturaProducto(idFactura, idProducto, cantidad);
                            insertFacturaProducto(fp, conn);
                        } catch (NumberFormatException e) {
                            System.err.println("Factura_Producto: formato inválido en fila -> " + e.getMessage());
                        }
                    }
                }
            }
            System.out.println("Relaciones factura-producto insertadas");
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace(); // como pediste: suficiente para el práctico
        }
    }

    private void insertCliente(Cliente cliente, Connection conn) throws Exception {
        String insert = "INSERT INTO clientes (id, nombre, email) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(insert)) {
            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getEmail());
            if (ps.executeUpdate() == 0) {
                throw new Exception("No se pudo insertar el cliente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertProducto(Producto producto, Connection conn) throws Exception {
        String insert = "INSERT INTO productos (id, nombre, valor) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(insert)) {
            ps.setInt(1, producto.getIdProducto());
            ps.setString(2, producto.getNombre());
            ps.setFloat(3, producto.getValor());
            if (ps.executeUpdate() == 0) {
                throw new Exception("No se pudo insertar el producto");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertFactura(Factura factura, Connection conn) throws Exception {
        String insert = "INSERT INTO facturas (id, cliente_id) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(insert)) {
            ps.setInt(1, factura.getIdFactura());
            ps.setInt(2, factura.getIdCliente());
            if (ps.executeUpdate() == 0) {
                throw new Exception("No se pudo insertar la factura");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertFacturaProducto(FacturaProducto facturaProducto, Connection conn) throws Exception {
        String insert = "INSERT INTO facturas_producto (factura_id, producto_id, cantidad) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(insert)) {
            ps.setInt(1, facturaProducto.getIdFactura());
            ps.setInt(2, facturaProducto.getIdProducto());
            ps.setInt(3, facturaProducto.getCantidad());
            if (ps.executeUpdate() == 0) {
                throw new Exception("No se pudo insertar la relación factura-producto");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
