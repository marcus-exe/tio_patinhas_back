package Procedimentos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class Transacao {
    public UUID idTransacao;
    private String tipoTransacao;
    private BigDecimal montante;
    private LocalDateTime data;
    private boolean permissao;
    private String descricao;
    private String contaOrigem;
    private String contaDestino;
    private String hashTransacao;
    private double taxaTransacao;

    public UUID getIdTransacao() {
        return idTransacao;
    }


    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public BigDecimal getMontante() {
        return montante;
    }

    public void setMontante(BigDecimal montante) {
        this.montante = montante;
    }

    public LocalDateTime getData() { return data; }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public boolean getPermissao() {
        return permissao;
    }

    public void setPermissao(boolean permissao) {
        this.permissao = permissao;
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

    public double getTaxaTransacao() {
        return taxaTransacao;
    }

    public void setTaxaTransacao(double taxaTransacao) {
        this.taxaTransacao = taxaTransacao;
    }

    public String getResumoTransacao() {
        return  "ID da Transação: " + this.getIdTransacao() +
                "\nTipo de Transação: " + this.getTipoTransacao() +
                "\nMontante: R$" + this.getMontante() +
                "\nData: " + this.getData() +
                "\nPermissão: " + this.getPermissao() +
                "\nDescrição: " + this.getDescricao() +
                "\nEndereço Origem: " + this.getContaOrigem() +
                "\nEndereço Destino: " + this.getContaDestino() +
                "\nHash de Transação: " + this.getHashTransacao() +
                "\nTaxa de Transação: " + this.getTaxaTransacao() + ".";
    }
}
