package com.vincent.api;


import com.vincent.bean.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// 找到名字为wood-provider服务
@FeignClient("wood-provider")
public interface ProductService {

    @RequestMapping(value = "/products",method = RequestMethod.GET)
    List<Product> findAll();

    @RequestMapping(value = "/products/{itemCode}",method = RequestMethod.GET)
    Product findProductByItemCode(@PathVariable("itemCode") String itemCode);
}
