package preditores;

/**
 * Classe criada para simular um preditor de dois bits. Esta classe é derivada do tipo Preditor,
 * logo, possui todos os atributos e métodos de sua classe superior.
 * 
 * @author Thales
 * @version 02/12/2015
 */
public class PreditorDeDoisBits extends Preditor{
	private int contadorDeErros;
	
	/**
	 * Construtor padrão de objetos da classe PreditorDeDoisBits.
	 * Inicializa o preditor com a predição inicial de que o salto será tomado.
	 * 
	 * @return Um novo objeto PreditorDeDoisBits
	 */
	public PreditorDeDoisBits() {
		super();
		this.contadorDeErros = 0;
		this.nomeDoPreditor = "Preditor de dois bit";
	}
	
	/**
	 * Executa o algoritimo de predição de dois bits. Os resultados são a taxa de acertos
	 * e as previsões feitas pelo preditor.
	 */
	@Override
	void predizer(String listaDeSaltos) {
		for(int i = 0; i < listaDeSaltos.length(); i++){
			this.predicoesFeitas += this.proximaPredicao;
			char atual = listaDeSaltos.charAt(i);
			
			
			switch(this.contadorDeErros){
			case 0:
				if(atual != this.proximaPredicao)
					this.contadorDeErros++;
				else
					this.predicoesCorretas++;
				break;
			//########################################
			case 1:
				if(atual != this.proximaPredicao){
					this.contadorDeErros++;
				}
				else{
					this.contadorDeErros--;
					this.predicoesCorretas++;
				}
				break;
			//########################################
			case 2:
				if(atual != this.proximaPredicao){
					this.contadorDeErros--;
				}
				else{
					this.contadorDeErros++;
					this.predicoesCorretas++;
				}
				break;
			//########################################
			case 3:
				if(atual != this.proximaPredicao)
					this.contadorDeErros--;
				else
					this.predicoesCorretas++;
				break;
			}
			
			if(this.contadorDeErros < 2)
				this.setProximaPredicao('T');
			else
				this.setProximaPredicao('N');
		}
		
	}

}
