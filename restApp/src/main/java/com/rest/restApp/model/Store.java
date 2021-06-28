package com.rest.restApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Store {
    private String storeNo;
    private String productId;
    private Date reqDate;
    private double availQty;
}
