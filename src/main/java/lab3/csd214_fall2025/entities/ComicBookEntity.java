package lab3.csd214_fall2025.entities;

import jakarta.persistence.Entity;

@Entity
public class ComicBookEntity extends BookEntity {

    public ComicBookEntity() {}

    public ComicBookEntity(
            String title,
            double price,
            int copies,
            String isbn_10,
            String description,
            String author) {
        super(title, price, copies, isbn_10, description, author);
    }

    @Override
    public void sellCopy() {

    }

    @Override
    public void edit() {
        super.edit();
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}