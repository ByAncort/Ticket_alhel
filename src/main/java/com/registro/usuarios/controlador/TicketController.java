package com.registro.usuarios.controlador;

import com.registro.usuarios.modelo.Data;
import com.registro.usuarios.servicio.UnifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final UnifierService unifierService;

    @Autowired
    public TicketController(UnifierService unifierService) {
        this.unifierService = unifierService;
    }

    @PostMapping("/guardar")
    public String guardarTicket(@RequestBody TicketRequest ticketRequest) {
        String resultado = unifierService.guardarTicket(
                ticketRequest.getOT_TITULO_TB250(),
                ticketRequest.getOT_PRIORIDAD_SPD(),
                ticketRequest.getOT_CATEGORIA_SPD(),
                ticketRequest.getTIC_DESCRIPCION_TB2000(),
                ticketRequest.getTIC_USERPORTAL_TB120(),
                ticketRequest.getTIC_EMPRESAUSERPORTAL_TB120()
        );

        return resultado;
    }
    @PostMapping("/consultar")
    public String consultarTicket(@RequestBody Data data) {
        return unifierService.consultarInformacion(data.getBpname());
    }

}