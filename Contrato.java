public abstract class Contrato {
    protected Imovel imovel;
    protected String dataInicio;
    protected double valorPrincipal;

    public Contrato(Imovel imovel, String dataInicio, double valorPrincipal) {
        this.imovel = imovel;
        this.dataInicio = dataInicio;
        this.valorPrincipal = valorPrincipal;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public double getValorPrincipal() {
        return valorPrincipal;
    }

    public void setValorPrincipal(double valorPrincipal) {
        this.valorPrincipal = valorPrincipal;
    }

    public void mostraDados() {
        System.out.println("Data de Início: " + dataInicio);
        System.out.println("Valor Principal: R$" + valorPrincipal);
        if (imovel != null) {
            System.out.println("Informações do Imóvel:");
            imovel.mostraDados();
        }
    }

    public abstract void processarMensalidade();
}