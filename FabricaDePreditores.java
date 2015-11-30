package font;

public class FabricaDePreditores {

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
			System.out.println("Esse n�o � um preditor v�lido.");
			break;
		}
		return null;
	}
}
