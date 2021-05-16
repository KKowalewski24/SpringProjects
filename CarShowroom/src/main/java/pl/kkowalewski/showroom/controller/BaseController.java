package pl.kkowalewski.showroom.controller;

import java.util.List;

public interface BaseController<T> {

    List<T> getAll();

    T getById(Long id);

    T post(T object);

    T put(Long id, T object);

    void deleteById(Long id);
}
