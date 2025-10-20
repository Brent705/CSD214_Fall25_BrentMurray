package lab2.pojos;

public class Magazine {
    private int orderQty;
    private java.time.LocalDateTime currentIssue;

    public Magazine() {
        super();
    }

    public Magazine(int orderQty, java.time.LocalDateTime currentIssue) {
        this.orderQty = orderQty;
        this.currentIssue = currentIssue;
    }

    public void edit() {

    }

    public void initalize() {
        currentIssue = java.time.LocalDateTime.now();
        orderQty = 0;
    }

    public void sellItem() {
    }
}
