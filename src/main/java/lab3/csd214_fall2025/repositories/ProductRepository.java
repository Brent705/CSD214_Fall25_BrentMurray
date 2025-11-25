package lab3.csd214_fall2025.repositories;

import lab3.csd214_fall2025.entities.ProductEntity;
import java.util.List;
import java.util.Optional;

public interface ProductRepository<T extends ProductEntity> {
    T save(T entity);
    Optional<T> findById(Long id);
    List<T> findAll();
    void deleteById(Long id);
    void delete(T entity);
    boolean existsById(Long id);
    long count();
}