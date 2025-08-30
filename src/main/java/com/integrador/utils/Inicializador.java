package com.integrador.utils;

public class Inicializador {
    private Connection connection;




    private Iterable<CSVRecord> getData(String archivo) throws IOException {
        String path = "src\\main\\resources\\csv\\" + archivo;
        Reader in = new FileReader(path);
        String[] header = {};
        CSVParser csvParser = CSVFormat.EXCEL.withHeader(header).parse(in);

        Iterable<CSVRecord> records = csvParser.getRecords();
        return records;
    }

    public void populateDB() throws Exception {
        try {
            System.out.println("Populating DB...");
            for(CSVRecord row : getData("clientes.csv")) {
                if(row.size() >= 3) { // Verificar que hay al menos 4 campos en el CSVRecord
                    String idString = row.get(0);

                    if(!idString.isEmpty() ) {
                        try {
                            int id = Integer.parseInt(idString);

                            Cliente cliente = new Cliente(id, row.get(1), row.get(2));
                            insertCliente(cliente, conn);
                        } catch (NumberFormatException e) {
                            System.err.println("Error de formato en datos de direcciÃ³n: " + e.getMessage());
                        }
                    }
                }
            }
            System.out.println("Clientes insertados");

            for (CSVRecord row : getData("facturas.csv")) {
                if (row.size() >= 2) { // Verificar que hay al menos 4 campos en el CSVRecord
                    String idFacturaString = row.get(0);
                    String idClienteString = row.get(1);

                    if (!idFacturaString.isEmpty() && !idClienteString.isEmpty() ) {
                        try {
                            int idFactura = Integer.parseInt(idFacturaString);
                            int idCliente = Integer.parseInt(idClienteString);

                            Facturas factura = new Facturas(idFactura, idCliente);
                            insertFactura(factura, conn);
                        } catch (NumberFormatException e) {
                            System.err.println("Error de formato en datos de factura: " + e.getMessage());
                        }
                    }
                }
            }

            System.out.println("Facturas insertadas");

            for (CSVRecord row : getData("productos.csv")) {
                if (row.size() >= 2) { // Verificar que hay al menos 2 campos en el CSVRecord
                    String idProductoString = row.get(0);
                    String nombre = row.get(1);
                    double valorProducto = Double.parseDouble(row.get("valor"));

                    if (!idProductoString.isEmpty() && !nombre.isEmpty()) {
                        try {
                            int idProducto = Integer.parseInt(idProductoString);

                            Producto producto = new Producto(idProducto, nombre,valorProducto);
                            insertProducto(producto, conn);
                        } catch (NumberFormatException e) {
                            System.err.println("Error de formato en datos de producto: " + e.getMessage());
                        }
                    }
                }
            }

            System.out.println("Productos insertados");
            for (CSVRecord row : getData("facturas-productos.csv")) {
                if (row.size() >= 3) { // Verificar que hay al menos 4 campos en el CSVRecord
                    String idFacturaString = row.get(0);
                    String idProductoString = row.get(1);
                    String cantidadString = row.get(2);

                    if (!idFacturaString.isEmpty() && !idProductoString.isEmpty() ) {
                        try {
                            int idFactura = Integer.parseInt(idFacturaString);
                            int idProducto = Integer.parseInt(idProductoString);
                            int cantidad = Integer.parseInt(cantidadString);

                            FacturaProducto facturaProducto = new FacturaProducto(idFactura, idProducto,cantidad);
                            insertFacturaProducto(facturaProducto, conn);
                        } catch (NumberFormatException e) {
                            System.err.println("Error de formato en datos de factura Producot: " + e.getMessage());
                        }
                    }
                }
            }

            System.out.println("Factura- productos insertadas");



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
