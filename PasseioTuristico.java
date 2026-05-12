package modelo;
import java.time.LocalDateTime;

public class PasseioTuristico extends Experiencia {
    private String pontoDeEncontro;
    private String guiaResponsavel;

    public PasseioTuristico(String titulo, String descricao, LocalDateTime dataHora, int capacidadeMax, double precoBase, String pontoDeEncontro, String guiaResponsavel) {
        super(titulo, descricao, dataHora, capacidadeMax, precoBase);
        this.pontoDeEncontro = pontoDeEncontro;
        this.guiaResponsavel = guiaResponsavel;
    }

    @Override
    public String GerarResumo() {
        return String.format("PASSEIO: %s | Encontro: %s | Guia: %s", 
            getTitulo(), pontoDeEncontro, guiaResponsavel);
    }
}
