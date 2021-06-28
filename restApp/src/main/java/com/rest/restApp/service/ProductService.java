package com.rest.restApp.service;

import com.rest.restApp.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductService {

    public List<Product> sortProducts(List<Product> products) {
        List<Product> sortedProducts = products.stream()
                .sorted(Comparator.comparing(Product::getProductId).
                        thenComparing(Product::getLaunchDate).reversed()).collect(Collectors.toList());
        return sortedProducts;
    }
}
