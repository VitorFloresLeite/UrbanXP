package modelo;
import java.time.LocalDateTime;


public abstract class Experiencia {
    protected String Titulo;
    protected String descricao;
    protected LocalDateTime dataHora;
    protected int capacidadeMax;
    protected double precoBase;

    public Experiencia(String titulo, String descricao, LocalDateTime dataHora, int capacidadeMax, double precoBase){
        this.Titulo = titulo;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.capacidadeMax = capacidadeMax;
        this.precoBase = precoBase;
    }

    public abstract String GerarResumo();

    public String getTitulo(){
        return Titulo;
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
