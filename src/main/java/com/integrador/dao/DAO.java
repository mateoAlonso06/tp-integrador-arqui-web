package com.integrador.dao;

import java.util.List;

public interface DAO<T, K> {
    void insert(T entity);

    void delete(K id);

    T getById(K id);

    List<T> getAll();
}
