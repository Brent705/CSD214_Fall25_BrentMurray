package lab2.pojos;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Magazine extends Publication implements SaleableItem {
    private int orderQty;
    private LocalDateTime currentIssue;

    public Magazine() {
        super();
    }

    public Magazine(String title, double price, int copies, String isbn, String description, int orderQty, LocalDateTime currentIssue) {
        super(title, price, copies, isbn, description);
        this.orderQty = orderQty;
        this.currentIssue = currentIssue;
    }

    @Override
    public void edit() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter new title (current title: " + getTitle() + "): ");
        setTitle(sc.nextLine());

        System.out.print("Enter new price (current price: " + getPrice() + "): ");
        setPrice(sc.nextDouble());

        System.out.print("Enter new number of copies (current copies: " + getCopies() + "): ");
        setCopies(sc.nextInt());

        System.out.print("Enter new quantity (current quantity: " + orderQty + "): ");
        orderQty = sc.nextInt();
    }

    public void initalize() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter title: ");
        setTitle(sc.nextLine());

        System.out.print("Enter price: ");
        setPrice(sc.nextDouble());

        System.out.print("Enter number of copies: ");
        setCopies(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter ISBN: ");
        setIsbn(sc.nextLine());

        System.out.print("Enter description: ");
        setDescription(sc.nextLine());

        System.out.print("Enter quantity: ");
        setOrderQty(sc.nextInt());

        setCurrentIssue(LocalDateTime.now());
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public LocalDateTime getCurrentIssue() {
        return currentIssue;
    }

    public void setCurrentIssue(LocalDateTime currentIssue) {
        this.currentIssue = currentIssue;
    }

    @Override
    public void sellItem() {
        if (orderQty > 0) {
            orderQty--;
        }
        if (getCopies() > 0) {
            setCopies(getCopies() - 1);
        }
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "title='" + getTitle() + '\'' +
                ", price=" + getPrice() +
                ", copies=" + getCopies() +
                ", isbn=" + getIsbn() +
                ", description=" + getDescription() +
                ", orderQty=" + getOrderQty() +
                ", currentIssue=" + getCurrentIssue() +
                '}';
    }
}
