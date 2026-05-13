package modelo;

public class Ingresso {
    private Experiencia experiencia;
    private Cliente cliente;
    private double valorFinalPago;
    private IngressoStatus status;

    public Ingresso(Experiencia experiencia, Cliente cliente, double valorFinalPago, IngressoStatus status){
        this.experiencia=experiencia;
        this.cliente=cliente;
        this.valorFinalPago=valorFinalPago;
        this.status=status;
    }
}
