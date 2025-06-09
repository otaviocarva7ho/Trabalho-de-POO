public class Corretor extends Pessoa{
    private double comissaoRecebida;

    public Corretor(String nome, String cpf, String endereco, double comissaoRecebida) {
        super(nome, cpf, endereco);
        this.comissaoRecebida = comissaoRecebida;
    }

    public double getComissaoRecebida() {
        return comissaoRecebida;
    }

    public void setComissaoRecebida(double comissaoRecebida) {
        this.comissaoRecebida = comissaoRecebida;
    }
}