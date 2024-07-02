package com.registro.usuarios.servicio;

public interface UnifierService {
    String obtenerToken();


    String guardarTicket(String OT_TITULO_TB250,
                         String OT_PRIORIDAD_SPD,
                         String OT_CATEGORIA_SPD,
                         String TIC_DESCRIPCION_TB2000,
                         String TIC_USERPORTAL_TB120,
                         String TIC_EMPRESAUSERPORTAL_TB120);
}
