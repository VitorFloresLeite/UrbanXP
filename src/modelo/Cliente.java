package modelo;
public class Cliente{
    
    private String nome; 

    private ClientePerfil perfil;
    
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getNome(){
        return this.nome;
    }

    public ClientePerfil getPerfil(){
        return this.perfil;
    }

    public Cliente(String nome, double saldo, ClientePerfil perfil){
        this.nome=nome;
        this.perfil=perfil;
    }
}