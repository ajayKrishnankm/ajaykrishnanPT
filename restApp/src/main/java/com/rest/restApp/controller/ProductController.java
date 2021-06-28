package com.rest.restApp.controller;

import com.rest.restApp.model.Product;
import com.rest.restApp.model.ProductList;
import com.rest.restApp.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/sortProducts")
    public ResponseEntity getSortedProducts(@RequestBody ProductList productList) {
        log.info("Sorting Started..");
        List<Product> sortedList = productService.sortProducts(productList.getProductList());
        log.info("Sorting done successfully");
        return  new ResponseEntity<>(sortedList, HttpStatus.OK);

    }
}
