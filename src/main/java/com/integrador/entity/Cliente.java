package com.integrador.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Cliente {
    private Integer idCliente;
    private String nombre;
    private String email;

    public Cliente() {
    }

    public Cliente(Integer idCliente, String nombre, String email) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return idCliente == cliente.idCliente && Objects.equals(nombre, cliente.nombre) && Objects.equals(email, cliente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, nombre, email);
    }

    @Override
    public String toString() {
        return String.format("Cliente [ID: %d, Nombre: %s, Email: %s]", idCliente, nombre, email);
    }
}