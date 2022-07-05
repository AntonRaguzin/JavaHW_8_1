package ru.netology.javaHW_8_1.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.javaHW_8_1.main.AlreadyExistsException;
import ru.netology.javaHW_8_1.main.NotFoundException;
import ru.netology.javaHW_8_1.products.Book;
import ru.netology.javaHW_8_1.products.Product;
import ru.netology.javaHW_8_1.products.Smartphone;

public class ProductRepositoryTest {

    Product p1 = new Book(1, "book_1", 550, "Author_1");
    Product p2 = new Smartphone(2, "phone_1", 9_000, "Manuf_1");
    Product p3 = new Book(3, "Book_2", 990, "Author_1");
    Product p4 = new Book(4, "Book_3", 1_000, "Author_2");
    Product p5 = new Smartphone(5, "phone_2", 9_990, "Manuf_2");
    Product p6 = new Smartphone(6, "phone_3", 19_000, "Manuf_1");
    Product p7 = new Product(1, "Book-7", 999);

    ProductRepository repo = new ProductRepository();


    @Test
    public void shouldSaveNewProd() {
        repo.save(p1);
        repo.save(p2);

        Product[] expected = {p1, p2};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSaveNewProdWithDuplicateId() {

        repo.save(p1);
        repo.save(p2);


        assertThrows(AlreadyExistsException.class, () -> {
            repo.save(p7);
        });
    }

    @Test
    public void shouldRemoveById() {

        repo.save(p3);
        repo.save(p6);
        repo.save(p4);

        repo.removeById(p3.getId());
        repo.removeById(6);
        Product[] expected = {p4};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByID() {
        repo.save(p1);
        assertEquals(p1, repo.findById(1));
    }

    @Test
    public void shouldNotFindByID() {
        repo.save(p1);
        assertEquals(null, repo.findById(2));
    }

    @Test
    public void shouldGenerateExceptionWhenRemoveByNotFoundId() {

        repo.save(p4);
        repo.save(p5);
        repo.save(p6);


//        try {
//            repo.removeById(10);
////            System.out.println("OK");
//        } catch (NotFoundException e){
//            System.out.println(e);
//        }
        assertThrows(NotFoundException.class, () -> {
            repo.removeById(10);
        });

    }
    @Test
    public void test(){

        repo.save(p1);
        repo.save(p2);
        repo.save(p3);

        assertThrows(AlreadyExistsException.class, () -> {
            repo.save(p7);
        });
    }
}
