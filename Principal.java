package font;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Principal {
	
	private List<Preditor> listaDePreditores;
	private List<String> listaDeSaltos;
	
	
	public Principal(){
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
	
	public void excutarPredicoes(String caminhoDoArquivo) throws FileNotFoundException{
		this.adicionarSaltos(caminhoDoArquivo);
		for(String saltos : this.listaDeSaltos){
			System.out.println(saltos);
			System.out.println("");
			for(Preditor preditor : this.listaDePreditores){
				preditor.predizer(saltos);
				preditor.exibirResultados();
				preditor.reset();
				System.out.println("");
			}
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Principal p = new Principal();
		try {
			p.excutarPredicoes("C:\\Users\\Thales\\Documents\\teste.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao abrir o arquivo.");
		}

	}

}
