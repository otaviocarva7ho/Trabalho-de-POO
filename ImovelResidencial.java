public class ImovelResidencial extends Imovel {

    public ImovelResidencial(int idImovel, String endereco, double valorBaseLocacao, double valorBaseVenda, double iptu) {
        super(idImovel, endereco, valorBaseLocacao, valorBaseVenda, iptu);
    }

    @Override
    public double calcularTaxaAdministracao(){
        return getValorBaseLocacao() * 0.05;
    }

    @Override
    public void mostraDados(){
        super.mostraDados();
        System.out.println("Taxa de Administração: R$ " + calcularTaxaAdministracao());
    }
}