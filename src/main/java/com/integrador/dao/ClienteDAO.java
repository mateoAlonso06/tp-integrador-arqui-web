package com.integrador.dao;

import com.integrador.entity.Cliente;

import java.util.List;

public interface ClienteDAO extends DAO<Cliente, Integer> {
    public List<Cliente> getClientesOrderByFacturas();
}
