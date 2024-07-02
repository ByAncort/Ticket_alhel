package com.registro.usuarios.controlador;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketRequest {
    @JsonProperty("OT_TITULO_TB250")
    private String OT_TITULO_TB250;
    @JsonProperty("OT_PRIORIDAD_SPD")
    private String OT_PRIORIDAD_SPD;
    @JsonProperty("OT_CATEGORIA_SPD")
    private String OT_CATEGORIA_SPD;
    @JsonProperty("TIC_DESCRIPCION_TB2000")
    private String TIC_DESCRIPCION_TB2000;
    @JsonProperty("TIC_USERPORTAL_TB120")
    private String TIC_USERPORTAL_TB120;
    @JsonProperty("TIC_EMPRESAUSERPORTAL_TB120")
    private String TIC_EMPRESAUSERPORTAL_TB120;

    // Getters y setters
    public String getOT_TITULO_TB250() {
        return OT_TITULO_TB250;
    }

    public void setOT_TITULO_TB250(String OT_TITULO_TB250) {
        this.OT_TITULO_TB250 = OT_TITULO_TB250;
    }

    public String getOT_PRIORIDAD_SPD() {
        return OT_PRIORIDAD_SPD;
    }

    public void setOT_PRIORIDAD_SPD(String OT_PRIORIDAD_SPD) {
        this.OT_PRIORIDAD_SPD = OT_PRIORIDAD_SPD;
    }

    public String getOT_CATEGORIA_SPD() {
        return OT_CATEGORIA_SPD;
    }

    public void setOT_CATEGORIA_SPD(String OT_CATEGORIA_SPD) {
        this.OT_CATEGORIA_SPD = OT_CATEGORIA_SPD;
    }

    public String getTIC_DESCRIPCION_TB2000() {
        return TIC_DESCRIPCION_TB2000;
    }

    public void setTIC_DESCRIPCION_TB2000(String TIC_DESCRIPCION_TB2000) {
        this.TIC_DESCRIPCION_TB2000 = TIC_DESCRIPCION_TB2000;
    }

    public String getTIC_USERPORTAL_TB120() {
        return TIC_USERPORTAL_TB120;
    }

    public void setTIC_USERPORTAL_TB120(String TIC_USERPORTAL_TB120) {
        this.TIC_USERPORTAL_TB120 = TIC_USERPORTAL_TB120;
    }

    public String getTIC_EMPRESAUSERPORTAL_TB120() {
        return TIC_EMPRESAUSERPORTAL_TB120;
    }

    public void setTIC_EMPRESAUSERPORTAL_TB120(String TIC_EMPRESAUSERPORTAL_TB120) {
        this.TIC_EMPRESAUSERPORTAL_TB120 = TIC_EMPRESAUSERPORTAL_TB120;
    }
}
