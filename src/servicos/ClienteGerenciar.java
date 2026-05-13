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
}
