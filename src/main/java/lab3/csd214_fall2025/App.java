package lab3.csd214_fall2025;

import lab3.csd214_fall2025.entities.BookEntity;
import lab3.csd214_fall2025.entities.ProductEntity;
import lab3.csd214_fall2025.entities.TicketEntity;
import jakarta.persistence.*;

import java.util.List;

public class App {
    private EntityManagerFactory emf;

    public void run(){
        // Create the EntityManagerFactory using the persistence unit name from persistence.xml
        emf = Persistence.createEntityManagerFactory("product-pu");
        populateDatabase();
        listAllProducts();
    }

    public void populateDatabase() {
        // EntityManager is used to interact with the persistence context
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin(); // Start a transaction
//
            System.out.println("Populating database with products...");

            BookEntity b = new BookEntity(
                    "String title",
                    29.99,
                    10,
                    "String isbn_10",
                    "String description",
                    "String author");
            BookEntity b2 = new BookEntity(
                    "String title2",
                    39.99,
                    20,
                    "String isbn_10_2",
                    "String description2",
                    "String author2");

            TicketEntity t=new TicketEntity("Cool Concert",  100.99);

            em.persist(b);
            em.persist(b2);
            em.persist(t);

            tx.commit(); // Commit the transaction
            System.out.println("Population complete.");
        } catch (Exception e) {
            // If anything goes wrong, roll back the transaction
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            // Always close the EntityManager
            em.close();
        }

    }
    
    private void listAllProducts() {
        EntityManager em = emf.createEntityManager();
        try {
            List<ProductEntity> results = getAllProducts(em);
            System.out.println("Found " + results.size() + " items.");
            for (ProductEntity p : results) {
                System.out.println(p);
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
    }

    /**
     * Queries the database for all entities that are part of the PublicationEntity
     * inheritance hierarchy. Because PublicationEntity extends EditableEntity, this
     * effectively retrieves all editable items.
     *
     * @param em The EntityManager to use for the query.
     * @return A list of all PublicationEntity instances (including Books, Magazines, etc.).
     */
    public List<ProductEntity> getAllProducts(EntityManager em) {
        System.out.println("\n--- Querying for all editable publications ---");

        // 1. The JPQL query is written against the root @Entity class, not the @MappedSuperclass.
        //    JPA will automatically fetch all subclasses (like BookEntity).
        String jpql = "SELECT p FROM ProductEntity p";

        // 2. We create a TypedQuery to ensure the results are cast to the correct base type.
        TypedQuery<ProductEntity> query = em.createQuery(jpql, ProductEntity.class);

        // 3. Execute the query to get the list of results.


        return query.getResultList();
    }

}
