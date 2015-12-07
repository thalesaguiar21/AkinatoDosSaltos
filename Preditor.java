package preditores;

/**
 * Classe de maior hierarquia dos preditores. Todos os outros preditores derivam desta.
 * Possui m�todos para exucu��o de predi��es, retorno de mensagens com resultados e reinicializa��o de um preditor.
 * @author Thales
 * @version 02/12/2015
 *
 */
public abstract class Preditor {
	protected char proximaPredicao;
	protected int predicoesCorretas;
	protected String predicoesFeitas;
	protected String nomeDoPreditor;
	
	/**
	 * Construtor padr�o de objetos do tipo Preditor, note que a classe � abstrata, logo n�o
	 * � poss�vel criar inst�ncias diretas dessa classe.
	 */
	public Preditor(){
		this.proximaPredicao = 'T';
		this.predicoesCorretas = 0;
		this.predicoesFeitas = "";
	}
	
	/**
	 * Reinicia os resultados dos preditores, como: predi��es corretas e predi��es feitas.
	 * <strong>Importante</strong>: todos os preditores devem executar esse m�todo antes de uma nova execu��o
	 * de predi��es e depois de extrair os resultados da predi��o atual.
	 */
	protected void reset(){
		this.predicoesFeitas = "";
		this.predicoesCorretas = 0;
	}
	
	/**
	 * Calcula a taxa de predi��es corretas da �ltima execu��o.
	 * 
	 * @return Porcentagem de acertos do algoritimo.
	 */
	protected double getProcentagemDeAcertos(){
		return (double)(this.predicoesCorretas)/(this.predicoesFeitas.length());
	}
	
	/**
	 * Exibe os resultados, no terminal, da �ltima execu��o. 
	 */
	protected void exibirResultados(){
		System.out.println(this.nomeDoPreditor);
		System.out.println("Predi��es feitas:\t" + this.predicoesFeitas);
		System.out.println("Porcentagem de acertos:\t" + this.getProcentagemDeAcertos());
	}
	
	/**
	 * Executa o algoritmo para predi��o de salto, todos os preditores possuem
	 * este m�todo.
	 * @param listaDeSaltos Uma String pertencente � {TN}*
	 */
	abstract void predizer(String listaDeSaltos);
	
	
	//Getters and Setters
	/**
	 * @return A pr�xima predi��o do algorittmo.
	 */
	public char getProximaPredicao() {
		return proximaPredicao;
	}

	/**
	 * Altera o valor da pr�xima predi��o que ser� realizada pelo preditor.
	 * Caso seja passado algum par�metro diferente de 'N' ou 'T' ser� lan�ada uma exce��o.
	 * @param proximaPredicao Um char que � igual a 'N' ou 'T'
	 * @throws IllegalArgumentException Caso a entrada seja diferente de 'T' ou 'N'.
	 */
	public void setProximaPredicao(char proximaPredicao) throws IllegalArgumentException{
		if(proximaPredicao == 'T' || proximaPredicao == 'N')
			this.proximaPredicao = proximaPredicao;
		else
			throw new IllegalArgumentException();
	}

	/**
	 * @return A quantidade de predi��es corretas feitas pelo algoritimo.
	 */
	public int getPredicoesCorretas() {
		return predicoesCorretas;
	}

	/**
	 * Altera o numero de predi��es corretas feita pelo preditor.
	 * Caso seja passado um par�metro negativo, ser� lan�ada uma exce��o.
	 * @param predicoesCorretas
	 * @throws IllegalArgumentException Caso o argumento passado seja negativo.
	 */
	public void setPredicoesCorretas(int predicoesCorretas) throws IllegalArgumentException{
		if(predicoesCorretas >= 0)
			this.predicoesCorretas = predicoesCorretas;
		else
			throw new IllegalArgumentException();
	}

	/**
	 * Retorna uma string contendo as predi��es feitas pelo preditor.
	 * @return Uma string pertencente a {TN}*.
	 */
	public String getPredicoesFeitas() {
		return predicoesFeitas;
	}

	/**
	 * Altera a string de predi��es feitas pelo preditor.
	 * @param precicoesFeitas String pertencente a {TN}*.
	 */
	public void setPredicoesFeitas(String precicoesFeitas) {
		this.predicoesFeitas = precicoesFeitas;
	}
	
	/**
	 * Retorna o nome do preditor.
	 * @return nome do preditor.
	 */
	public String getNome(){
		return this.nomeDoPreditor;
	}
	
	
}
