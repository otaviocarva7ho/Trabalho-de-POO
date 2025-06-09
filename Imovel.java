public abstract class Imovel {
    private int idImovel;
    private String endereco;
    private double valorBaseLocacao;
    private double valorBaseVenda;
    private double iptu;
    private ParticipacaoProprietario[] participacoes = new ParticipacaoProprietario[10];

    public Imovel(int idImovel, String endereco, double valorBaseLocacao, double valorBaseVenda, double iptu) {
        this.idImovel = idImovel;
        this.endereco = endereco;
        this.valorBaseLocacao = valorBaseLocacao;
        this.valorBaseVenda = valorBaseVenda;
        this.iptu = iptu;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getValorBaseLocacao() {
        return valorBaseLocacao;
    }

    public void setValorBaseLocacao(double valorBaseLocacao) {
        this.valorBaseLocacao = valorBaseLocacao;
    }

    public double getValorBaseVenda() {
        return valorBaseVenda;
    }

    public void setValorBaseVenda(double valorBaseVenda) {
        this.valorBaseVenda = valorBaseVenda;
    }

    public double getIptu() {
        return iptu;
    }

    public void setIptu(double iptu) {
        this.iptu = iptu;
    }

    public ParticipacaoProprietario[] getParticipacoes() {
        return participacoes;
    }

    public void incluiParticipacaoProprietario(Proprietario prop, double percentual) {
        for (int i = 0; i < participacoes.length; i++) {
            if (participacoes[i] == null) {
                participacoes[i] = new ParticipacaoProprietario(prop, percentual);
                System.out.println("Participação incluída com sucesso.");
                return;
            }
        }
        System.out.println("Não há espaço para novas participações.");
    }

    public void excluiParticipacaoProprietario(Proprietario prop) {
        for (int i = 0; i < participacoes.length; i++) {
            if (participacoes[i] != null && participacoes[i].getProprietario().equals(prop)) {
                participacoes[i] = null;
                System.out.println("Participação removida com sucesso.");
                return;
            }
        }
        System.out.println("Proprietário não encontrado entre as participações.");
    }

    public void listarParticipacaoProprietario() {
        boolean vazio = true;
        for (ParticipacaoProprietario p : participacoes) {
            if (p != null) {
                p.mostraDados();
                System.out.println("-------------------------");
                vazio = false;
            }
        }
        if (vazio) {
            System.out.println("Nenhuma participação registrada.");
        }
    }

    public void mostraDados() {
        System.out.println("ID do Imóvel: " + idImovel);
        System.out.println("Endereço: " + endereco);
        System.out.println("Valor Base Locação: R$" + valorBaseLocacao);
        System.out.println("Valor Base Venda: R$" + valorBaseVenda);
        System.out.println("IPTU: R$" + iptu);
        System.out.println("Participações dos Proprietários:");
        listarParticipacaoProprietario();
    }

    public abstract double calcularTaxaAdministracao();
}