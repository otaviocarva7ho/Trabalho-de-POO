public class Imobiliaria {
    private String nome;
    private Pessoa[] pessoas;
    private Imovel[] imoveis;
    private Contrato[] contratos;
    private int qtdPessoas;
    private int qtdImoveis;
    private int qtdContratos;

    public Imobiliaria(String nome) {
        this.nome = nome;
        this.pessoas = new Pessoa[100];
        this.imoveis = new Imovel[100];
        this.contratos = new Contrato[100];
        this.qtdPessoas = 0;
        this.qtdImoveis = 0;
        this.qtdContratos = 0;
    }

    public void adicionarPessoa(Pessoa p) {
        if (qtdPessoas < pessoas.length) {
            pessoas[qtdPessoas++] = p;
        }
    }

    public void adicionarImovel(Imovel i) {
        if (qtdImoveis < imoveis.length) {
            imoveis[qtdImoveis++] = i;
        }
    }

    public void adicionarContrato(Contrato c) {
        if (qtdContratos < contratos.length) {
            contratos[qtdContratos++] = c;
        }
    }

    public void removerPessoa(String cpf) {
        for (int i = 0; i < qtdPessoas; i++) {
            if (pessoas[i].getCpf().equals(cpf)) {
                for (int j = i; j < qtdPessoas - 1; j++) {
                    pessoas[j] = pessoas[j + 1];
                }
                pessoas[--qtdPessoas] = null;
                break;
            }
        }
    }

    public void removerImovel(int idImovel) {
        for (int i = 0; i < qtdImoveis; i++) {
            if (imoveis[i].getIdImovel() == idImovel) {
                for (int j = i; j < qtdImoveis - 1; j++) {
                    imoveis[j] = imoveis[j + 1];
                }
                imoveis[--qtdImoveis] = null;
                break;
            }
        }
    }

    public void removerContrato(int idImovel) {
        for (int i = 0; i < qtdContratos; i++) {
            if (contratos[i].getImovel().getIdImovel() == idImovel) {
                for (int j = i; j < qtdContratos - 1; j++) {
                    contratos[j] = contratos[j + 1];
                }
                contratos[--qtdContratos] = null;
                break;
            }
        }
    }

    public Pessoa buscarPessoaPorCpf(String cpf) {
        for (int i = 0; i < qtdPessoas; i++) {
            if (pessoas[i].getCpf().equals(cpf)) {
                return pessoas[i];
            }
        }
        return null;
    }

    public Imovel buscarImovelPorId(int idImovel) {
        for (int i = 0; i < qtdImoveis; i++) {
            if (imoveis[i].getIdImovel() == idImovel) {
                return imoveis[i];
            }
        }
        return null;
    }

    public Contrato buscarContratoPorImovelId(int idImovel) {
        for (int i = 0; i < qtdContratos; i++) {
            if (contratos[i].getImovel().getIdImovel() == idImovel) {
                return contratos[i];
            }
        }
        return null;
    }

    public void listarPessoas() {
        for (int i = 0; i < qtdPessoas; i++) {
            pessoas[i].mostraDados();
            System.out.println("----------");
        }
    }

    public void listarImoveis() {
        for (int i = 0; i < qtdImoveis; i++) {
            imoveis[i].mostraDados();
            System.out.println("----------");
        }
    }

    public void listarContratos() {
        for (int i = 0; i < qtdContratos; i++) {
            contratos[i].mostraDados();
            System.out.println("----------");
        }
    }

    public void processarMensalidades() {
        for (int i = 0; i < qtdContratos; i++) {
            contratos[i].processarMensalidade();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}