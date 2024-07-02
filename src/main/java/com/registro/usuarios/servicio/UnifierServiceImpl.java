package com.registro.usuarios.servicio;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
    public String guardarTicket(
            String OT_TITULO_TB250,
            String OT_PRIORIDAD_SPD,
            String OT_CATEGORIA_SPD,
            String TIC_DESCRIPCION_TB2000,
            String TIC_USERPORTAL_TB120,
            String TIC_EMPRESAUSERPORTAL_TB120
    ){
        try {
            String UrlTicekt = baseUrl + "/ws/rest/service/v1/bp/record/MT-00013";
            URL url = new URL(UrlTicekt);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Configurar la conexión
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            String token = obtenerToken();
            con.setRequestProperty("Authorization", "Bearer " + token);

            // Habilitar la escritura de datos en la conexión
            con.setDoOutput(true);

            // Construir el cuerpo JSON
            String jsonBody = "{\n" +
                    "    \"options\": {\n" +
                    "        \"bpname\": \"Incidencias Arrendatarios\"\n" +
                    "    },\n" +
                    "    \"data\": [\n" +
                    "        {\n" +
                    "            \"OT_TITULO_TB250\": \"" + OT_TITULO_TB250 + "\",\n" +
                    "            \"OT_PRIORIDAD_SPD\": \""+OT_PRIORIDAD_SPD+"\",\n" +
                    "            \"OT_CATEGORIA_SPD\": \""+OT_CATEGORIA_SPD+"\",\n" +
                    "            \"TIC_DESCRIPCION_TB2000\": \""+TIC_DESCRIPCION_TB2000+"\",\n" +
                    "            \"TIC_USERPORTAL_TB120\": \""+TIC_USERPORTAL_TB120+"\",\n" +
                    "            \"TIC_EMPRESAUSERPORTAL_TB120\": \""+TIC_EMPRESAUSERPORTAL_TB120+"\"\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";

            // Enviar el cuerpo JSON a la conexión
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.writeBytes(jsonBody);
                wr.flush();
            }

            // Obtener el código de respuesta HTTP
            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);

            // Leer la respuesta del servidor
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }

            // Imprimir la respuesta del servidor
            System.out.println(response.toString());

            // Procesar la respuesta según sea necesario
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return "Ticket guardado exitosamente";
            } else {
                throw new RuntimeException("Failed to save ticket: " + responseCode);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el ticket: " + e.getMessage(), e);
        }
    }

}