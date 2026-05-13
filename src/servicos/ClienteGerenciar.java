package servicos;
import java.util.ArrayList;
import modelo.Cliente;

public class ClienteGerenciar {
    private ArrayList<Cliente> listaClientes;
    
    public ClienteGerenciar(){
        this.listaClientes= new ArrayList<>();
    }
    public void cadastrar(Cliente cliente) {
        this.listaClientes.add(cliente);
    }
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
    public Cliente buscarPorNome(String nome) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNome().trim().equalsIgnoreCase(nome.trim())) {
                return cliente;
            }
        }
        return null; // Retorna null se o cliente não for encontrado
    }
}
