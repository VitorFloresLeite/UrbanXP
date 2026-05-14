package modelo;
import java.time.LocalDateTime;


public abstract class Experiencia {
    private final String titulo;
    private final String descricao;
    private final LocalDateTime dataHora;
    private final int capacidadeMax;
    private final double precoBase;

    public Experiencia(String titulo, String descricao, LocalDateTime dataHora, int capacidadeMax, double precoBase){
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.capacidadeMax = capacidadeMax;
        this.precoBase = precoBase;
    }

    public abstract String GerarResumo();

    public String getTitulo(){
        return titulo;
    }
    public String getDescricao(){
        return descricao;
    }
    public LocalDateTime getDataHora(){
        return dataHora;
    }
    public int getCapacidadeMax(){
        return capacidadeMax;
    }
    public double getPrecoBase(){
        return precoBase;
    }
}
