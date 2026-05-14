package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Experiencia {
    private final String titulo;
    private final String descricao;
    private final LocalDateTime dataHora;
    private final int capacidadeMax;
    private final double precoBase;

    // opcionais
    private final List<String> brindes;
    private final List<String> patrocinadores;
    private final Integer restricaoIdade;

    protected Experiencia(Builder<?> builder) {
        this.titulo = builder.titulo;
        this.descricao = builder.descricao;
        this.dataHora = builder.dataHora;
        this.capacidadeMax = builder.capacidadeMax;
        this.precoBase = builder.precoBase;
        this.brindes = builder.brindes;
        this.patrocinadores = builder.patrocinadores;
        this.restricaoIdade = builder.restricaoIdade;
    }

    public abstract String GerarResumo();

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public int getCapacidadeMax() {
        return capacidadeMax;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public List<String> getBrindes() {
        return Collections.unmodifiableList(brindes);
    }

    public List<String> getPatrocinadores() {
        return Collections.unmodifiableList(patrocinadores);
    }

    public Integer getRestricaoIdade() {
        return restricaoIdade;
    }

    public static abstract class Builder<T extends Builder<T>> {
        private final String titulo;
        private final String descricao;
        private final LocalDateTime dataHora;
        private final int capacidadeMax;
        private final double precoBase;

        private List<String> brindes = new ArrayList<>();
        private List<String> patrocinadores = new ArrayList<>();
        private Integer restricaoIdade;

        protected Builder(String titulo, String descricao, LocalDateTime dataHora, int capacidadeMax, double precoBase) {
            this.titulo = titulo;
            this.descricao = descricao;
            this.dataHora = dataHora;
            this.capacidadeMax = capacidadeMax;
            this.precoBase = precoBase;
        }

        protected abstract T self();

        public T adicionarBrinde(String brinde) {
            if (brinde != null && !brinde.isBlank()) {
                this.brindes.add(brinde);
            }
            return self();
        }

        public T adicionarPatrocinador(String patrocinador) {
            if (patrocinador != null && !patrocinador.isBlank()) {
                this.patrocinadores.add(patrocinador);
            }
            return self();
        }

        public T restricaoIdade(Integer restricaoIdade) {
            if (restricaoIdade != null && restricaoIdade >= 0) {
                this.restricaoIdade = restricaoIdade;
            }
            return self();
        }
    }
}
