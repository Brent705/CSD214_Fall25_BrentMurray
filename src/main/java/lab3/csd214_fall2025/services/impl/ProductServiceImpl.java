package lab3.csd214_fall2025.services.impl;

import lab3.csd214_fall2025.entities.ProductEntity;
import lab3.csd214_fall2025.repositories.ProductRepository;
import lab3.csd214_fall2025.services.ProductService;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl<T extends ProductEntity> implements ProductService<T> {

    private final ProductRepository<T> repository;

    public ProductServiceImpl(ProductRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public T create(T entity) {
        if (entity.getId() != null) {
            throw new IllegalArgumentException("Cannot create entity with existing ID");
        }
        return repository.save(entity);
    }

    @Override
    public T update(Long id, T entity) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Entity with ID " + id + " does not exist");
        }
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Entity with ID " + id + " does not exist");
        }
        repository.deleteById(id);
    }

    @Override
    public boolean exists(Long id) {
        return repository.existsById(id);
    }

    @Override
    public long count() {
        return repository.count();
    }
}