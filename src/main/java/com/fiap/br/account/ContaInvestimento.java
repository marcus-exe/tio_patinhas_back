package com.fiap.br.account;


import com.fiap.br.enums.StatusConta;
import com.fiap.br.enums.TipoConta;
import com.fiap.br.enums.TipoCriptoativo;

import java.time.LocalDateTime;
public class ContaInvestimento extends Conta {
    private TipoCriptoativo tipoCriptoativo;
    private LocalDateTime dataAbertura;
    private StatusConta statusConta;
    private String enderecoCarteira;

    public ContaInvestimento() {
        super();
        dataAbertura = LocalDateTime.now();
    }

    public ContaInvestimento(String nrConta, String senhaConta, TipoConta tipoConta) {
        super(nrConta, senhaConta, tipoConta);
    }

    public TipoCriptoativo getTipoCriptoativo() {
        return tipoCriptoativo;
    }

    public void setTipoCriptoativo(TipoCriptoativo tipoCriptoativo) {
        this.tipoCriptoativo = tipoCriptoativo;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public StatusConta getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(StatusConta statusConta) {
        this.statusConta = statusConta;
    }

    public String getEnderecoCarteira() {
        return enderecoCarteira;
    }

    public void setEnderecoCarteira(String enderecoCarteira) {
        this.enderecoCarteira = enderecoCarteira;
    }

    @Override
    public String getResumoConta() {
        return  "Número da Conta: " + this.getNrConta() +
                "\nSaldo: " + this.getSaldo() +
                "\nSenha da Conta: R$" + this.getSenhaConta() +
                "\nTipo da Conta: " + this.getTipoConta() +
                "\nTipo de Moeda: " + this.getTipoCriptoativo() +
                "\nData de Abertura: " + this.getDataAbertura() +
                "\nStatus da Conta: " + this.getStatusConta() +
                "\nEndereço da Carteira: " + this.getEnderecoCarteira() + ".";
    }
}
