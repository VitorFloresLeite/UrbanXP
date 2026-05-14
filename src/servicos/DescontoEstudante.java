package servicos;

public class DescontoEstudante implements PoliticaDesconto {
    @Override
    public double calcularValor(double precoBase) {
        return precoBase * 0.75; //25% de desconto para estudantes
    }
    
}
