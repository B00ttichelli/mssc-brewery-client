package com.example.msscbreweryclient.web.client;


import com.example.msscbreweryclient.web.model.BeerDto;
import com.example.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "my.brewery", ignoreUnknownFields = false)
public class BreweryClient {


    public final String beerPathV1 = "/api/v1/beer/";
    public final String CLIENT_PATHV1 = "/api/v1/customer/";
    private final RestTemplate restTemplate;
    private String APIHost;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setAPIHost(String APIHost) {
        this.APIHost = APIHost;
    }

    public BeerDto getBeerById(UUID id){
        return restTemplate.getForObject(APIHost+beerPathV1+id.toString(),BeerDto.class);
    }

    public URI saveNewBeer (BeerDto beerDto){
            return restTemplate.postForLocation(APIHost+beerPathV1,beerDto);

    }

    public void updateBeer(UUID id, BeerDto beerDto){
        restTemplate.put(APIHost+beerPathV1+id.toString(),beerDto);

    }

    public void deleteBeer(UUID id){
        restTemplate.delete(APIHost+beerPathV1+id.toString());
    }

    public CustomerDto getCustomerById(UUID id){
        return restTemplate.getForObject(APIHost+CLIENT_PATHV1+id.toString(),CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(APIHost+CLIENT_PATHV1,customerDto);
    }

    public void updateCustomer(UUID id, CustomerDto customerDto){
        restTemplate.put(APIHost+CLIENT_PATHV1+id.toString(),customerDto);
    }

    public void deleteCustomer(UUID id){
        restTemplate.delete(APIHost+CLIENT_PATHV1+id.toString());
    }
}
