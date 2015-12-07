package preditores;

/**
 * Esta classe simula um preditor de um bit, ou seja, sempre que a predição feita está errada, ele 
 * troca a sua próxima predição. Caso contrário a previsão permanece a mesma.
 * @author Thales
 * @version 02/12/2015
 */
public class PreditorDeUmBit extends Preditor {
	
	/**
	 * Construtor padrão para objetos da classe PreditorDeUmBit.
	 */
	public PreditorDeUmBit(){
		super();
		this.nomeDoPreditor = "Preditor de um bit";
	}
	
	/**
	 * Sobrecarrega o método setProximaPredicao() da classe mãe, tornando a troca de predições mais
	 * simples para este algoritmo. Caso a predição atual não seja 'N' ou 'T', uma mensagem de erro será
	 * exibida.
	 */
	public void setProximaPredicao() {
		if(this.proximaPredicao == 'T'){
			this.proximaPredicao = 'N';
		}
		else if(this.proximaPredicao == 'N'){
			this.proximaPredicao = 'T';
		}
		else{
			System.out.println("Nï¿½o ï¿½ uma prediï¿½ï¿½o vï¿½lida.");
		}
	}
	
	/**
	 * Executa o algoritmo de predição para o preditor de um bit.
	 */
	@Override
	void predizer(String listaDeSaltos) {
		for(int i = 0; i < listaDeSaltos.length(); i++){
			this.predicoesFeitas += this.proximaPredicao;
			char atual = listaDeSaltos.charAt(i);
			if(atual == this.proximaPredicao){
				this.predicoesCorretas++;
			}
			else{
				this.setProximaPredicao();
			}
		}
	}

}
