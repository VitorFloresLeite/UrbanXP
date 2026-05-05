public class Ingresso{

    enum estado{
        RESERVADO, PAGO, CANCELADO
    }

    private int preco;

    private estado estado;

    private String nomeEvento;

    public Ingresso(int preco, estado estado, String nomeEvento){
        this.preco = preco;
        this.estado = estado;
        this.nomeEvento = nomeEvento;
    }
}