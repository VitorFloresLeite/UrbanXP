package modelo;

public class PasseioTuristico extends Experiencia {
    private final String pontoDeEncontro;
    private final String guiaResponsavel;

    private PasseioTuristico(Builder builder) {
        super(builder);
        this.pontoDeEncontro = builder.pontoDeEncontro;
        this.guiaResponsavel = builder.guiaResponsavel;
    }

    @Override
    public String GerarResumo() {
        return String.format(
            "PASSEIO: %s | Encontro: %s | Guia: %s",
            getTitulo(), pontoDeEncontro, guiaResponsavel
        );
    }

    public static class Builder extends Experiencia.Builder<Builder> {
        private final String pontoDeEncontro;
        private final String guiaResponsavel;

        public Builder(String titulo, String descricao, java.time.LocalDateTime dataHora,
                       int capacidadeMax, double precoBase, String pontoDeEncontro, String guiaResponsavel) {
            super(titulo, descricao, dataHora, capacidadeMax, precoBase);
            this.pontoDeEncontro = pontoDeEncontro;
            this.guiaResponsavel = guiaResponsavel;
        }

        @Override
        protected Builder self() {
            return this;
        }

        public PasseioTuristico build() {
            return new PasseioTuristico(this);
        }
    }
}
