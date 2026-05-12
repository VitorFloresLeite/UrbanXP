package servicos;
import modelo.Cliente;
import java.util.ArrayList;
public class ClienteGerenciar {
    private ArrayList<Cliente> listaClientes;
    
    public ClienteGerenciar(){
        this.listaClientes= new ArrayList<>();
    }
    public void cadastrar(Cliente cliente) {
        this.listaClientes.add(cliente);
    }
}
