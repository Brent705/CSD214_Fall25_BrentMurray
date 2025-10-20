package lab2;

import lab2.pojos.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private final String menu = "\n***********************\n"
            + " 1. Add Items\n"
            + " 2. Edit Items\n"
            + " 3. Delete Items\n"
            + " 4. Sell item(s)\n"
            + " 5. List items\n"
            + "99. Quit\n"
            + "***********************\n"
            + "Enter choice: ";

    private final ArrayList<SaleableItem> saleableItems = new ArrayList<>();
    private final int currentItem = 0;

    private Scanner input;
    private final PrintStream out;

    // Default constructor for normal execution
    public App() {
        this(System.in, System.out);
    }

    // Constructor for testing
    public App(InputStream in, PrintStream out) {
        this.input = new Scanner(in);
        this.out = out;
    }

    public void run() {
        boolean done = false;
        while (!done) {}
    }


    public boolean findItemExists(SaleableItem item) {
        return false;
    }

    public SaleableItem findItem(SaleableItem) {
        return new Book();
    }

    public void editItem() {}
    public void editItem(Editable) {}

    public void deleteItem() {
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                Book b = new Book();
                b.initialize();
                deleteItem(b);
                break;
            case 2:
                Magazine m = new Magazine();
                m.initalize();
                deleteItem(m);
                break;
            case 3:
                DiscMag dm = new DiscMag();
                dm.initalize();
                deleteItem(dm);
                break;
            case 4:
                Ticket t = new Ticket();
                t.initalize();
                deleteItem(t);
                break;
        }
    }

    public void deleteItem(SaleableItem s) {
        saleableItems.remove(s);
    }

    public void populate() {
        for (int i = 0; i < 2; i++) {
            Book b = Util.getFakeBook();
            Magazine m = Util.getFakeMagazine();
            DiscMag dm = Util.getFakeDiscMag();
            Ticket t = Util.getFakeTicket();

            addItem(b);
        }
    }

    public void listAny() {}

    public SaleableItem getItem(SaleableItem) {
        return null;
    }

    public void sellItem() {}

    public void listI(Object i) {}

    private void addItem() {
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                Book b = new Book();
                b.initialize();
                addItem(b);
                break;
            case 2:
                Magazine m = new Magazine();
                m.initalize();
                addItem(m);
                break;
            case 3:
                DiscMag dm = new DiscMag();
                dm.initalize();
                addItem(dm);
                break;
            case 4:
                Ticket t = new Ticket();
                t.initalize();
                addItem(t);
                break;
        }
    }

    public void addItem(SaleableItem s) {
        saleableItems.add(s);
    }
}
