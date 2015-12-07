package preditores;

/**
 * Esta classe implmenta um algoritmo de predi��o baseado no hist�rico completo de saltos do programa.
 * Inicialmente a previs�o come�a supondo que o desvio ser� tomado. O algoritmo se baseia em armazenar 
 * a quantidade de desvios tomados pelo programa, a partir da� � calculada a porcentagem de saltos tomados
 * dentre a quantidade total de saltos realizados at� o momento. Veja o exemplo abaixo para a entrada NTTNN:
 * <br>
 * <strong>Primeira execu��o</strong>:<br>
 * Quantidade de saltos tomados pelo programa = 0<br>
 * Quantidade de saltos feitos = 1<br>
 * Porcentagem de saltos realizado = 0%<br>
 * Pr�xima predi��o = N<br>
 * <strong>Segunda execu��o</strong>:<br>
 * Quantidade de saltos tomados pelo programa = 0<br>
 * Quantidade de saltos feitos = 1<br>
 * Porcentagem de saltos realizado = 50%<br>
 * Pr�xima predi��o = T<br>
 * O algoritmo continua dessa maneira, trocando de T para N baseado na porcentagem de desvios tomados, at� o final.
 * @see Diagrama do algoritmo neste <a href = 'https://imageshack.com/i/paxUcvNYp'> link</a>
 * @author Thales
 * @version 02/12/2015
 */
public class PreditorMisterioso extends Preditor{
	
	private int freqDeSaltosTomados;
	
	/**
	 * Contrutor padr�o para objetos da classe PreditorMisterioso.
	 * O objeto pe inicializado com uma frequencia de saltos realizados igual a 0(zero).
	 */
	public PreditorMisterioso() {
		super();
		this.freqDeSaltosTomados = 0;
		this.nomeDoPreditor = "Preditor misterioso";
	}
        
    /**
     * Sobrecarrega o <i>reset()</i> da classe superior, fazendo com que al�m
     * do reset da classe m�e, seja tbm zerado a frequ�ncia de saltos tomados.
     */
    @Override
    public void reset(){
        super.reset();
        this.freqDeSaltosTomados = 0;
    }

    /**
     * Executa o algoritimo de predi��o de saltos do PreditorMisterioso.
     */
	@Override
	void predizer(String listaDeSaltos) {
		for(int i = 0; i < listaDeSaltos.length(); i++){
			this.predicoesFeitas += this.proximaPredicao;
			char atual = listaDeSaltos.charAt(i);
			
			//Atualiza a frequ�ncia de saltos
			if(atual == 'T'){
				this.freqDeSaltosTomados++;
			}
			if(atual == this.proximaPredicao)
				this.predicoesCorretas++;
			
			//Atualiza a porcentagem de saltos tomados
			double porcDeSaltosTomados = (double)this.freqDeSaltosTomados/(this.predicoesFeitas.length());
			//Faz a troca da predi��o
			if(porcDeSaltosTomados < 0.5){
                            this.setProximaPredicao('N');
                        }
			else
                            this.setProximaPredicao('T');
		}
		
	}
	
	
}
