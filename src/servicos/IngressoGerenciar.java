package servicos;
import java.util.ArrayList;
import modelo.*;

public class IngressoGerenciar {
    private ArrayList<Ingresso> listaIngressos;

    public IngressoGerenciar() {
        this.listaIngressos = new ArrayList<>();
    }

    public void cadastrar(Ingresso ingresso) {
        this.listaIngressos.add(ingresso);
    }

    public ArrayList<Ingresso> listarTodos() {
        return listaIngressos;
    }

    public Ingresso buscarPorCliente(Cliente cliente) {
        for (Ingresso ingresso : listaIngressos) {
            if (ingresso.getCliente().equals(cliente)) {
                return ingresso;
            }
        }
        return null; // Retorna null se o ingresso não for encontrado
    }
    public Ingresso buscarPorExperiencia(Experiencia experiencia) {
        for (Ingresso ingresso : listaIngressos) {
            if (ingresso.getExperiencia().equals(experiencia)) {
                return ingresso;
            }
        }
        return null; // Retorna null se o ingresso não for encontrado
    }
}
