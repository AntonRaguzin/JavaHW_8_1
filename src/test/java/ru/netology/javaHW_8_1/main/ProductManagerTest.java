package ru.netology.javaHW_8_1.main;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.javaHW_8_1.products.Book;
import ru.netology.javaHW_8_1.products.Product;
import ru.netology.javaHW_8_1.products.Smartphone;
import ru.netology.javaHW_8_1.repository.ProductRepository;
import ru.netology.javaHW_8_1.repository.ProductRepositoryTest;

public class ProductManagerTest {

    Product p1 = new Book(1, "Book-1", 550, "Author_1");
    Product p2 = new Smartphone(2, "Phone-1", 9_000, "Manuf_1");
    Product p3 = new Book(3, "Book-2", 990, "Author_1");
    Product p4 = new Book(4, "Book-3", 1_000, "Author_2");
    Product p5 = new Smartphone(5, "Phone-2", 9_990, "Manuf_2");
    Product p6 = new Smartphone(6, "Phone-3", 19_000, "Manuf_1");

    ProductManager manager = new ProductManager(new ProductRepository());

    @Test
    public void shouldAddNewProd() {
        manager.add(p1);
        manager.add(p2);

        Product[] expected = {p1, p2};
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {

        manager.add(p3);
        manager.add(p6);
        manager.removeById(p3.getId());
        manager.removeById(6);

        Product[] expected = {};
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchInProd() {


        manager.matches(p1, "Book-1");
        assertEquals(true, manager.matches(p1, "Book-1"));
    }

    @Test
    public void shouldNotFindMatchInProd() {

        manager.matches(p5, "book_1");
        assertEquals(false, manager.matches(p5, "book_1"));
    }

    @Test
    public void shouldNotFindMatchIfWrongText() {
        manager.matches(p1, "книга1");
        assertEquals(false, manager.matches(p1, "книга1"));
    }

    @Test
    public void shouldFindMatch() {

        manager.add(p2);
        manager.add(p3);

        Product[] expected = {p2};
        Product[] actual = manager.searchBy("Phone-1");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMatches() {

        manager.add(p1);
        manager.add(p2);
        manager.add(p3);

        Product[] expected = {p1, p3};
        Product[] actual = manager.searchBy("Book");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMatch() {

        manager.add(p1);
        manager.add(p2);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Book-6");

        assertArrayEquals(expected, actual);
    }
//    @Test
//    public void shouldRemoveByIdNew() {
//
//        manager.add(p3);
//
//
//        manager.removeById(-1);
//
//        Product[] expected = {};
//        Product[] actual = manager.findAll();
//
//        assertArrayEquals(expected, actual);
//    }
    @Test
    public void shouldFindById(){

        manager.add(p1);
        manager.add(p2);

        Product expected = p2;
        Product actual = manager.findById(2);

        assertEquals(expected, actual);
    }
    @Test
    public void shouldNotFindById(){

        manager.add(p1);
        manager.add(p2);

        Product expected = null;
        Product actual = manager.findById(-1);

        assertEquals(expected, actual);
    }

}
