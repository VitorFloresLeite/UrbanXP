package servicos;

import modelo.Experiencia;
import java.util.ArrayList;
import java.util.List;

public class EventoGerenciar {
    private List<Experiencia> listaEventos;

    public EventoGerenciar() {
        this.listaEventos = new ArrayList<>();
    }

    public void cadastrar(Experiencia evento) {
        this.listaEventos.add(evento);
    }

    public List<Experiencia> listarTodos() {
        return listaEventos;
    }
}
