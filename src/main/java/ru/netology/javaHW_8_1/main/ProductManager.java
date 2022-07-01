package ru.netology.javaHW_8_1.main;

import ru.netology.javaHW_8_1.products.Product;
import ru.netology.javaHW_8_1.repository.ProductRepository;

public class ProductManager {

    ProductRepository prodRep = new ProductRepository();

    public Product[] searchBy(String text) {

        Product[] result = new Product[1]; // тут будем хранить подошедшие запросу продукты

        int copyToIndex = 0;

        for (Product product : prodRep.findAll()) {
            if (matches(product, text)) {

                result[copyToIndex] = product;
                copyToIndex++;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }

    }
}
