package ru.netology.javaHW_8_1.repository;

import ru.netology.javaHW_8_1.main.AlreadyExistsException;
import ru.netology.javaHW_8_1.main.NotFoundException;
import ru.netology.javaHW_8_1.products.Product;

public class ProductRepository {

    private Product[] products = new Product[0];

    public void save(Product product) {

        for (Product newProduct : products) {
            if (newProduct.getId() == product.getId()) {
                throw new AlreadyExistsException(
                        "товар с таким ID уже существует: " + product.getId()
                );
            }
        }

        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {

            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(                        // упрощаем запись не заводя переменную е
                    "Указанный ID не найден: " + id
            );
//            RuntimeException e = new RuntimeException(
//                    "ID не может быть отрицательным : " + id);
//            throw e;
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;

    }

    public Product findById(int id) {
        for (Product product : findAll()) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
