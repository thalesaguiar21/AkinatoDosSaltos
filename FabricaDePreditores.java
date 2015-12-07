package preditores;

/**
 * Classe para criação de preditores. Esta classe foi criada apenas para ultilização do padrão
 * de projeto <i>Factory</i>.
 * 
 * @author Thales
 * @version 02/12/2015
 */
public class FabricaDePreditores {

	/**
	 * Retorna um objeto de tipo especificado. (1) para <strong>PreditorDeUmBit</strong>, (2) para
	 * <strong>PreditorDeDoisBits</strong>, (3) para <strong>PreditorMisterioso</strong> e (4) para <strong>PreditorAdaptativoDeDoisNiveis</strong>.
	 * Caso algum outro valor seja passado, uma mensagem de erro será exibida e será retornado <strong>null</strong>.
	 * @param tipoDePreditor
	 * @return
	 */
	public static Preditor criarPreditor(int tipoDePreditor){
		switch(tipoDePreditor){
		case 1:
			return new PreditorDeUmBit();
		case 2:
			return new PreditorDeDoisBits();
		case 3:
			return new PreditorMisterioso();
		case 4:
			return new PreditorAdaptativoDeDoisNiveis();
		default:
			System.out.println("Esse nï¿½o ï¿½ um preditor vï¿½lido.");
			break;
		}
		return null;
	}
}
