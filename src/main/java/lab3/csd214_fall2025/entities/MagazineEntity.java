package lab3.csd214_fall2025.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.util.Objects;
import java.util.Date;

@Entity
public class MagazineEntity extends PublicationEntity {
    @Column(name = "order_qty")
    private int orderQty;

    @Column(name = "current_issue")
    private Date currentIssue;

    @Override
    public String toString() {
        return "MagazineEntity{" +
                "orderQty='" + orderQty + '\'' +
                ", currentIssue=" + currentIssue + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MagazineEntity that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(getPrice(), that.getPrice()) == 0
                && getCopies() == that.getCopies()
                && Objects.equals(getOrderQty(), that.getOrderQty())
                && Objects.equals(getCurrentIssue(), that.getCurrentIssue())
                && Objects.equals(getTitle(), that.getTitle())
                && Objects.equals(getIsbn_10(), that.getIsbn_10())
                && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getOrderQty(), getCurrentIssue(), getTitle(), getPrice(), getCopies(), getIsbn_10(), getDescription());
    }

    public MagazineEntity() {}

    public MagazineEntity(
            String title,
            double price,
            int copies,
            String isbn_10,
            String description,
            int orderQty,
    Date currentIssue) {
        super(title, price, copies, isbn_10, description);
        this.orderQty = orderQty;
        this.currentIssue = currentIssue;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public Date getCurrentIssue() {
        return currentIssue;
    }

    public void setCurrentIssue(Date currentIssue) {
        this.currentIssue = currentIssue;
    }

    @Override
    public void sellCopy() {

    }

    @Override
    public void edit() {
        System.out.println("Edit Title (" + getTitle() + " [enter for no changes])");
        setTitle(getInput(getTitle()));
        System.out.println("Edit order quantity (" + getOrderQty() + " [enter for no changes])");
        setOrderQty(getInput(getOrderQty()));
        System.out.println("Edit issue date (" + getCurrentIssue() + " [enter for no changes])");
        setCurrentIssue(getInput(getCurrentIssue()));
        System.out.println("Edit copies (" + getCopies() + " [enter for no changes])");
        setCopies(getInput(getCopies()));
        System.out.println("Edit price (" + getPrice() + " [enter for no changes])");
        setPrice(getInput(getPrice()));
    }

    @Override
    public void initialize() {
        System.out.println("Enter Title:");
        setTitle(getInput("no title"));
        System.out.println("Enter order qty:");
        setOrderQty(getInput(0));
        System.out.println("Enter copies:");
        setCopies(getInput(0));
        System.out.println("Enter price:");
        setPrice(getInput(0.0d));
        setCurrentIssue(new Date());
    }
}
