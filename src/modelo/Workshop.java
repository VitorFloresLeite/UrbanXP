package modelo;

public class Workshop extends Experiencia {
    private final String materiais;

    private Workshop(Builder builder) {
        super(builder);
        this.materiais = builder.materiais;
    }

    @Override
    public String GerarResumo() {
        return String.format(
            "WORKSHOP: %s | Materiais necessários: %s | Vagas: %d",
            getTitulo(), materiais, getCapacidadeMax()
        );
    }

    public static class Builder extends Experiencia.Builder<Builder> {
        private final String materiais;

        public Builder(String titulo, String descricao, java.time.LocalDateTime dataHora,
                       int capacidadeMax, double precoBase, String materiais) {
            super(titulo, descricao, dataHora, capacidadeMax, precoBase);
            this.materiais = materiais;
        }

        @Override
        protected Builder self() {
            return this;
        }

        public Workshop build() {
            return new Workshop(this);
        }
    }
}
