package modelo;

public class Show extends Experiencia {
    private final String artistaPrincipal;

    private Show(Builder builder) {
        super(builder);
        this.artistaPrincipal = builder.artistaPrincipal;
    }

    @Override
    public String GerarResumo() {
        return String.format(
            "SHOW: %s | Artista: %s | Data: %s | Preço: R$%.2f",
            getTitulo(), artistaPrincipal, getDataHora(), getPrecoBase()
        );
    }

    public static class Builder extends Experiencia.Builder<Builder> {
        private final String artistaPrincipal;

        public Builder(String titulo, String descricao, java.time.LocalDateTime dataHora,
                       int capacidadeMax, double precoBase, String artistaPrincipal) {
            super(titulo, descricao, dataHora, capacidadeMax, precoBase);
            this.artistaPrincipal = artistaPrincipal;
        }

        @Override
        protected Builder self() {
            return this;
        }

        public Show build() {
            return new Show(this);
        }
    }
}
