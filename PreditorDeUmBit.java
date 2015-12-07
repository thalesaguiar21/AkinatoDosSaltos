package preditores;

/**
 * Esta classe simula um preditor de um bit, ou seja, sempre que a predi��o feita est� errada, ele 
 * troca a sua pr�xima predi��o. Caso contr�rio a previs�o permanece a mesma.
 * @author Thales
 * @version 02/12/2015
 */
public class PreditorDeUmBit extends Preditor {
	
	/**
	 * Construtor padr�o para objetos da classe PreditorDeUmBit.
	 */
	public PreditorDeUmBit(){
		super();
		this.nomeDoPreditor = "Preditor de um bit";
	}
	
	/**
	 * Sobrecarrega o m�todo setProximaPredicao() da classe m�e, tornando a troca de predi��es mais
	 * simples para este algoritmo. Caso a predi��o atual n�o seja 'N' ou 'T', uma mensagem de erro ser�
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
			System.out.println("N�o � uma predi��o v�lida.");
		}
	}
	
	/**
	 * Executa o algoritmo de predi��o para o preditor de um bit.
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
