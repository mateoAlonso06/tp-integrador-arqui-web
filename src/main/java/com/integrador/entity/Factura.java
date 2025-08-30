package com.integrador.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Factura {
    private Integer idFactura;
    private Integer idCliente;

    public Factura() {
    }

    public Factura(int idFactura, int idCliente) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return String.format("Factura [ID: %d, ID Cliente: %d]", idFactura, idCliente);
    }
}
