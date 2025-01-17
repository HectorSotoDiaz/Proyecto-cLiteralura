package com.alura.literAlura.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class GutendexClient {
    private final String BASE_URL = "https://gutendex.com/books";
    private final RestTemplate restTemplate;

    public GutendexClient() {
        this.restTemplate = new RestTemplate();
    }

    public List<String> buscarLibrosPorTitulo(String titulo) {
        String url = BASE_URL + "?search=" + titulo;
        JsonNode response = restTemplate.getForObject(url, JsonNode.class);

        List<String> titulosLibros = new ArrayList<>();
        if (response != null && response.has("results")) {
            for (JsonNode libro : response.get("results")) {
                titulosLibros.add(libro.get("title").asText());
            }
        }
        return titulosLibros;
    }
}