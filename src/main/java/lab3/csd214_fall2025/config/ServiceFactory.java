package lab3.csd214_fall2025.config;

import lab3.csd214_fall2025.entities.*;
import lab3.csd214_fall2025.repositories.ProductRepository;
import lab3.csd214_fall2025.repositories.impl.InMemoryProductRepository;
import lab3.csd214_fall2025.repositories.impl.JpaProductRepository;
import lab3.csd214_fall2025.services.ProductService;
import lab3.csd214_fall2025.services.impl.ProductServiceImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ServiceFactory {

    public enum PersistenceType {
        IN_MEMORY,
        H2,
        MYSQL
    }

    private static EntityManagerFactory emf;
    private static PersistenceType currentType = PersistenceType.IN_MEMORY;

    public static void initialize(PersistenceType type) {
        currentType = type;
        if (type == PersistenceType.H2 || type == PersistenceType.MYSQL) {
            String persistenceUnit = type == PersistenceType.MYSQL ? "product-pu" : "product-pu-h2";
            emf = Persistence.createEntityManagerFactory(persistenceUnit);
        }
    }

    public static ProductService<BookEntity> createBookService() {
        ProductRepository<BookEntity> repository = createRepository(BookEntity.class);
        return new ProductServiceImpl<>(repository);
    }

    public static ProductService<MagazineEntity> createMagazineService() {
        ProductRepository<MagazineEntity> repository = createRepository(MagazineEntity.class);
        return new ProductServiceImpl<>(repository);
    }

    public static ProductService<DiscMagEntity> createDiscMagService() {
        ProductRepository<DiscMagEntity> repository = createRepository(DiscMagEntity.class);
        return new ProductServiceImpl<>(repository);
    }

    public static ProductService<TicketEntity> createTicketService() {
        ProductRepository<TicketEntity> repository = createRepository(TicketEntity.class);
        return new ProductServiceImpl<>(repository);
    }

    private static <T extends ProductEntity> ProductRepository<T> createRepository(Class<T> entityClass) {
        switch (currentType) {
            case IN_MEMORY:
                return new InMemoryProductRepository<>();
            case H2:
            case MYSQL:
                if (emf == null) {
                    throw new IllegalStateException("EntityManagerFactory not initialized");
                }
                return new JpaProductRepository<>(emf, entityClass);
            default:
                throw new IllegalArgumentException("Unknown persistence type: " + currentType);
        }
    }

    public static PersistenceType getCurrentType() {
        return currentType;
    }

    public static void shutdown() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}