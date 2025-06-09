public class ContratoLocacao extends Contrato {
    private Locatario locatario;
    private boolean encerrado;
    private DevedorServico devserv;
    private double multaAtraso;
    private double multaRescisao;
    private boolean atraso;
    private boolean vistoriaAprovada;

    // Construtor
    public ContratoLocacao(Imovel imovel, String dataInicio, double valorPrincipal,
                        Locatario locatario, DevedorServico devserv,
                        double multaAtraso, double multaRescisao) {
        super(imovel, dataInicio, valorPrincipal);
        this.locatario = locatario;
        this.devserv = devserv;
        this.multaAtraso = multaAtraso;
        this.multaRescisao = multaRescisao;
        this.encerrado = false;
        this.atraso = false;
        this.vistoriaAprovada = false;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public boolean isEncerrado() {
        return encerrado;
    }

    public void setEncerrado(boolean encerrado) {
        this.encerrado = encerrado;
    }

    public DevedorServico getDevserv() {
        return devserv;
    }

    public void setDevserv(DevedorServico devserv) {
        this.devserv = devserv;
    }

    public double getMultaAtraso() {
        return multaAtraso;
    }

    public void setMultaAtraso(double multaAtraso) {
        this.multaAtraso = multaAtraso;
    }

    public double getMultaRescisao() {
        return multaRescisao;
    }

    public void setMultaRescisao(double multaRescisao) {
        this.multaRescisao = multaRescisao;
    }

    public boolean isAtraso() {
        return atraso;
    }

    public boolean isVistoriaAprovada() {
        return vistoriaAprovada;
    }

    public void registrarAtraso() {
        this.atraso = true;
        double valorComMulta = valorPrincipal + multaAtraso;
        devserv.adicionarDevedor(locatario, valorComMulta);
    }

    public void encerrarComVistoria(boolean vistoriaAprovada) {
        this.vistoriaAprovada = vistoriaAprovada;
        this.encerrado = true;

        if (vistoriaAprovada) {
            System.out.println("Vistoria aprovada. Contrato encerrado.");
        } else {
            System.out.println("Vistoria reprovada! Inquilino deve realizar os reparos.");
        }
    }

    @Override
    public void processarMensalidade() {
        if (encerrado) {
            System.out.println("Contrato encerrado. Mensalidade não será processada.");
            return;
        }

        double taxaAdm = imovel.calcularTaxaAdministracao();
        double aluguel = (valorPrincipal - taxaAdm) + imovel.getIptu();

        System.out.printf("Valor total do aluguel (com IPTU e taxa de administração): R$%.2f\n", aluguel);

        System.out.println("Distribuição entre proprietários:");
        for (ParticipacaoProprietario pp : imovel.getParticipacoes()) {
            if (pp != null) {
                double valorRepasse = aluguel * (pp.getPercentual() / 100);
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
        System.out.println("Locatário: " + (locatario != null ? locatario.getNome() : "Nenhum"));
        System.out.println("Encerrado: " + encerrado);
        System.out.println("Atraso: " + atraso);
        System.out.println("Multa por Atraso: R$" + multaAtraso);
        System.out.println("Multa por Rescisão: R$" + multaRescisao);
        System.out.println("Vistoria Aprovada: " + vistoriaAprovada);
    }
}