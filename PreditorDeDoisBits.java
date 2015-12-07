package preditores;

/**
 * Classe criada para simular um preditor de dois bits. Esta classe � derivada do tipo Preditor,
 * logo, possui todos os atributos e m�todos de sua classe superior.
 * 
 * @author Thales
 * @version 02/12/2015
 */
public class PreditorDeDoisBits extends Preditor{
	private int contadorDeErros;
	
	/**
	 * Construtor padr�o de objetos da classe PreditorDeDoisBits.
	 * Inicializa o preditor com a predi��o inicial de que o salto ser� tomado.
	 * 
	 * @return Um novo objeto PreditorDeDoisBits
	 */
	public PreditorDeDoisBits() {
		super();
		this.contadorDeErros = 0;
		this.nomeDoPreditor = "Preditor de dois bit";
	}
	
	/**
	 * Executa o algoritimo de predi��o de dois bits. Os resultados s�o a taxa de acertos
	 * e as previs�es feitas pelo preditor.
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
