public class DevedorServico {
    private Devedor[] devedores;
    private int quantidade;

    public DevedorServico() {
        devedores = new Devedor[100];
        quantidade = 0;
    }

    public void adicionarDevedor(Locatario locatario, double debito) {
        if (quantidade < devedores.length) {
            devedores[quantidade] = new Devedor(locatario, debito);
            quantidade++;
        } else {
            System.out.println("Limite de devedores atingido!");
        }
    }

    public void excluirDevedor(Locatario locatario) {
        for (int i = 0; i < quantidade; i++) {
            if (devedores[i].getLocatario().getCpf().equals(locatario.getCpf())) {
                for (int j = i; j < quantidade - 1; j++) {
                    devedores[j] = devedores[j + 1];
                }
                devedores[quantidade - 1] = null;
                quantidade--;
                System.out.println("Devedor removido com sucesso.");
                return;
            }
        }
        System.out.println("Devedor não encontrado.");
    }

    public void listarDevedores() {
        System.out.println("Lista de Devedores:");
        for (int i = 0; i < quantidade; i++) {
            devedores[i].mostraDados();
            System.out.println("--------------------");
        }
    }

    public Devedor buscarDevedorPorCpf(String cpf) {
        for (int i = 0; i < quantidade; i++) {
            if (devedores[i].getLocatario().getCpf().equals(cpf)) {
                return devedores[i];
            }
        }
        return null;
    }
}