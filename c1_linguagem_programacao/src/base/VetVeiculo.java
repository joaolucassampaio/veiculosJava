package base;
import java.util.ArrayList;
import io.InOut;

public class VetVeiculo {
	//Um ArrayList de Veiculo
	static ArrayList<Veiculo> arrVeiculos = new ArrayList<>();
	
	//Um construtor vazio
	public VetVeiculo() {
		
	}
	
	//get da quantidade de Veiculos cadastrados
	public int getSize() {
		return arrVeiculos.size();
	}
	

	/*getPos (retorna um produto que está na posição que será passada como parâmetro. Se a posição for inválida, deve retornar null)*/
	public Veiculo getPos(int pos) {
		if(pos >= 0 && pos < arrVeiculos.size()) {
			return arrVeiculos.get(pos);
		} else {
			return null;
		}
	}
	
	 /* Pesquisa de um Veiculo pela placa (retorna a posição do produto no vetor ou retorna -1 se não encontrar). Observe que a placa é uma String.*/
	public int pesquisaVeiculo(String placa) {
		for(int i = 0; i < arrVeiculos.size(); i++) {
			if(arrVeiculos.get(i).getPlaca().equals(placa)) {
				return i;
			}
		}
		return -1;
	}
	
	/* Inserção de um Veiculo no vetor (será necessário verificar se o veiculo já existe. Se ele existir, deve retornar false. Se o Veiculo não existir, deve armazená-lo no array e retornar true). */
    public boolean inserirVeiculo(String placa, String modelo, String problema, double valorDoServico) {
        if (pesquisaVeiculo(placa) != -1) {
            return false;
        } else {
        	Veiculo novoVeiculo = new Veiculo(placa, modelo, problema, valorDoServico);
            
            arrVeiculos.add(novoVeiculo);
            
            return true;
        }
    }
    
	/*Remoção de um Veiculo no vetor (remove o Veiculo do vetor e retorna true. Se o Veiculo não existir no vetor, retorna false).*/
    public boolean removerVeiculo(String placa) {
        int pos = pesquisaVeiculo(placa);
        
        if (pos != -1) {
            arrVeiculos.remove(pos);
            return true;
        } else {
            return false;
        }
    }

    public void listarVeiculos() {
        if (arrVeiculos.isEmpty()) {
            InOut.msgSemIcone(null, "Nenhum veículo encontrado.");
        } else {
            StringBuilder veiculosCadastrados = new StringBuilder();
            
            for (Veiculo veiculo : arrVeiculos) {
                veiculosCadastrados.append("Placa: ")
                    .append(veiculo.getPlaca())
                    .append(", Modelo: ")
                    .append(veiculo.getModelo())
                    .append(", Problema: ")
                    .append(veiculo.getProblema())
                    .append(", Valor: R$ ")
                    .append(veiculo.getValorDoServico())
                    .append("\n");
            }
            
            InOut.msgSemIcone("Veículos cadastrados na oficina:", veiculosCadastrados.toString());
        }
    }
}
