package register;

import java.util.UUID;

public class Endereco {
    public UUID idEndereco;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cdEstado;
    private String cep;
    private String pais;

    public Endereco() {
        idEndereco = UUID.randomUUID();
    }

    //getter and setters

    public UUID getIdEndereco() {
        return idEndereco;
    }

    public String getCdEstado() {
        return cdEstado;
    }

    public void setCdEstado(String cdEstado) {
        this.cdEstado = cdEstado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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
                "\nNúmero: " + this.getNumero() +
                "\nComplemento: " + this.getComplemento() +
                "\nBairro: " + this.getBairro() +
                "\nCidade: " + this.getCidade() +
                "\nCd do Estado: " + this.getCdEstado() +
                "\nCEP: " + this.getCep() +
                "\nPaís: " + this.getPais() + ".";
    }
}
