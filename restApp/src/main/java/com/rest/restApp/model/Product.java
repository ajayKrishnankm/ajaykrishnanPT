package com.rest.restApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Product {

    private String productId;
    private String productName;
    private String unitOfMeasure;
    private Date launchDate;
}
