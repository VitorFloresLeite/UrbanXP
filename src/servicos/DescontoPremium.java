package servicos;

public class DescontoPremium implements PoliticaDesconto {
    @Override
    public double calcularValor(double precoBase) {
        double resultado = precoBase - 50;
        if (resultado < 0) resultado = 0;
        return resultado - 50; //Desconto fixo de R$50 para clientes premium
    }

}
