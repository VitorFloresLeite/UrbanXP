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
    public void setstatus(IngressoStatus status){//apenas o set do status, pois os outros atributos não devem ser alterados após a compra
        this.status=status;
    }
    public Experiencia getexperiencia(){
        return experiencia;
    }
    public Cliente getcliente(){
        return cliente;
    }
    public double getvalorFinalPago(){
        return valorFinalPago;
    }
    public IngressoStatus getstatus(){
        return status;
    }
    public boolean getprioridade(){
        return prioridade;
    }
}
