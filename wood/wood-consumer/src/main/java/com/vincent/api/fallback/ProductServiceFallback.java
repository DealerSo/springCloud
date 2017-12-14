package com.vincent.api.fallback;

import com.vincent.api.ProductService;
import com.vincent.bean.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@Component
public class ProductServiceFallback implements ProductService {

    @Override
    public List<Product> findAll() {
        return Collections.emptyList();
    }

    @Override
    public Product findProductByItemCode(@PathVariable("itemCode") String itemCode) {
        return new Product("error", "unknown", "Fallback", "0");
    }
}
