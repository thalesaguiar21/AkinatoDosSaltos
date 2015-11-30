package font;

public abstract class Preditor {
	protected char proximaPredicao;
	protected int predicoesCorretas;
	protected String predicoesFeitas;
	protected String nomeDoPreditor;
	
	public Preditor(){
		this.proximaPredicao = 'T';
		this.predicoesCorretas = 0;
		this.predicoesFeitas = "";
	}
	
	protected void reset(){
		this.predicoesFeitas = "";
		this.predicoesCorretas = 0;
	}
	
	protected double getProcentagemDeAcertos(){
		return (double)(this.predicoesCorretas)/(this.predicoesFeitas.length());
	}
	
	protected void exibirResultados(){
		System.out.println(this.nomeDoPreditor);
		System.out.println("Predições feitas:\t" + this.predicoesFeitas);
		System.out.println("Porcentagem de acertos:\t" + this.getProcentagemDeAcertos());
	}
	
	abstract void predizer(String listaDeSaltos);
	
	
	//Getters and Setters
	public char getProximaPredicao() {
		return proximaPredicao;
	}

	public void setProximaPredicao(char proximaPredicao) {
		this.proximaPredicao = proximaPredicao;
	}

	public int getPredicoesCorretas() {
		return predicoesCorretas;
	}

	public void setPredicoesCorretas(int predicoesCorretas) {
		this.predicoesCorretas = predicoesCorretas;
	}

	public String getPrecicoesFeitas() {
		return predicoesFeitas;
	}

	public void setPrecicoesFeitas(String precicoesFeitas) {
		this.predicoesFeitas = precicoesFeitas;
	}
	
	
}
