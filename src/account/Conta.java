package account;

import enums.TipoConta;

public abstract class Conta {
    private String nrConta;
    private double saldo;
    private String senhaConta;
    private TipoConta tipoConta;

    public Conta(){

    }

    public Conta(String nrConta, String senhaConta, TipoConta tipoConta){
        this.nrConta = nrConta;
        this.saldo = 0;
        this.senhaConta = senhaConta;
        this.tipoConta = tipoConta;
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

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public abstract String getResumoConta();
}


