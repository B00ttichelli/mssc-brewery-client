package com.example.msscbreweryclient.web.client;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

public class BreweryClient {

    private String APIHost;

    public void setAPIHost(String APIHost) {
        this.APIHost = APIHost;
    }
}
