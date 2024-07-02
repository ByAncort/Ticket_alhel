package com.registro.usuarios.controlador;

import com.registro.usuarios.servicio.UnifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private UnifierService unifierService;

    @PostMapping("/guardar")

    public ResponseEntity<String> guardarTicket() {
        try {
            String resultado = unifierService.guardarTicket();
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al guardar el ticket: " + e.getMessage());
        }
    }

}
