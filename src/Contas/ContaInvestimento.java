package Contas;

import java.util.*;
public class ContaInvestimento extends Conta {
    private String tipoMoeda;
    private String dataAbertura; /*MUDAR PARA DATE NOS METODOS TAMBEM*/
    private String statusConta;
    private String enderecoCarteira;

    public ContaInvestimento() {
        super();
    }

    public ContaInvestimento(String nrConta, double saldo, String senhaConta, String tipoConta) {
        super(nrConta, saldo, senhaConta, tipoConta);
    }

    public String getTipoMoeda() {
        return tipoMoeda;
    }

    public void setTipoMoeda(String tipoMoeda) {
        this.tipoMoeda = tipoMoeda;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(String statusConta) {
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
                "\nTipo de Moeda: " + this.getTipoMoeda() +
                "\nData de Abertura: " + this.getDataAbertura() +
                "\nStatus da Conta: " + this.getStatusConta() +
                "\nEndereço da Carteira: " + this.getEnderecoCarteira() + ".";
    }
}
