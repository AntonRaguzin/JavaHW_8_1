package ru.netology.javaHW_8_1.repository;

import static org.junit.jupiter.api.Assertions .*;
import org.junit.jupiter.api.Test;
import ru.netology.javaHW_8_1.products.Book;
import ru.netology.javaHW_8_1.products.Product;
import ru.netology.javaHW_8_1.products.Smartphone;

public class ProductRepositoryTest {

    Product p1 = new Book(1,"book_1", 550, "Author_1");
    Product p2 = new Smartphone(2,"phone_1", 9_000, "Manuf_1");
    Product p3 = new Book(3,"Book_2", 990, "Author_1");
    Product p4 = new Book(4,"Book_3", 1_000, "Author_2");
    Product p5 = new Smartphone(5,"phone_2", 9_990, "Manuf_2");
    Product p6 = new Smartphone(6,"phone_3", 19_000, "Manuf_1");

    ProductRepository repo =  new ProductRepository();

    @Test
    public void shouldSaveNewProd(){
        repo.save(p1);
        repo.save(p2);

        Product[] expected = {p1, p2};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveById(){

        repo.save(p2);
        repo.save(p6);
        repo.removeById(p2.getId());
        repo.removeById(6);
        Product[] expected = {};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

}
