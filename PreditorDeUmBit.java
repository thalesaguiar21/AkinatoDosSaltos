package font;

public class PreditorDeUmBit extends Preditor {
	
	public PreditorDeUmBit(){
		super();
		this.nomeDoPreditor = "Preditor de um bit";
	}
	
	public void setProximaPredicao() {
		if(this.proximaPredicao == 'T'){
			this.proximaPredicao = 'N';
		}
		else if(this.proximaPredicao == 'N'){
			this.proximaPredicao = 'T';
		}
		else{
			System.out.println("Não é uma predição válida.");
		}
	}

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
