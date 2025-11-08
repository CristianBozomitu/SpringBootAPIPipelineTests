package com.example.demo.Repository;

import java.util.List;

public interface IRepository<T> {
    T getById(Long id) throws RuntimeException;
    List<T> getAll();
    void deleteById(Long id) throws RuntimeException;
    void update(T entity);
    T create(T entity);
}
