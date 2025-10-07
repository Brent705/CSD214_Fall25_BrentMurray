package lab1.pojos;

import java.io.Serializable;

public abstract class Ticket extends Editable implements Serializable, SaleableItem {
    private int id;
    private String description;
    private double price;
}
