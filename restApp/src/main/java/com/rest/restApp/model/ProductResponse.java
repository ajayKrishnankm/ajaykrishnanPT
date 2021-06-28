package com.rest.restApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {
        private Store store;
        private StoreCapacity storeCapacity;
}
