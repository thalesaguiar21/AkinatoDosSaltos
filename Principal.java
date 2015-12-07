package preditores;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe para execução de testes contendo todos os preditores envolvidos no projeto.
 * @author Thales
 * @version 02/12/2015
 */
public class Principal {
	
	private List<Preditor> listaDePreditores;
	private List<String> listaDeSaltos;
	private String resultadoFinal;
	
	
	/**
	 * Contrutor padrão para objetos da classe Principal.
	 * Inicializa um novo objeto com um preditor de cada tipo em um
	 * <a href = 'https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html'>ArrayList</a>.
	 */
	public Principal(){
		this.resultadoFinal = "";
		this.listaDePreditores = new ArrayList<Preditor>();
		this.adicionarPredicoes();
	}
	
	/**
	 * Adiciona os preditores a instância de Preditor.
	 */
	private void adicionarPredicoes(){
		int counter = 1;
		while(counter <= 4){
			this.listaDePreditores.add(FabricaDePreditores.criarPreditor(counter));
			counter++;
		}
	}
	
	/**
	 * Lê um arquivo no caminho especificado usando a classe <i>Reader</i>.
	 * @param caminhoDoArquivo URL do local do arquivo.
	 * @throws FileNotFoundException Caso o arquivo não seja encontrado ou não seja possível lê-lo.
	 */
	private void adicionarSaltos(String caminhoDoArquivo) throws FileNotFoundException{
		Reader.read(caminhoDoArquivo);
		this.listaDeSaltos = Reader.resultadoDaLeitura;		
	}
	
	/**
	 * Adiciona os resultado de um preditor à string de resultados finais.
	 * @param saltosFeitos Saltos que foram realizados pelo programa durante a execução do algoritmo do preditor.
	 * @param preditor Preditor que realizou a execução.
	 */
	private void gerarResultados(String saltosFeitos, Preditor preditor){
		this.resultadoFinal +=  "Tipo de preditor: \t" + preditor.getNome() + "\n";
		this.resultadoFinal +=  "Prediï¿½ï¿½es feitas: \t" + preditor.getPredicoesFeitas() + "\n";
		this.resultadoFinal +=  "Taxa de acertos: \t" + preditor.getProcentagemDeAcertos() + "\n";
		this.resultadoFinal +=  "-----------------------------------------------------------------\n";
	}
	
	/**
	 * Adiciona o nome do melhor preditor a string de resultados finais.
	 * @param nomePreditor Nome do melhor preditor.
	 */
	private void melhorPreditor(String nomePreditor){
		this.resultadoFinal += "\n";
		this.resultadoFinal += "O melhor resultado ï¿½ do algoritmo: " + nomePreditor + "\n\n";
		this.resultadoFinal += "                                -FIM-                               \n\n";
	}
	
	/**
	 * Lê os saltos contidos no arquivo presente no caminho especificado e executa, para cada linha(lista de saltos) do arquivo,
	 * todos os algoritimos de preditores contidos no objeto.
	 * @param caminhoDoArquivo URL do arquivo contendo os saltos para teste.
	 * @throws FileNotFoundException
	 */
	public void excutarPredicoes(String caminhoDoArquivo) throws FileNotFoundException{
		String melhorAlgoritmo = "";
		double maiorTaxaDeAcertos = 0;
		this.adicionarSaltos(caminhoDoArquivo);
		for(String saltos : this.listaDeSaltos){
                    //if(saltos != ""){
			this.resultadoFinal +=  "Saltos realizados pelo programa: \t" + saltos + "\n";
			for(Preditor preditor : this.listaDePreditores){
				preditor.predizer(saltos);
				this.gerarResultados(saltos, preditor);
				if(preditor.getProcentagemDeAcertos() > maiorTaxaDeAcertos){
                                    melhorAlgoritmo = preditor.getNome();
                                    maiorTaxaDeAcertos = preditor.getProcentagemDeAcertos();
                                }					
				preditor.reset();
			}
			this.melhorPreditor(melhorAlgoritmo);
                    //}
                    maiorTaxaDeAcertos = 0.0;
                    melhorAlgoritmo = "";
		}
		//System.out.println(this.resultadoFinal);
	}
	
	/**
	 * @return Retorna uma string contendo o resultado final da execução de cada salto para todos os preditores.
	 */
	public String getResultadoFinal(){
		return this.resultadoFinal;
	}

}
