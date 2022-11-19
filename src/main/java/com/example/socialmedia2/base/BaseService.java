package com.example.socialmedia2.base;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends  BaseEntity<ID> , ID extends Serializable> {
    T saveOrUpdate(T t);

    void deleteById(ID id);

    void deleteEntity(T t);

    T findById(ID id);

    List<T> findAll();
}
