package servicos;

import java.util.ArrayList;
import modelo.Experiencia;

public class EventoGerenciar {
    private ArrayList<Experiencia> listaEventos;

    public EventoGerenciar() {
        this.listaEventos = new ArrayList<>();
    }

    public void cadastrar(Experiencia evento) {
        this.listaEventos.add(evento);
    }
    public ArrayList<Experiencia> listarTodos() {
        return listaEventos;
    }
    public Experiencia buscarPorTitulo(String titulo) {
        for (Experiencia evento : listaEventos) {
            if (evento.getTitulo().trim().equalsIgnoreCase(titulo.trim())) {
                return evento;
            }
        }
        return null; // Retorna null se o evento não for encontrado
    }
}
