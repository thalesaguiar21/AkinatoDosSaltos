package font;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Principal {
	
	private List<Preditor> listaDePreditores;
	private List<String> listaDeSaltos;
	private String resultadoFinal;
	
	
	public Principal(){
		this.resultadoFinal = "";
		this.listaDePreditores = new ArrayList<Preditor>();
		this.adicionarPredicoes();
	}
	
	private void adicionarPredicoes(){
		int counter = 1;
		while(counter <= 4){
			this.listaDePreditores.add(FabricaDePreditores.criarPreditor(counter));
			counter++;
		}
	}
	
	private void adicionarSaltos(String caminhoDoArquivo) throws FileNotFoundException{
		Reader.read(caminhoDoArquivo);
		this.listaDeSaltos = Reader.resultadoDaLeitura;		
	}
	
	private void gerarResultados(String saltosFeitos, Preditor preditor){
		this.resultadoFinal +=  "Tipo de preditor: \t" + preditor.getNome() + "\n";
		this.resultadoFinal +=  "Predições feitas: \t" + preditor.getPredicoesFeitas() + "\n";
		this.resultadoFinal +=  "Taxa de acertos: \t" + preditor.getProcentagemDeAcertos() + "\n";
		this.resultadoFinal +=  "-----------------------------------------------------------------\n";
	}
	
	private void melhorPreditor(String nomePreditor){
		this.resultadoFinal += "\n";
		this.resultadoFinal += "O melhor resultado é do algoritmo: " + nomePreditor + "\n\n";
		this.resultadoFinal += "                                -FIM-                               \n\n";
	}
	
	public void excutarPredicoes(String caminhoDoArquivo) throws FileNotFoundException{
		String melhorAlgoritmo = "";
		double maiorTaxaDeAcertos = 0;
		this.adicionarSaltos(caminhoDoArquivo);
		for(String saltos : this.listaDeSaltos){
			this.resultadoFinal +=  "Saltos realizados pelo programa: \t" + saltos + "\n";
			for(Preditor preditor : this.listaDePreditores){
				preditor.predizer(saltos);
				this.gerarResultados(saltos, preditor);
				if(preditor.getProcentagemDeAcertos() > maiorTaxaDeAcertos)
					melhorAlgoritmo = preditor.getNome();
				preditor.reset();
			}
			this.melhorPreditor(melhorAlgoritmo);
		}
		//System.out.println(this.resultadoFinal);
	}
	
	public String getResultadoFinal(){
		return this.resultadoFinal;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Principal p = new Principal();
		try {
			System.out.println("Execuantando...");
			p.excutarPredicoes("C:\\Users\\Thales\\Documents\\teste.txt");
			Reader.saveFile("C:\\Users\\Thales\\Documents\\RESULTADO.txt", p.getResultadoFinal());
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao abrir o arquivo.");
		}
		System.out.println("Finalizado!");
	}

}
