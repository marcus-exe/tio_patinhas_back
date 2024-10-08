package com.fiap.br.models.register;

import java.util.*;

public class Usuario {
    public UUID idUsuario;
    public String nomeCompleto;
    private String email;
    private String senha;
    private String cpfCnpj;
    private String telefone;
    private Date dataCriacao;

    public Usuario() {
        idUsuario = UUID.randomUUID();
        dataCriacao = new Date();
    }

    //getter and setters

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpf(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getResumoUsuario(){
        return "\nId do usuário: " + this.getIdUsuario() +
                "\nNome Completo: " + this.getNomeCompleto() +
                "\nEmail: " + this.getEmail() +
                "\nSenha: " + this.getSenha() +
                "\nCPF ou CNPJ: " + this.getCpfCnpj() +
                "\nTelefone: " + this.getTelefone() +
                "\nData de Criação: " + this.getDataCriacao() + ".";
    }
}
