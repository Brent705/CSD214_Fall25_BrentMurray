package lab1;

import lab1.ui.Console;
import lab1.ui.MenuItem;

public class App {

    public void run() {

        // Build the menu structure
        var menu = new MenuItem.Menu("Main Menu", new MenuItem[] {
                new MenuItem.Menu("Add Items",new MenuItem[] {
                        new MenuItem.Action("Add Book", () -> Console.println("TODO: Add Book")),
                        new MenuItem.Action("Add Magazine", () -> Console.println("TODO: Add Magazine")),
                        new MenuItem.Action("Add DiscMag", () -> Console.println("TODO: Add DiscMag")),
                        new MenuItem.Action("Add Ticket", () -> Console.println("TODO: Add Ticket")),
                }),
                new MenuItem.Action("Edit Items", () -> Console.println("TODO: Edit Items")),
                new MenuItem.Action("Delete Items", () -> Console.println("TODO: Delete Items")),
                new MenuItem.Action("Sell Item(s)", () -> Console.println("TODO: Sell Item(s)")),
                new MenuItem.Action("List Items", () -> Console.println("TODO: List Items")),
                new MenuItem.Action("Quit", () -> {
                    Console.println("Goodbye...");
                    System.exit(0);
                })
        });

        Console.promptMenu(menu);
    }
}
