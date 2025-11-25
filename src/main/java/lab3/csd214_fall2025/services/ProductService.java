package lab3.csd214_fall2025.services;

import lab3.csd214_fall2025.entities.ProductEntity;
import java.util.List;
import java.util.Optional;

public interface ProductService<T extends ProductEntity> {
    T create(T entity);
    T update(Long id, T entity);
    Optional<T> findById(Long id);
    List<T> findAll();
    void deleteById(Long id);
    boolean exists(Long id);
    long count();
}