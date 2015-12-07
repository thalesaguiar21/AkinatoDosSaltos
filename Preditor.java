package preditores;

/**
 * Classe de maior hierarquia dos preditores. Todos os outros preditores derivam desta.
 * Possui métodos para exucução de predições, retorno de mensagens com resultados e reinicialização de um preditor.
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
	 * Construtor padrão de objetos do tipo Preditor, note que a classe é abstrata, logo não
	 * é possível criar instâncias diretas dessa classe.
	 */
	public Preditor(){
		this.proximaPredicao = 'T';
		this.predicoesCorretas = 0;
		this.predicoesFeitas = "";
	}
	
	/**
	 * Reinicia os resultados dos preditores, como: predições corretas e predições feitas.
	 * <strong>Importante</strong>: todos os preditores devem executar esse método antes de uma nova execução
	 * de predições e depois de extrair os resultados da predição atual.
	 */
	protected void reset(){
		this.predicoesFeitas = "";
		this.predicoesCorretas = 0;
	}
	
	/**
	 * Calcula a taxa de predições corretas da última execução.
	 * 
	 * @return Porcentagem de acertos do algoritimo.
	 */
	protected double getProcentagemDeAcertos(){
		return (double)(this.predicoesCorretas)/(this.predicoesFeitas.length());
	}
	
	/**
	 * Exibe os resultados, no terminal, da última execução. 
	 */
	protected void exibirResultados(){
		System.out.println(this.nomeDoPreditor);
		System.out.println("Prediï¿½ï¿½es feitas:\t" + this.predicoesFeitas);
		System.out.println("Porcentagem de acertos:\t" + this.getProcentagemDeAcertos());
	}
	
	/**
	 * Executa o algoritmo para predição de salto, todos os preditores possuem
	 * este método.
	 * @param listaDeSaltos Uma String pertencente à {TN}*
	 */
	abstract void predizer(String listaDeSaltos);
	
	
	//Getters and Setters
	/**
	 * @return A próxima predição do algorittmo.
	 */
	public char getProximaPredicao() {
		return proximaPredicao;
	}

	/**
	 * Altera o valor da próxima predição que será realizada pelo preditor.
	 * Caso seja passado algum parâmetro diferente de 'N' ou 'T' será lançada uma exceção.
	 * @param proximaPredicao Um char que é igual a 'N' ou 'T'
	 * @throws IllegalArgumentException Caso a entrada seja diferente de 'T' ou 'N'.
	 */
	public void setProximaPredicao(char proximaPredicao) throws IllegalArgumentException{
		if(proximaPredicao == 'T' || proximaPredicao == 'N')
			this.proximaPredicao = proximaPredicao;
		else
			throw new IllegalArgumentException();
	}

	/**
	 * @return A quantidade de predições corretas feitas pelo algoritimo.
	 */
	public int getPredicoesCorretas() {
		return predicoesCorretas;
	}

	/**
	 * Altera o numero de predições corretas feita pelo preditor.
	 * Caso seja passado um parâmetro negativo, será lançada uma exceção.
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
	 * Retorna uma string contendo as predições feitas pelo preditor.
	 * @return Uma string pertencente a {TN}*.
	 */
	public String getPredicoesFeitas() {
		return predicoesFeitas;
	}

	/**
	 * Altera a string de predições feitas pelo preditor.
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
