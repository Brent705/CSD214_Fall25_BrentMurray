package lab3.csd214_fall2025.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class PencilEntity extends ProductEntity {
    @Column(name = "id")
    long id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "price")
    Double price;

    @Column(name = "quantity")
    int quantity;

    public PencilEntity() {}

    public PencilEntity(long id,
                        String name,
                        String description,
                        double price,
                        int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public void edit() {
        System.out.println("Edit ID (" + getId() + " [enter for no changes])");
        setId(getInput(getId()));
        System.out.println("Edit name (" + getName() + " [enter for no changes])");
        setName(getInput(getName()));
        System.out.println("Edit description (" + getDescription() + " [enter for no changes])");
        setDescription(getInput(getDescription()));
        System.out.println("Edit price (" + getPrice() + " [enter for no changes])");
        setPrice(getInput(getPrice()));
        System.out.println("Edit quantity (" + getQuantity() + " [enter for no changes])");
        setQuantity((int) getInput(getQuantity()));
    }

    @Override
    public void initialize() {
        System.out.println("Enter ID:");
        setId((long) getInput(0));
        System.out.println("Enter name:");
        setName(getInput("No name"));
        System.out.println("Enter description:");
        setDescription(getInput("No description"));
        System.out.println("Enter price:");
        setPrice(getInput(0.0d));
        System.out.println("Enter quantity:");
        setQuantity(0);
    }

    @Override
    public void sellCopy() {

    }

    @Override
    public double getPrice() {
        return price;
    }
}
