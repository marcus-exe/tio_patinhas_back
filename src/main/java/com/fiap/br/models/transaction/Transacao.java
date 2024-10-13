package com.fiap.br.models.transaction;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.*;

public class Transacao {
    public UUID idTransacao;
    private String nrConta;
    private String tipoTransacao;
    private BigDecimal montante;
    private Date data;
    private String descricao;
    private String contaOrigem;
    private String contaDestino;
    private String hashTransacao;
    private double taxaTransacao;
    public UUID idCliente;
    public UUID idCorretora;

    public UUID getIdTransacao() {
        return idTransacao;
    }

    public BigDecimal getMontante() {
        return montante;
    }

    public void setMontante(BigDecimal montante) {
        this.montante = montante;
    }

    public Date getData() { return data; }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(String contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public String getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(String contaDestino) {
        this.contaDestino = contaDestino;
    }

    public String getHashTransacao() {
        return hashTransacao;
    }

    public void setHashTransacao(String hashTransacao) {
        this.hashTransacao = hashTransacao;
    }
    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public double getTaxaTransacao() {
        return taxaTransacao;
    }

    public void setTaxaTransacao(double taxaTransacao) {
        this.taxaTransacao = taxaTransacao;
    }
    public String getNrConta() {
        return nrConta;
    }

    public void setNrConta(String nrConta) {
        this.nrConta = nrConta;
    }
    public Transacao() {
        idCorretora = UUID.randomUUID();
        idCliente = UUID.randomUUID();
    }

    //getter and setters

    public UUID getIdCorretora() {
        return idCorretora;
    }
    //getter and setters

    public UUID getIdCliente() {
        return idCliente;
    }


    public String getResumoTransacao() {
        return  "ID da Transação: " + this.getIdTransacao() +
                "\nMontante: R$" + this.getMontante() +
                "\nData: " + this.getData() +
                "\nDescrição: " + this.getDescricao() +
                "\nEndereço Origem: " + this.getContaOrigem() +
                "\nEndereço Destino: " + this.getContaDestino() +
                "\nHash de Transação: " + this.getHashTransacao() +
                "\nTaxa de Transação: " + this.getTaxaTransacao() + ".";
    }
}
