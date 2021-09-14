package com.example.msscbreweryclient.web.client;

import com.example.msscbreweryclient.web.model.BeerDto;
import com.example.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerByID () {

        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void testSaveNewBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").beerStyle("PILSNER").build();

        URI uri = breweryClient.saveNewBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }
    @Test
    void testUpdateBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").beerStyle("PILSNER").build();
        breweryClient.updateBeer(UUID.randomUUID(),beerDto);
    }

    @Test
    void testDeleteBeer(){
        breweryClient.deleteBeer(UUID.randomUUID());
    }


    @Test
    void testGetCustomer(){
        CustomerDto customerDto = breweryClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void saveNewCustomer(){
        CustomerDto customerDto = CustomerDto.builder().name("Alex").build();

        URI uri = breweryClient.saveNewCustomer(customerDto);
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void testUpdateCustomer(){
        CustomerDto customerDto = CustomerDto.builder().name("Alex").build();
        breweryClient.updateCustomer(UUID.randomUUID(),customerDto);
    }

    @Test
    void testDeleteCustomer(){
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}