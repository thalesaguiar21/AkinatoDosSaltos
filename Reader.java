package font;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
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
	
	public static void saveFile(String caminhoDoArquivo, String conteudo){
		File novoArquivo = new File(caminhoDoArquivo);
		try(PrintWriter pw = new PrintWriter(novoArquivo)){
			pw.println(conteudo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
				
	}
}
