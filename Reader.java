package font;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
	public static List<String> resultadoDaLeitura;
	public static Scanner reader;
	
	
	@SuppressWarnings("resource")
	public static void read(String caminhoDoArquivo) throws FileNotFoundException{
		resultadoDaLeitura = new ArrayList<String>();
		reader = new Scanner(new FileReader(caminhoDoArquivo)).useDelimiter("\\n");
		
		while(reader.hasNext()){
			resultadoDaLeitura.add(reader.next());
		}
	}
}
