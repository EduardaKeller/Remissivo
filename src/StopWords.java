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

    public static boolean VerificaStopWords(String palavra) {

        String linhas[] = new String[1000];
        int numLinhas = 0;


        Path path1 = Paths.get("src/stopwords.txt");// j.txt

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.defaultCharset())) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                stopWords[numLinhas] = line;
                numLinhas++;
            }

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

        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }
        return false;
    }

    public static double porcentagemStopWords() {
        int aux = (contStopWords/contPalavras)*100;
        return aux;
    }
}
