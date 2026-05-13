package servicos;

public class DescontoPremium implements PoliticaDesconto {
    @Override
    public double calcularValor(double precoBase) {
        return precoBase - 50; //Desconto fixo de R$50 para clientes premium
    }

}
