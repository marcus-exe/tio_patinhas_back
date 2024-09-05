package Contas;

import java.time.LocalDateTime;
public class ContaInvestimento extends Conta {
    private String tipoMoeda;
    private LocalDateTime dataAbertura;
    private String statusConta;
    private String enderecoCarteira;

    public ContaInvestimento() {
        super();
        dataAbertura = LocalDateTime.now();
    }

    public ContaInvestimento(String nrConta, String senhaConta, String tipoConta) {
        super(nrConta, senhaConta, tipoConta);
    }

    public String getTipoMoeda() {
        return tipoMoeda;
    }

    public void setTipoMoeda(String tipoMoeda) {
        this.tipoMoeda = tipoMoeda;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
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
