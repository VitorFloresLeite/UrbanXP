package modelo;
public abstract class Pessoa{
    protected String nome; 
    
    public void SetNome(String nome){
        this.nome=nome;
    }
    public String GetNome(){
        return this.nome;
    }
}