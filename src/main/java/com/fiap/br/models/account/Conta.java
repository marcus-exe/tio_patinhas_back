package com.fiap.br.models.account;


import com.fiap.br.models.enums.StatusConta;
import com.fiap.br.models.enums.TipoConta;
import com.fiap.br.models.enums.TipoCriptoativo;

import java.util.Date;
import java.util.UUID;

public class Conta {
    private String nrConta;
    private String senhaConta;
    private double saldo;
    private TipoConta tipoConta;
    private StatusConta statusConta;
    private Date dataCriacao;
    private String enderecoCarteira;
    private TipoCriptoativo tipoCriptoativo;
    private UUID idCliente;
    private UUID idCorretora;

    public Conta() {
        dataCriacao = new Date();
        saldo = 0;
        this.statusConta = StatusConta.INATIVA;
        idCliente = UUID.randomUUID(); //sem tempo de implementar com lógica completinha
        idCorretora = UUID.randomUUID();  //sem tempo de implementar com lógica completinha
    }

    public Conta (String nr_conta){
        this.nrConta = nrConta;
    }

    public Conta(String nrConta, String senhaConta, TipoConta tipoConta) {
        this.nrConta = nrConta;
        saldo = 0;
        this.senhaConta = senhaConta;
        this.tipoConta = tipoConta;
        this.statusConta = StatusConta.INATIVA;
        dataCriacao = new Date();
        idCliente = UUID.randomUUID(); //sem tempo de implementar com lógica completinha
        idCorretora = UUID.randomUUID();  //sem tempo de implementar com lógica completinha
    }

    public UUID getIdCorretora() {
        return idCorretora;
    }

    public void setIdCorretora(UUID idCorretora) {
        this.idCorretora = idCorretora;
    }

    public UUID getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
    }

    public String getEnderecoCarteira() {
        return enderecoCarteira;
    }

    public void setEnderecoCarteira(String enderecoCarteira) {
        this.enderecoCarteira = enderecoCarteira;
    }

    public String getNrConta() {
        return nrConta;
    }

    public void setNrConta(String nrConta) {
        this.nrConta = nrConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getSenhaConta() {
        return senhaConta;
    }

    public void setSenhaConta(String senhaConta) {
        this.senhaConta = senhaConta;
    }

    public String getTipoConta() {
        return tipoConta.toString();
    }

    public java.sql.Date getDataCriacao() {
        return new java.sql.Date(dataCriacao.getTime());
    }

    public String getStatusConta() {
        return statusConta.toString();
    }

    public void setStatusConta(StatusConta statusConta) {
        this.statusConta = statusConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getTipoCriptoativo() {
        return tipoCriptoativo.toString();
    }

    public void setTipoCriptoativo(TipoCriptoativo tipoCriptoativo) {
        this.tipoCriptoativo = tipoCriptoativo;
    }

    public String getResumoConta() {
        return  "Número da Conta: " + this.getNrConta() +
                "\nSaldo: " + this.getSaldo() +
                "\nSenha da Conta: R$" + this.getSenhaConta() +
                "\nTipo da Conta: " + this.getTipoConta() +
                "\nTipo de Moeda: " + this.getTipoCriptoativo() +
                "\nData de Abertura: " + this.getDataCriacao() +
                "\nStatus da Conta: " + this.getStatusConta() +
                "\nEndereço da Carteira: " + this.getEnderecoCarteira() + ".";
    }
}


