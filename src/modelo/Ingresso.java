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
    public void setStatus(IngressoStatus status){//apenas o set do status, pois os outros atributos não devem ser alterados após a compra
        this.status=status;
    }
    public Experiencia getExperiencia(){
        return experiencia;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public double getValorFinalPago(){
        return valorFinalPago;
    }
    public IngressoStatus getStatus(){
        return status;
    }
    public boolean getPrioridade(){
        return prioridade;
    }
}
