package lab2.pojos;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class Ticket extends Editable implements Serializable, SaleableItem {
    private long id;
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

    public Ticket(String description, double price) {
        super();
        this.description = description;
        this.price = price;
        this.id = 0;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void sellItem() {
        System.out.println("Ticket has been sold!");
    }

    @Override
    public void edit() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter new description (current: " + description + ")");
        setDescription(sc.nextLine());

        System.out.print("Enter new price (current: " + price + ")");
        setPrice(sc.nextDouble());
    }

    public void initalize() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID: ");
        setId(sc.nextLong());
        sc.nextLine();

        System.out.print("Enter description: ");
        setDescription(sc.nextLine());

        System.out.print("Enter price: ");
        setPrice(sc.nextDouble());
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + getId() +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() +
                '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ticket ticket = (Ticket) obj;
        return id == ticket.id && description.equals(ticket.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
