package com.fiap.br.models.register;

import java.util.Date;
import java.util.UUID;

public class Endereco {
    public UUID idEndereco;
    private String rua;
    private int numero;

    public Endereco(String id, String rua_input, Integer numero_input) {
        idEndereco = UUID.fromString(id);
        rua = rua_input;
        numero = numero_input;
    }

    //
    public Endereco() {
        idEndereco = UUID.randomUUID();
    }


    //getter and setters

    public UUID getIdEndereco() {
        return idEndereco;
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getResumoEndereco(){
        return "\nId do endereço: " + this.getIdEndereco() +
                "\nRua: " + this.getRua() +
                "\nNúmero: " + this.getNumero() + ".";
    }
}
