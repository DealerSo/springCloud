package com.vincent.controller;

import com.vincent.bean.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/products")
public class ProductEndpoint {
    protected Logger logger = LoggerFactory.getLogger(ProductEndpoint.class);

    @GetMapping
    public List<Product> listProduct() {
        logger.info("ProductController Class");
        return this.buildProducts();
    }

    @GetMapping(value = "/{itemCode}")
    public Product detail(@PathVariable String itemCode) {
        List<Product> products = this.buildProducts();
        for (Product product : products) {
            if(product.getItemCode().equals(itemCode)){
                return product;
            }
        }
        return null;
    }

    private List<Product> buildProducts() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("item-1", "test_product-1", "product-1", "100.00"));
        products.add(new Product("item-2", "test_product-2", "product-2", "200.00"));
        products.add(new Product("item-3", "test_product-3", "product-3", "300.00"));
        products.add(new Product("item-4", "test_product-4", "product-4", "400.00"));
        products.add(new Product("item-5", "test_product-5", "product-5", "500.00"));
        products.add(new Product("item-6", "test_product-6", "product-6", "600.00"));
        return products;
    }

}
