package lab2.pojos;

import java.time.LocalDateTime;
import java.util.Scanner;

public class DiscMag extends Magazine {
    private boolean hasDisc;

    public DiscMag() {
        super();
        this.hasDisc = false;
    }

    public DiscMag(Magazine dm, boolean hasDisc) {
        super(dm.getTitle(), dm.getPrice(), dm.getCopies(), dm.getIsbn(), dm.getDescription(), dm.getOrderQty(), dm.getCurrentIssue());
        this.hasDisc = hasDisc;
    }

    public DiscMag(int orderQty, LocalDateTime currentIssue, String title, double price, int copies) {
        super(title, price, copies, "", "", orderQty, currentIssue);
        this.hasDisc = false;
    }

    @Override
    public void edit() {
        super.edit();
        Scanner sc = new Scanner(System.in);
        System.out.print("Has Disc? (true/false, current: " + isHasDisc() + "): ");
        setHasDisc(sc.nextBoolean());
    }

    @Override
    public void initalize() {
        super.initalize();
        Scanner sc = new Scanner(System.in);
        System.out.print("Has Disc? (true/false): ");
        setHasDisc(sc.nextBoolean());
    }

    @Override
    public void sellItem() {
        super.sellItem();
    }

    public boolean isHasDisc() {
        return hasDisc;
    }

    public void setHasDisc(boolean hasDisc) {
        this.hasDisc = hasDisc;
    }

    @Override
    public String toString() {
        return "DiscMag{" +
                "title='" + getTitle() + '\'' +
                ", price=" + getPrice() +
                ", copies=" + getCopies() +
                ", isbn=" + getIsbn() +
                ", description=" + getDescription() +
                ", orderQty=" + getOrderQty() +
                ", hasDisc=" + isHasDisc() +
                ", currentIssue=" + getCurrentIssue() +
                '}';
    }
}
