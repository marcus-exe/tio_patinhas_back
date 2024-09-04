package Ativos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public abstract class HistoricoPrecos {
    public UUID idRegistro;
    private LocalDateTime dataHora;
    private BigDecimal precoAbertura;
    private BigDecimal precoFechamento;
    private BigDecimal precoMax;
    private BigDecimal precoMin;
    private double volumeNegociacao;

    public HistoricoPrecos(){
        idRegistro = UUID.randomUUID();
        dataHora = LocalDateTime.now();
    }

    public HistoricoPrecos(BigDecimal precoAbertura, BigDecimal precoFechamento, BigDecimal precoMax, BigDecimal precoMin, double volumeNegociacao){
        this.precoAbertura = precoAbertura;
        this.precoFechamento = precoFechamento;
        this.precoMax = precoMax;
        this.precoMin = precoMin;
        this.volumeNegociacao = volumeNegociacao;
    }

    public UUID getIdRegistro() {
        return idRegistro;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public BigDecimal getPrecoAbertura() {
        return precoAbertura;
    }

    public void setPrecoAbertura(BigDecimal precoAbertura) {
        this.precoAbertura = precoAbertura;
    }

    public BigDecimal getPrecoFechamento() {
        return precoFechamento;
    }

    public void setPrecoFechamento(BigDecimal precoFechamento) {
        this.precoFechamento = precoFechamento;
    }

    public BigDecimal getPrecoMax() {
        return precoMax;
    }

    public void setPrecoMax(BigDecimal precoMax) {
        this.precoMax = precoMax;
    }

    public BigDecimal getPrecoMin() {
        return precoMin;
    }

    public void setPrecoMin(BigDecimal precoMin) {
        this.precoMin = precoMin;
    }

    public double getVolumeNegociacao() {
        return volumeNegociacao;
    }

    public void setVolumeNegociacao(double volumeNegociacao) {
        this.volumeNegociacao = volumeNegociacao;
    }

    public abstract String getResumoAtivo();
}
