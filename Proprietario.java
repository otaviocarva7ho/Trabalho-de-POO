public class Proprietario extends Pessoa {
    private Imovel[] imoveis = new Imovel[30];

    public Proprietario(String nome, String cpf, String endereco) {
        super(nome, cpf, endereco);
    }

    public void incluiImovel(Imovel imo){
        if (buscaImovel(imo.getIdImovel()) != null){
            System.out.println("Imóvel com o mesmo ID já cadastrado.");
            return;
        }

        for (int i = 0; i < imoveis.length; i++){
            if (imoveis[i] == null){
                imoveis[i] = imo;
                System.out.println("Imóvel incluído com sucesso.");
                return;
            }
        }
        System.out.println("Não há espaço para novos imóveis.");
    }

    public void excluiImovel(int id){
        for (int i = 0; i < imoveis.length; i++){
            if (imoveis[i] != null && imoveis[i].getIdImovel() == id){
                imoveis[i] = null;
                System.out.println("Imóvel excluído com sucesso.");
                return;
            }
        }
        System.out.println("Imóvel com ID especificado não encontrado.");
    }

    public void listarImoveis() {
        boolean vazio = true;
        for (Imovel imovel : imoveis) {
            if (imovel != null) {
                imovel.mostraDados();
                System.out.println("------------------------");
                vazio = false;
            }
        }
        if (vazio) {
            System.out.println("Nenhum imóvel cadastrado.");
        }
    }

    public Imovel buscaImovel(int id) {
        for (Imovel imovel : imoveis) {
            if (imovel != null && imovel.getIdImovel() == id) {
                return imovel;
            }
        }
        return null;
    }

    @Override
    public void mostraDados() {
        super.mostraDados();
        System.out.println("Lista de Imóveis:");
        listarImoveis();
    }
}