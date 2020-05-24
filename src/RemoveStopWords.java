import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RemoveStopWords {

    private static String stopWords[] = new String[350];

    public static boolean RemoveStopWords(String palavra) {

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
                        return true;
                    }
                    //System.out.println(stopWords[i]);
                }
            }

        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }
        return false;
        //oi
    }
}
