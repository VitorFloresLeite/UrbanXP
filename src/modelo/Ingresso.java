package modelo;

public class Ingresso {
    private Experiencia experiencia;
    private Cliente cliente;
    private double valorFinalPago;
    private IngressoStatus status;
    private boolean prioridade;

    public Ingresso(Experiencia experiencia, Cliente cliente, double valorFinalPago, IngressoStatus status, boolean prioridade) {
        this.experiencia=experiencia;
        this.cliente=cliente;
        this.valorFinalPago=valorFinalPago;
        this.status=status;
        this.prioridade=prioridade;
    }
}
