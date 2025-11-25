package lab3.csd214_fall2025.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class DiscMagEntity extends MagazineEntity {
    @Column(name = "has_disc")
    private boolean hasDisc;

    public DiscMagEntity() {

    }

    public DiscMagEntity(
            String title,
            double price,
            int copies,
            String isbn_10,
            String description,
            int orderQty,
            Date currentIssue,
            boolean hasDisc) {
        super(title, price, copies, isbn_10, description, orderQty, currentIssue);
        this.hasDisc = hasDisc;
    }

    public void setHasDisc(boolean hasDisc) {
        this.hasDisc = hasDisc;
    }

    public boolean getHasDisc() {
        return hasDisc;
    }

    public String toString() {
        return super.toString() + "hasDisc: " + hasDisc;
    }

    @Override
    public void edit() {
        super.edit();
        System.out.println("Edit has disc (" + getHasDisc() + " [enter for no changes])");
        setHasDisc(getInput(getHasDisc()));
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void sellCopy() {

    }

}
