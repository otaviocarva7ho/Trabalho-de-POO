public class ParticipacaoProprietario {
    private Proprietario proprietario;
    private double percentual;

    public ParticipacaoProprietario(Proprietario proprietario, double percentual) {
        this.proprietario = proprietario;
        this.percentual = percentual;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public double getPercentual() {
        return percentual;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }

    public void mostraDados(){
        System.out.println("Proprietário:");
        if(proprietario != null){
            proprietario.mostraDados();
        }else{
            System.out.println("Nenhum proprietário associado.");
        }
        System.out.println("Percentual de participação: " + percentual + "%");
    }
}