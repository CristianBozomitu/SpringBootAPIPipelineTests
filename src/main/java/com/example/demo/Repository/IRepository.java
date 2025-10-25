package com.example.demo.Repository;

import java.util.List;

public interface IRepository<T> {
    T getById(Long id);
    List<T> getAll();
    void deleteById(Long id);
    void update(T entity);
    T create(T entity);
}
