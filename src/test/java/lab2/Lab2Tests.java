package lab2;

import lab2.pojos.Book;
import lab2.pojos.Magazine;
import lab2.pojos.Ticket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BookTest {
    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book(1L, "If I Did It", 69.69, 6769, "1234567890",
                "The glove didn't fit", "OJ Simpson");
    }

    @Test
    void testBookCreation() {
        assertNotNull(book);
        assertEquals("OJ Simpson", book.getAuthor());
        assertEquals(69.69, book.getPrice());
        assertEquals("If I Did It", book.getTitle());
    }
}

class MagazineTest {
    private Magazine magazine;
    private LocalDateTime currentIssue;

    @BeforeEach
    void setUp() {
        currentIssue = LocalDateTime.now();
        magazine = new Magazine("FourFourTwo", 67.00, 10, "1111111111",
                "Futbol magazine", 40, currentIssue);
    }

    @Test
    void testMagazineCreation() {
        assertNotNull(magazine);
        assertEquals("FourFourTwo", magazine.getTitle());
        assertEquals(67.00, magazine.getPrice());
        assertEquals(40, magazine.getOrderQty());
    }
}

class TicketTest {
    private Ticket ticket;

    @BeforeEach
    void setUp() {
        ticket = new Ticket(3, "Ticket to Ride", 1000.00);
    }

    @Test
    void testTicketCreation() {
        assertNotNull(ticket);
        assertEquals(3, ticket.getId());
        assertEquals("Ticket to Ride", ticket.getDescription());
        assertEquals(1000.00, ticket.getPrice());
    }
}
