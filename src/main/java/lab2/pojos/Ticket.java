package lab2.pojos;

import java.io.Serializable;

public class Ticket extends Editable implements Serializable, SaleableItem {
    private int id;
    private String description;
    private double price;

    public Ticket() {
        super();
    }

    public Ticket(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public Ticket(String s, double fakeDoubleBetween) {
        super();
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void sellItem() {

    }

    public void edit() {
    }

    public void initalize() {
        id = 0;
        description = "";
        price = 0;
    }
}
