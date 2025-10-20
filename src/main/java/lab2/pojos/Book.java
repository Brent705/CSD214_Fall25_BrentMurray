package lab2.pojos;

import java.util.Objects;
import java.util.UUID;

public class Book extends Publication implements SaleableItem {
    private String author;

    public void edit() {

    }

    public Book() {
        super();
        setId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
    }

    public Book(Long id, String author) {
        super();
        this.author = author;
        setId(id);
    }

    public Book(Long id, String title, double price, int copies, String isbn_10, String description, String author) {
        super(title, price, copies, isbn_10, description);
        this.author = author;
        setId(id);
    }

    public void initialize() {
        author = "";
    }

    private void setId(Long id) {}

    @Override
    public void sellItem() {
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author);
    }
}
