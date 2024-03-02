package org.futurecollars.lesson12.task1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterUrl {

    public static void saveUrlToFile(String filename, String resourcesPath, String urlForWrite) throws Exception {

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest httpRequest =
                HttpRequest.newBuilder(new URI(urlForWrite))
                        .GET()
                        .build();

        HttpResponse<String> httpResponse = httpClient
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        int statusCode = httpResponse.statusCode();

        if (statusCode == 200) {
            String responseBody = httpResponse.body();
            saveToFile(responseBody, resourcesPath, filename);
            System.out.println("Strona została zapisana jako " + filename);
        } else {
            System.err.println("Nie udało się pobrać zawartości strony. Kod statusu: " + statusCode);
        }
    }

    public static void saveToFile(String content, String resourcePath, String filename) {

        try {
            Path path = Path.of(resourcePath, filename);
            BufferedWriter writer = Files.newBufferedWriter(path);
            writer.write(content);
            writer.close();
            System.out.println("Zawartość zapisana do pliku: " + path);
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas zapisywania do pliku: " + e.getMessage());
        }
    }
}
