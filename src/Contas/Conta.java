package Contas;

public abstract class Conta {
    private String nrConta;
    private double saldo;
    private String senhaConta;
    private String tipoConta;

    public Conta(){

    }

    public Conta(String nrConta, double saldo, String senhaConta, String tipoConta){
        this.nrConta = nrConta;
        this.saldo = saldo;
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

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public abstract String getResumoConta();
}


