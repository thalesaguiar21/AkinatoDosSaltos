package preditores;

import java.util.HashMap;
import java.util.Map;

/**
 * Esta classe simula um preditor adaptativo de dois n�veis. Ele consiste em atualizar a tabela de hist�rico de saltos
 * do preditor sempre que ocorerr um erro ap�s o segundo salto.
 * 
 * @author Thales
 * @version 02/12/2015
 */
public class PreditorAdaptativoDeDoisNiveis extends Preditor {

	private Map<String, Character> tabelaDePredicoes;
	
	/**
	 * Cria um novo objeto do tipo <i>PreditorAdaptativoDeDoisNiveis</i>, no qual sua tabela de hist�rico
	 * � inicializada supondo que os desvios ser�o sempre tomados.
	 */
	public PreditorAdaptativoDeDoisNiveis() {
		super();
		this.tabelaDePredicoes = new HashMap<String, Character>(4);
		this.tabelaDePredicoes.put("TT", new Character('T'));
		this.tabelaDePredicoes.put("TN", new Character('T'));
		this.tabelaDePredicoes.put("NT", new Character('T'));
		this.tabelaDePredicoes.put("NN", new Character('T'));
		this.nomeDoPreditor = "Preditor adaptativo de dois n�veis";
	}
	
	/**
	 * Sobrecarrega o m�todo da classe m�e, fazendo com que a tabela de hist�rico de saltos
	 * tamb�m seja resetada, ou seja, ela volta a supor que todos os desvios ser�o tomados.
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
	 * Executa o algoritmo de predi��es para o preditor adaptativo de dois n�veis.
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
