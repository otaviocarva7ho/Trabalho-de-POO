public class Locatario extends Pessoa{
    private String profissao;

    

    public Locatario(String nome, String cpf, String endereco, String profissao) {
        super(nome, cpf, endereco);
        this.profissao = profissao;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void mostraDados(){
        super.mostraDados();
        System.out.println("Profissão: " + profissao);
    }
}