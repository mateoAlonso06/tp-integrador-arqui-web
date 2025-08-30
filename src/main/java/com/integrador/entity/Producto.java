package com.integrador.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producto {
    private Integer idProducto;
    private String nombre;
    private float valor;

    public Producto() {
    }

    public Producto(int idProducto, String nombre, float valor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("Producto [ID: %d, Nombre: %s, Precio: %.2f]", idProducto, nombre, valor);
    }
}
