package com.integrador.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacturaProducto {
    private Integer idFactura;
    private Integer idProducto;
    private Integer cantidad;

    public FacturaProducto(int idFactura, int idProducto, int cantidad) {
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return String.format("Factura_Producto [ID Factura: %d, ID Producto: %d, Cantidad: %d]", idFactura, idProducto, cantidad);
    }
}
