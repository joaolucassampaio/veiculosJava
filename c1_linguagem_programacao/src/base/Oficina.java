package base;
import io.InOut;

public class Oficina {
    private static VetVeiculo arrVeiculo = new VetVeiculo();

    public static void main(String[] args) {    	
        String opcao = "";

        do {
            opcao = exibirMenu();
            switch(opcao) {
                case "1":
                    adicionarVeiculo();
                    break;

                case "2":
                    pesquisarVeiculo();
                    break;

                case "3":
                    removerVeiculo();
                    break;

                case "4":
                    listarVeiculos();
                    break;
                    
                case "5":
                    System.exit(0);
                    break;

                default:
                    InOut.msgDeInformacao("", "Opção inválida!");
            }
        } while(!opcao.equals("5"));
    }

    private static String exibirMenu() {
        String opcao;
        opcao = InOut.leString("Bem-vindo(a) ao Sistema de Gestão de Veículos!\n\n"
            + "Como posso te ajudar hoje?\n"
            + "1- Adicionar Veiculo;\n"
            + "2- Pesquisar por Placa;\n"
            + "3- Remover por Placa;\n"
            + "4- Listar Todos os Veiculos;\n"
            + "5- Sair do Programa.\n\n"
            + "Digite a opção desejada:");
        return opcao;
    }

    private static void adicionarVeiculo() {
        String placa = InOut.leString("Por favor, digite o número da placa:");
        String modelo = InOut.leString("Digite o modelo do veículo:");
        String problema = InOut.leString("Digite o problema do veículo:");
        double valor = InOut.leDouble("Digite o valor estimado do conserto:");

        boolean inserido = arrVeiculo.inserirVeiculo(placa, modelo, problema, valor);
        
        if (inserido) {
            InOut.msgDeInformacao("", "Veículo adicionado com sucesso!");
        } else {
            InOut.msgDeInformacao("", "Veículo com placa " + placa + " já está cadastrado.");
        }
    }

    private static void pesquisarVeiculo() {
        String placa = InOut.leString("Digite a placa do veículo que deseja pesquisar:");
        int pos = arrVeiculo.pesquisaVeiculo(placa);
        
        if (pos != -1) {
            Veiculo veiculoEncontrado = arrVeiculo.getPos(pos);
            InOut.msgDeInformacao("", "Veículo encontrado: " + veiculoEncontrado);
        } else {
            InOut.msgDeInformacao("", "Veículo com placa " + placa + " não encontrado.");
        }
    }

    private static void removerVeiculo() {
        String placa = InOut.leString("Digite a placa do veículo que deseja remover:");
        boolean removido = arrVeiculo.removerVeiculo(placa);
        
        if (removido) {
            InOut.msgDeInformacao("", "Veículo removido com sucesso!");
        } else {
            InOut.msgDeInformacao("", "Veículo com placa " + placa + " não encontrado.");
        }
    }

    private static void listarVeiculos() {
        arrVeiculo.listarVeiculos();
    }  
}