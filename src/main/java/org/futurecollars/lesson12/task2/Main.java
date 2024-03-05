package org.futurecollars.lesson12.task2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//import static com.sun.org.apache.xml.internal.security.algorithms.implementations.SignatureDSA.URI;

public class Main {

    public static void main(String[] args) throws Exception {
        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest httpRequest =
                HttpRequest.newBuilder(new URI("http://localhost:8080/hello?name=Tom"))
                        .GET()
                        .build();

        HttpResponse<String> httpResponse = httpClient
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        int statusCode = httpResponse.statusCode();
        System.out.println(httpResponse.body());
    }
}
