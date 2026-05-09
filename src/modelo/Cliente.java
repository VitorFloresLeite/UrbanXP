public class Cliente extends Pessoa{
    protected double Saldo;

    public Cliente(String nome, double saldo){
        this.Nome=nome;
        this.Saldo=saldo;
    }
    public void SetSaldo(double saldo){
        this.Saldo=saldo;
    }
    public double GetSaldo(){
        return this.Saldo;
    }
}