import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StopWords {

    private static String stopWords[] = new String[500];
    private static int contStopWords = 0;
    private static int contPalavras = 0;

    //Inicializa a lista de StopWords
    public void InicializaStopWords() {
        String linhas[] = new String[1000];
        int numLinhas = 0;

        Path path1 = Paths.get("src/Arquivos/stopwords.txt");// j.txt

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.defaultCharset())) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                stopWords[numLinhas] = line;
                numLinhas++;
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }
    }

    //Verifica se a palavra é stopword ou não comparando com a lista
    public boolean verificaStopWords(String palavra) {
        palavra = removeApostrofe(palavra);
        for (int i = 0; i < stopWords.length; i++) {
            if (stopWords[i] != null) {
                if (palavra.equalsIgnoreCase(stopWords[i])) {
                    contStopWords ++;
                    contPalavras++;
                    return true;
                }else{contPalavras++;
                    return false;}
                    //System.out.println(stopWords[i]);
                }
            }
        return false;
    }

    public double porcentagemStopWords() {
        int aux = (contStopWords/contPalavras)*100;
        return aux;
    }

    //verifica se as últimas duas letras da palavras são 's, se for remove da palavra
    public static String removeApostrofe(String palavra){
        String aux = palavra.substring(palavra.length()-2);
        if(aux.equalsIgnoreCase("'s")){
            return palavra.substring(0,palavra.length()-2);
        }
        else return palavra;
    }

}
