package lab2.pojos;

import java.io.Serializable;

public abstract class Publication extends Editable implements SaleableItem, Serializable {
    private String title;
    private double price;
    private int copies;
    private int id;

    public Publication(String title, double price, int copies, String isbn_10, String description) {
        super();
    }

    @Override
    public void sellItem() {

    }

    @Override
    public double getPrice() {
        return price;
    }

    public Publication() {
        super();
    }

    public Publication(String title, double price, int copies, String isbn10, String description, int id) {
        super();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
