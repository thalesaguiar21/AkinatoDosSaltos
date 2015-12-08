package preditores;

import java.util.HashMap;
import java.util.Map;

/**
 * Esta classe simula um preditor adaptativo de dois níveis. Ele consiste em atualizar a tabela de histórico de saltos
 * do preditor sempre que ocorerr um erro após o segundo salto.
 * 
 * @author Thales
 * @version 02/12/2015
 */
public class PreditorAdaptativoDeDoisNiveis extends Preditor {

	private Map<String, Character> tabelaDePredicoes;
	
	/**
	 * Cria um novo objeto do tipo <i>PreditorAdaptativoDeDoisNiveis</i>, no qual sua tabela de histórico
	 * é inicializada supondo que os desvios serão sempre tomados.
	 */
	public PreditorAdaptativoDeDoisNiveis() {
		super();
		this.tabelaDePredicoes = new HashMap<String, Character>(4);
		this.tabelaDePredicoes.put("TT", new Character('T'));
		this.tabelaDePredicoes.put("TN", new Character('T'));
		this.tabelaDePredicoes.put("NT", new Character('T'));
		this.tabelaDePredicoes.put("NN", new Character('T'));
		this.nomeDoPreditor = "Preditor adaptativo de dois nï¿½veis";
	}
	
	/**
	 * Sobrecarrega o método da classe mãe, fazendo com que a tabela de histórico de saltos
	 * também seja resetada, ou seja, ela volta a supor que todos os desvios serão tomados.
	 */
	@Override
	protected void reset(){
		super.reset();
		this.tabelaDePredicoes.put("TT", new Character('T'));
		this.tabelaDePredicoes.put("TN", new Character('T'));
		this.tabelaDePredicoes.put("NT", new Character('T'));
		this.tabelaDePredicoes.put("NN", new Character('T'));
	}
	
	/**
	 * Executa o algoritmo de predições para o preditor adaptativo de dois níveis.
	 */
	@Override
	void predizer(String listaDeSaltos) {
		int counter = 0;
		int start = 0;
		while(counter < listaDeSaltos.length()){
			if(counter < 2){
				this.predicoesFeitas += this.tabelaDePredicoes.get("TT");
				if(this.tabelaDePredicoes.get("TT") == listaDeSaltos.charAt(counter))
					this.predicoesCorretas++;
			}
			else{
				this.predicoesFeitas += this.tabelaDePredicoes.get(listaDeSaltos.substring(start, counter));
				if(this.tabelaDePredicoes.get(listaDeSaltos.substring(start, counter)) == listaDeSaltos.charAt(counter))
						this.predicoesCorretas++;
				else
					this.tabelaDePredicoes.put(listaDeSaltos.substring(start, counter), listaDeSaltos.charAt(counter));
				start++;
			}
			counter++;
		}
	}

}
