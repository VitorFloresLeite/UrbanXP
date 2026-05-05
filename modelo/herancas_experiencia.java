class Show extends Experiencia {
    private String artistaPrincipal;

    public Show(String nome, String artistaPrincipal) {
        super(nome);
        this.artistaPrincipal = artistaPrincipal;
    }

    public String getArtistaPrincipal() { return artistaPrincipal; }
}

class Workshop extends Experiencia {
    private String materiais;

    public Workshop(String nome, String materiais) {
        super(nome);
        this.materiais = materiais;
    }

    public String getMateriais() { return materiais; }
}