package ru.netology.javaHW_8_1.main;

import ru.netology.javaHW_8_1.products.Product;
import ru.netology.javaHW_8_1.repository.ProductRepository;

public class ProductManager {

    ProductRepository prodRepo = new ProductRepository();

    public Product[] searchBy(String text) {

        Product[] result = new Product[0];

        for (Product product : prodRepo.findAll()) {

            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String text) {
        if (product.getName().contains(text)) {
            return true;
        } else {
            return false;
        }

    }
}
