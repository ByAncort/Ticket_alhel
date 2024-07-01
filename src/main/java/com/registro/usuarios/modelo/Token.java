package com.registro.usuarios.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Token {

    @JsonProperty("expiryDate")
    private String expiryDate;

    @JsonProperty("expiryTime")
    private String expiryTime;

    @JsonProperty("status")
    private int status;

    @JsonProperty("token")
    private String token;

    @JsonProperty("Timezone")
    private String timezone;

    // Constructor, getters y setters

    public Token() {
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
