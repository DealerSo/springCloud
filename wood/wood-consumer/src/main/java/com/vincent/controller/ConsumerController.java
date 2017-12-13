package com.vincent.controller;


import com.vincent.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${student.servicePath}")
    private String providerUrl;

    @GetMapping(value = "/getStudent/{id}")
    public Student getStudent(@PathVariable Integer id){
        return this.restTemplate.getForObject(this.providerUrl + id,Student.class);
    }
}
