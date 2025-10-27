package lab2.pojos;

import java.io.Serializable;
import java.util.Objects;

public abstract class Publication extends Editable implements SaleableItem, Serializable {
    private String title;
    private double price;
    private int copies;
    private long id;
    private String isbn;
    private String description;

    public Publication() {
        super();
    }

    public Publication(String title, double price, int copies, String isbn, String description) {
        super();
        this.title = title;
        this.price = price;
        this.copies = copies;
        this.isbn = isbn;
        this.description = description;
    }

    public Publication(String title, double price, int copies, int id, String isbn, String description) {
        super();
        this.title = title;
        this.price = price;
        this.copies = copies;
        this.isbn = isbn;
        this.description = description;
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void sellItem() {
        if (copies > 0) {
            copies--;
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public abstract void edit();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIsbn (String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", copies=" + copies +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Publication that = (Publication) obj;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
