package pl.kkowalewski.showroom.service;

import pl.kkowalewski.showroom.exception.service.RepositoryItemNotFoundException;

import java.util.List;

public interface BaseService<T> {

    T findById(Long id) throws RepositoryItemNotFoundException;

    List<T> findAll();

    T save(T object);

    T update(T object);

    void deleteById(Long id);

    void delete(T object);

    void deleteAll();

}
