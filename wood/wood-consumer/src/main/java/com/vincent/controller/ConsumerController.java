package com.vincent.controller;


import com.vincent.api.ProductService;
import com.vincent.bean.Product;
import com.vincent.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductService productService;

    @Value("${student.servicePath}")
    private String providerUrl;

    @GetMapping(value = "/getStudent/{id}")
    public Student getStudent(@PathVariable Integer id){
        return this.restTemplate.getForObject(this.providerUrl + id,Student.class);
    }

    @RequestMapping(value = "/findProducts",method = RequestMethod.GET)
    public List<Product> findProducts(){
        return this.productService.findAll();
    }

    @GetMapping(value = "/findProduct/{itemCode}")
    public Product findProduct(@PathVariable String itemCode){
        return this.productService.findProductByItemCode(itemCode);
    }
}
