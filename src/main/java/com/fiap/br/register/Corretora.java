package com.fiap.br.register;



import com.fiap.br.enums.TipoCriptoativo;

import java.util.UUID;

public class Corretora {
    public UUID idCorretora;
    public String nomeCorretora;
    private String cnpj;
    private String telefone;
    private String email;
    private TipoCriptoativo tiposCriptoativosSuportados;
    private String enderecoCarteiraCorretora;

    public Corretora() {
        idCorretora = UUID.randomUUID();
    }

    //getter and setters

    public UUID getIdCorretora() {
        return idCorretora;
    }

    public String getNomeCorretora() {
        return nomeCorretora;
    }

    public void setNomeCorretora(String nomeCorretora) {
        this.nomeCorretora = nomeCorretora;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoCriptoativo getTiposCriptoativosSuportados() {
        return tiposCriptoativosSuportados;
    }

    public void setTiposCriptoativosSuportados(TipoCriptoativo tiposCriptoativosSuportados) {
        this.tiposCriptoativosSuportados = tiposCriptoativosSuportados;
    }

    public String getEnderecoCarteiraCorretora() {
        return enderecoCarteiraCorretora;
    }

    public void setEnderecoCarteiraCorretora(String enderecoCarteiraCorretora) {
        this.enderecoCarteiraCorretora = enderecoCarteiraCorretora;
    }

    public String getResumoCorretora(){
        return "\nId da corretora: " + this.getIdCorretora() +
                "\nNome da corretora: " + this.getNomeCorretora() +
                "\nCNPJ: " + this.getCnpj() +
                "\nTelefone: " + this.getTelefone() +
                "\nEmail: " + this.getEmail() +
                "\nTipos de Criptoativos Suportados: " + this.getTiposCriptoativosSuportados() +
                "\nEndereço de Carteira da Corretora: " + this.getEnderecoCarteiraCorretora() + ".";
    }
}
