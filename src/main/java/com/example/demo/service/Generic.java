package com.example.demo.service;

import com.example.demo.model.User;

import java.util.Optional;

public interface Generic<T> {

    Iterable<T> findAll();

    Optional<T> findById(Long id);

    User save(T t);

    void delete(Long id);
}
