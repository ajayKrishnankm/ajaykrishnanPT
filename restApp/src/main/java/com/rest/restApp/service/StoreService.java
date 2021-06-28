package com.rest.restApp.service;

import com.rest.restApp.model.Store;
import com.rest.restApp.model.StoreCapacity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class StoreService {
    private static List<Store> availabilityList= new ArrayList<Store>();
    private static List<StoreCapacity> capacityList= new ArrayList<StoreCapacity>();
    public void intializeAvailability(){
        availabilityList.add(new Store("Store001", "Prod1", new Date(2021 - 02 - 19), 1.0));
        availabilityList.add(new Store("Store001", "Prod2", new Date(2021 - 02 - 20), 3.0));
        availabilityList.add(new Store("Store001", "Prod2", new Date(2021 - 02 - 21), 0));
    }

    public void intializeCapacity() {
        capacityList.add(new StoreCapacity(" Store001", "Prod1", new Date(2021 - 02 - 19), 0));
        capacityList.add(new StoreCapacity(" Store001", "Prod1", new Date(2021 - 02 - 20), 2.0));
        capacityList.add(new StoreCapacity(" Store001", "Prod1", new Date(2021 - 02 - 21), 2.0));
        capacityList.add(new StoreCapacity(" Store001", "Prod1", new Date(2021 - 02 - 22), 0));
    }

    @Async
    public CompletableFuture<Store> getAvailability(String storeNo) {
        log.info("getting Store Availability details asynchronously - started");
        Optional<Store> store = availabilityList.stream()
                .filter(x -> x.getStoreNo().equals(storeNo))
                .findFirst();
        log.info("getting Store Availability  asynchronously - ended");
        return CompletableFuture.completedFuture(store.get());

    }
    @Async
    public CompletableFuture<StoreCapacity> getCapacity(String storeNo) {
        log.info("getting Store Availability details asynchronously - started");
        Optional<StoreCapacity> capacity = capacityList.stream()
                .filter(x -> x.getStoreNo().equals(storeNo))
                .findFirst();
        log.info("getting Store Availability  asynchronously - ended");
        return CompletableFuture.completedFuture(capacity.get());

    }
}
