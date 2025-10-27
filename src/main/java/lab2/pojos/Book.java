package lab2.pojos;

import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class Book extends Publication implements SaleableItem {
    private String author;
    private Long id;

    public Book() {
        super();
        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    public Book(Long id, String author) {
        super();
        this.author = author;
        this.id = id;
    }

    public Book(Long id, String title, double price, int copies, String isbn_10, String description, String author) {
        super(title, price, copies, isbn_10, description);
        this.author = author;
        this.id = id;
    }

    public void initialize() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter id: ");
        setId(sc.nextLong());
        sc.nextLine();

        System.out.print("Enter title: ");
        setTitle(sc.nextLine());

        System.out.print("Enter author: ");
        setAuthor(sc.nextLine());

        System.out.print("Enter price: ");
        setPrice(sc.nextDouble());

        System.out.print("Enter copies: ");
        setCopies(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter isbn: ");
        setIsbn(sc.nextLine());

        System.out.print("Enter description: ");
        setDescription(sc.nextLine());
    }

    @Override
    public void edit() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter new title (current title: " + getTitle() + "): ");
        setTitle(sc.nextLine());

        System.out.print("Enter new author (current author: " + getAuthor() + "): ");
        author = sc.nextLine();

        System.out.print("Enter new price (current price: " + getPrice() + "): ");
        setPrice(sc.nextDouble());

        System.out.print("Enter new number of copies (current copies: " + getCopies() + "): ");
    }

    public long getId() {
        return id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public void sellItem() {
        if (getCopies() > 0) {
            setCopies(getCopies() - 1);
        }
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + getId() + '\'' +
                "title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", price=" + getPrice() +
                ", copies=" + getCopies() +
                ", isbn='" + getIsbn() + '\'' +
                ", description='" + getDescription() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Objects.equals(id, book.id) &&
                Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getTitle(), author);
    }
}
