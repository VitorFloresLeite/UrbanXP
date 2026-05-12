package modelo;
public class Cliente extends Pessoa{
    private double saldo;
    private ClientePerfil perfil;

    public Cliente(String nome, double saldo, ClientePerfil perfil){
        this.nome=nome;
        this.saldo=saldo;
        this.perfil=perfil;
    }
    public void setSaldo(double saldo){
        this.saldo=saldo;
    }
    public double getSaldo(){
        return this.saldo;
    }
    public ClientePerfil getPerfil(){
        return this.perfil;
    }
}