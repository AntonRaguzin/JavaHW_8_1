package ru.netology.javaHW_8_1.main;


import static org.junit.jupiter.api.Assertions .*;
import org.junit.jupiter.api.Test;
import ru.netology.javaHW_8_1.products.Book;
import ru.netology.javaHW_8_1.products.Product;
import ru.netology.javaHW_8_1.products.Smartphone;
import ru.netology.javaHW_8_1.repository.ProductRepository;
import ru.netology.javaHW_8_1.repository.ProductRepositoryTest;

public class ProductManagerTest {

    Product p1 = new Book(1, "book_1", 550, "Author_1");
    Product p2 = new Smartphone(2, "phone_1", 9_000, "Manuf_1");
    Product p3 = new Book(3, "Book_2", 990, "Author_1");
    Product p4 = new Book(4, "Book_3", 1_000, "Author_2");
    Product p5 = new Smartphone(5, "phone_2", 9_990, "Manuf_2");
    Product p6 = new Smartphone(6, "phone_3", 19_000, "Manuf_1");

    ProductManager manager = new ProductManager();
    ProductRepository repo = new ProductRepository();

    @Test
    public void shouldFindMatchInProd() {

        manager.matches(p1, "book_1");
        assertEquals(true, manager.matches(p1, "book_1"));
    }
    @Test
    public void shouldNotFindMatchInProd() {

        manager.matches(p5, "book_1");
        assertEquals(false, manager.matches(p5, "book_1"));
    }


    @Test
    public void shouldSearchMatches(){

        repo.save(p3);
        repo.save(p4);
        repo.save(p5);

        manager.searchBy("book_3");

        Product[] expected = {p4};
        Product[] actual = manager.searchBy("book_3");

        assertArrayEquals(expected, actual);
    }
}
