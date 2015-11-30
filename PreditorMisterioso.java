package font;

public class PreditorMisterioso extends Preditor{
	
	private int freqDeSaltosTomados;
	
	public PreditorMisterioso() {
		super();
		this.freqDeSaltosTomados = 0;
		this.nomeDoPreditor = "Preditor misterioso";
	}

	@Override
	void predizer(String listaDeSaltos) {
		for(int i = 0; i < listaDeSaltos.length(); i++){
			this.predicoesFeitas += this.proximaPredicao;
			char atual = listaDeSaltos.charAt(i);
			
			//Atualiza a frequência de saltos
			if(atual == 'T'){
				this.freqDeSaltosTomados++;
			}
			if(atual == this.proximaPredicao)
				this.predicoesCorretas++;
			
			//Atualiza a porcentagem de saltos tomados
			double porcDeSaltosTomados = this.freqDeSaltosTomados/(this.predicoesFeitas.length());
			
			//Faz a troca da predição
			if(porcDeSaltosTomados < 0.5)
				this.setProximaPredicao('N');
			else
				this.setProximaPredicao('T');
		}
		
	}
	
	
}
