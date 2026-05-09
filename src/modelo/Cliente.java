public class Cliente extends Pessoa{
    protected double saldo;

    public Cliente(String nome, double saldo){
        this.nome=nome;
        this.saldo=saldo;
    }
    public void SetSaldo(double saldo){
        this.saldo=saldo;
    }
    public double GetSaldo(){
        return this.saldo;
    }
}