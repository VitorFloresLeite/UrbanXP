public class ExperienciaExtra {
    private String brinde;
    private int idadeMinima;

    private ExperienciaExtra(Builder builder){
        this.brinde = builder.brinde;
        this.idadeMinima = builder.idadeMinima;
    }

    public static class Builder {
        private String brinde;
        private int idadeMinima;

        public Builder comBrinde(String brinde){
            this.brinde = brinde;
            return this;
        }

        public ExperienciaExtra build(){
            return new ExperienciaExtra(this);
        }
    }
}
