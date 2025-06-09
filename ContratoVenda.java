public class ContratoVenda extends Contrato {
    private Pessoa comprador;
    private Corretor corretor;
    private double percentualImobiliaria;
    private double percentualCorretor;

    public ContratoVenda(Imovel imovel, String dataInicio, double valorPrincipal,
                        Pessoa comprador, Corretor corretor,
                        double percentualImobiliaria, double percentualCorretor) {
        super(imovel, dataInicio, valorPrincipal);
        this.comprador = comprador;
        this.corretor = corretor;
        this.percentualImobiliaria = percentualImobiliaria;
        this.percentualCorretor = percentualCorretor;
    }

    public Pessoa getComprador() {
        return comprador;
    }

    public void setComprador(Pessoa comprador) {
        this.comprador = comprador;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public double getPercentualImobiliaria() {
        return percentualImobiliaria;
    }

    public void setPercentualImobiliaria(double percentualImobiliaria) {
        this.percentualImobiliaria = percentualImobiliaria;
    }

    public double getPercentualCorretor() {
        return percentualCorretor;
    }

    public void setPercentualCorretor(double percentualCorretor) {
        this.percentualCorretor = percentualCorretor;
    }

    @Override
    public void processarMensalidade() {
        double comissaoCorretor = valorPrincipal * (percentualCorretor / 100);
        double comissaoImobiliaria = valorPrincipal * (percentualImobiliaria / 100);
        double valorLiquido = valorPrincipal - comissaoCorretor - comissaoImobiliaria;

        System.out.printf("Comissão Corretor (%.2f%%): R$%.2f\n", percentualCorretor, comissaoCorretor);
        System.out.printf("Comissão Imobiliária (%.2f%%): R$%.2f\n", percentualImobiliaria, comissaoImobiliaria);
        System.out.printf("Valor líquido da venda: R$%.2f\n", valorLiquido);

        if (corretor != null) {
            corretor.adicionarComissao(comissaoCorretor);
        }

        System.out.println("Distribuição entre proprietários:");
        for (ParticipacaoProprietario pp : imovel.getParticipacoes()) {
            if (pp != null) {
                double valorRepasse = valorLiquido * (pp.getPercentual() / 100);
                System.out.printf("- Proprietário: %s | Percentual: %.2f%% | Valor: R$%.2f\n",
                        pp.getProprietario().getNome(),
                        pp.getPercentual(),
                        valorRepasse
                );
            }
        }
    }

    @Override
    public void mostraDados() {
        super.mostraDados();
        System.out.println("Comprador: " + (comprador != null ? comprador.getNome() : "Nenhum"));
        System.out.println("Corretor: " + (corretor != null ? corretor.getNome() : "Nenhum"));
        System.out.println("Percentual Corretor: " + percentualCorretor + "%");
        System.out.println("Percentual Imobiliária: " + percentualImobiliaria + "%");
    }
}