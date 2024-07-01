package com.registro.usuarios.servicio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.registro.usuarios.modelo.Token;
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
    public Token obtenerToken() {
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
                ObjectMapper objectMapper = new ObjectMapper();
                Token token = objectMapper.readValue(response.getBody(), Token.class);
                return token;
            } catch (Exception e) {
                throw new RuntimeException("Failed to parse token response", e);
            }
        } else {
            throw new RuntimeException("Failed to obtain token: " + response.getStatusCode());
        }
    }



}
