package modelo;

public class Ingresso {
    private Experiencia experiencia;
    private Cliente cliente;
    private double valorFinalPago;
    private IngressoStatus status;
    private boolean prioridade;
    private String dataEmissao;

    public Ingresso(Experiencia experiencia, Cliente cliente, double valorFinalPago, IngressoStatus status, boolean prioridade) {
        this.experiencia=experiencia;
        this.cliente=cliente;
        this.valorFinalPago=valorFinalPago;
        this.status=status;
        this.prioridade=prioridade;
        this.dataEmissao = java.time.ZonedDateTime
            .now(java.time.ZoneId.of("America/Sao_Paulo"))//fuso horário de Brasília
            .format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));//formato de data e hora
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
    public String getDataEmissao(){
        return dataEmissao;
    }
    public void exibirDetalhes(){
        System.out.println("-----------------------------------");

        System.out.println("Evento: " + experiencia.getTitulo());
        System.out.println("Descrição: " + experiencia.getDescricao());

        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Perfil do Cliente: " + cliente.getPerfil());

        System.out.println("Custo Base: R$" + experiencia.getPrecoBase());
        System.out.println("Valor Pago: R$" + valorFinalPago);
        
        System.out.println("Status: " + status);
        System.out.println("Prioridade: " + (prioridade ? "Sim" : "Não"));

        System.out.println("Data e Hora do Evento: " + experiencia.getDataHora());
        System.out.println("Data de Emissão: " + this.getDataEmissao());

        System.out.println("-----------------------------------");

    }
}
