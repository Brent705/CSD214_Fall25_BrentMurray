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

    private final String addItemMenu = "\n***********************\n"
            + " 1. Book\n"
            + " 2. Magazine\n"
            + " 3. DiscMag\n"
            + " 4. Ticket\n"
            + "***********************\n"
            + "Enter choice: ";

    private final ArrayList<SaleableItem> saleableItems = new ArrayList<>();

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
        populate();
        boolean done = false;
        while (!done) {
            out.print(menu);
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    editItem();
                    break;
                case 3:
                    deleteItem();
                    break;
                case 4:
                    sellItem();
                    break;
                case 5:
                    listAny();
                    break;
                case 99:
                    done = true;
                    out.println("Goodbye!");
                    break;
                default:
                    out.println("Invalid choice");
            }
        }
    }

    public void editItem() {
        if (saleableItems.isEmpty()) {
            out.println("Nothing to edit");
            return;
        }

        listAny();
        out.print("Enter item number to edit: ");
        int itemIndex = input.nextInt();
        input.nextLine();

        if (itemIndex > 0 && itemIndex <= saleableItems.size()) {
            SaleableItem item = saleableItems.get(itemIndex - 1);
            if (item instanceof Editable) {
                ((Editable) item).edit();
                out.println("Item has been edited");
            } else {
                out.println("Item cannot be edited");
            }
        } else {
            out.println("Invalid item number");
        }
    }

    public void deleteItem() {
        if (saleableItems.isEmpty()) {
            out.println("Nothing to delete");
            return;
        }

        listAny();
        out.print("Enter item number to delete: ");
        int itemIndex = input.nextInt();
        input.nextLine();

        if (itemIndex > 0 && itemIndex <= saleableItems.size()) {
            SaleableItem removed = saleableItems.remove(itemIndex - 1);
            out.println("Item has been deleted: " + removed);
        } else {
            out.println("Invalid item number");
        }
    }

    public void populate() {
        for (int i = 0; i < 2; i++) {
            Book b = Util.getFakeBook();
            Magazine m = Util.getFakeMagazine();
            DiscMag dm = Util.getFakeDiscMag();
            Ticket t = Util.getFakeTicket();

            addItem(b);
            addItem(m);
            addItem(dm);
            addItem(t);
        }
    }

    public void listAny() {
        if (saleableItems.isEmpty()) {
            out.println("Nothing to list");
            return;
        }

        out.println("\n****** Inventory ******");
        for (int i = 0; i < saleableItems.size(); i++) {
            out.println((i + 1) + ". " + saleableItems.get(i).toString() + " - Price: $" + saleableItems.get(i).getPrice());
        }
        out.println("***********************");
    }

    public void sellItem() {
        if (saleableItems.isEmpty()) {
            out.println("Nothing to sell");
            return;
        }

        listAny();
        out.print("Enter item number: ");
        int choice = input.nextInt();
        input.nextLine();

        if (choice > 0 && choice <= saleableItems.size()) {
            SaleableItem item = saleableItems.get(choice - 1);
            item.sellItem();
            CashTill till = new CashTill();
            till.sellItem(item);
            out.println(item + " has been sold for $" + item.getPrice());
            saleableItems.remove(choice - 1);
        } else {
            out.println("Invalid choice");
        }
    }

    private void addItem() {
        out.print(addItemMenu);
        int choice = input.nextInt();
        input.nextLine();

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
            default:
                out.println("Invalid choice");
        }
    }

    public void addItem(SaleableItem s) {
        saleableItems.add(s);
        out.println("Item added: " + s.toString());
    }
}