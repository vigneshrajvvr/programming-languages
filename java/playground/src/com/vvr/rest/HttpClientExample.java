package com.vvr.rest;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://api.postalpincode.in/pincode/110001"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String responseBody = response.body();
        System.out.println(responseBody);

        Gson gson = new Gson();
        PinCode[] pinCodes = gson.fromJson(responseBody, PinCode[].class);

        for(PinCode pinCode : pinCodes) {
            System.out.println(pinCode.getMessage());
            System.out.print(pinCode.getStatus());
            if(pinCode.getPostOffices() != null) {
                for (PostOffice postOffice : pinCode.getPostOffices()) {
                    System.out.println(postOffice.getBlock());
                    System.out.println(postOffice.getCircle());
                    System.out.println(postOffice.getBranchType());
                    System.out.println(postOffice.getCountry());
                }
            }
        }
    }

}
