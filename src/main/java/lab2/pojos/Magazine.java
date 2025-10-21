package lab2.pojos;

import java.time.LocalDateTime;

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

    public void edit() {

    }

    public void initalize() {
        currentIssue = java.time.LocalDateTime.now();
        orderQty = 0;
    }

    @Override
    public void sellItem() {
        if (orderQty > 0) {
            orderQty--;
        }
    }

    @Override
    public String toString() {
      return "Magazine{" +
              "orderQty=" + orderQty +
              ", currentIssue=" + currentIssue +
              '}';
    }
}
