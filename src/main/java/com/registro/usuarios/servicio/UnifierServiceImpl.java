package com.registro.usuarios.servicio;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.registro.usuarios.modelo.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UnifierServiceImpl implements UnifierService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${baseUrl}")
    private String baseUrl;
    @Override
    public String obtenerToken() {
        String tokenUrl = baseUrl + "/ws/rest/service/v1/login";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic JCRleGNlbDokJGV4Y2Vs");

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                tokenUrl,
                HttpMethod.GET,
                requestEntity,
                String.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            try {
                // Parsear directamente el token del cuerpo de la respuesta JSON
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(response.getBody());
                return rootNode.path("token").asText();
            } catch (Exception e) {
                throw new RuntimeException("Failed to parse token response", e);
            }
        } else {
            throw new RuntimeException("Failed to obtain token: " + response.getStatusCode());
        }
    }
    private String guardarTicket(){
        String token = obtenerToken();
    }
}
