package com.rest.restApp.controller;

import com.rest.restApp.model.ProductResponse;
import com.rest.restApp.model.Store;
import com.rest.restApp.model.StoreCapacity;
import com.rest.restApp.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/getProdAvailability")
    public ResponseEntity getProdAvailability(@RequestBody Store store) throws ExecutionException, InterruptedException {
        storeService.intializeAvailability();
        storeService.intializeCapacity();
        CompletableFuture<Store> storeAvailability = storeService.getAvailability(store.getStoreNo());
        CompletableFuture<StoreCapacity> StoreCapacity = storeService.getCapacity(store.getStoreNo());
        CompletableFuture.allOf(storeAvailability, StoreCapacity).join();
        ProductResponse response= new ProductResponse(storeAvailability.get(), StoreCapacity.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
