package com.registro.usuarios.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

    @JsonProperty("bpname")
    private String bpname;


    public String getBpname() {
        return bpname;
    }
    public void setBpname(String bpname) {
        this.bpname = bpname;
    }
}
