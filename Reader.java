package preditores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe para leitura e escrita de dados em arquivos <i>.txt</i>.
 * @author Thales
 * @version 02/12/2015
 */
public class Reader {
	public static List<String> resultadoDaLeitura;
	public static Scanner reader;
	
	
	/**
	 * Lê um arquivo <i>.txt</i> no url especificado. 
	 * Salva a leitura em um 
	 * <a href = 'https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html'>ArrayList</a>
	 * onde cada elemento representa uma linha do arquivo.
	 * 
	 * @param caminhoDoArquivo URL do arquivo
	 * @throws FileNotFoundException Caso o arquivo não seja encontrado.
	 */
	@SuppressWarnings("resource")
	public static void read(String caminhoDoArquivo) throws FileNotFoundException{
		resultadoDaLeitura = new ArrayList<String>();
		reader = new Scanner(new FileReader(caminhoDoArquivo)).useDelimiter("\\n");
		
		while(reader.hasNext()){
                    resultadoDaLeitura.add(reader.next().trim());
		}
	}
	
	/**
	 * Salva os resultado de uma execução da classe Principal em um arquivo no
	 * URL especificado.
	 * @param caminhoDoArquivo URL onde o arquivo será salvo.
	 * @param conteudo String que possui o conteúdo do arquivo.
	 */
	public static void saveFile(String caminhoDoArquivo, String conteudo){
		File novoArquivo = new File(caminhoDoArquivo);
		try(PrintWriter pw = new PrintWriter(novoArquivo)){
			pw.println(conteudo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
				
	}
}
