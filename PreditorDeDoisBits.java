package font;

public class PreditorDeDoisBits extends Preditor{
	private int contadorDeErros;
	
	public PreditorDeDoisBits() {
		super();
		this.contadorDeErros = 0;
		this.nomeDoPreditor = "Preditor de dois bit";
	}
	
	
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
