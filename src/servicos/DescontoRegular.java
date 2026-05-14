package servicos;

public class DescontoRegular implements PoliticaDesconto {
    @Override
    public double calcularValor(double precoBase) {
        return precoBase; //Não há desconto
    }
    
}
