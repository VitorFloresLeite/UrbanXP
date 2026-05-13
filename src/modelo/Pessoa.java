package modelo;
public abstract class Pessoa{
    protected String nome; 
    
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getNome(){
        return this.nome;
    }
}