package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        try {

            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            // Get response
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            try (BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                StringBuffer response = new StringBuffer();

                while ((line = bf.readLine()) != null) {
                    response.append(line);
                }
                System.out.println("Response Body: " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
