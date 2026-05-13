package modelo;

import java.time.LocalDateTime;

public class Show extends Experiencia {
    private String artistaPrincipal;

    public Show(String titulo, String descricao, LocalDateTime dataHora, int capacidadeMax, double precoBase, String artistaPrincipal) {
        super(titulo, descricao, dataHora, capacidadeMax, precoBase);
        this.artistaPrincipal = artistaPrincipal;
    }

    @Override
    public String GerarResumo() {
        return String.format("SHOW: %s | Artista: %s | Data: %s | Preço: R$%.2f",
                getTitulo(), artistaPrincipal, getDataHora(), getPrecoBase());
    }
}
