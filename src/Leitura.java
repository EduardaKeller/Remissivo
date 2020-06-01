
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Leitura {
    public static DoubleLinkedListPalavras listaPalavras;
    private static String linhas[] = new String[10000];
    static int numLinhas = 0;
    int numPaginas = 1;

    StopWords listaDeStopWords = new StopWords();

    public void lerArquivo(String nomeArquivo) {
        listaDeStopWords.InicializaStopWords();
        listaPalavras = new DoubleLinkedListPalavras();

        //Path path1 = Paths.get("src/Arquivos/" + nomeArquivo +".txt");
        Path path1 = Paths.get("src/Arquivos/java.txt");

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.defaultCharset())) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                linhas[numLinhas] = line;
                numLinhas++;
                if (numLinhas % 40 == 0) {
                    numPaginas++;
                }
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }

        int n = 0;
        for (int i = 1; i <= numPaginas; i++) {
            System.out.println("--------------------- Pagina " + i + " ---------------------");
            for (int j = 0; j < 40 && n < numLinhas; j++, n++) {
                System.out.println(linhas[n]);
            }
        }
        separaPalavras();
    }

    //Separa a linha em palavras, verifica se é stopwords e se não for manda pra insereRepositorio
    public void separaPalavras(){

        int n = 1;
        for(int i = 1; i <= numPaginas; i++){
            for(int j = 0; j < 40 && n < numLinhas; j++, n++){
            linhas[n - 1] = linhas[n - 1].replaceAll("\\t", " "); // substitui tab por espaco em branco
            linhas[n - 1] = linhas[n - 1].replaceAll(",", ""); // para remover vírgulas"
            linhas[n - 1] = linhas[n - 1].replaceAll("[.1234567890*()!?]", ""); // para remover vírgulas"
            String[] separa = linhas[n - 1].split(" ");
            for (String s : separa) {
                s = s.toLowerCase();
                if(s.length() != 0) {
                    if (listaDeStopWords.verificaStopWords(s)) {
                    } else {
                        Palavra aux = new Palavra(s, i);
                        if (listaPalavras.contains(aux)) {
                            listaPalavras.addPagina(aux);
                        } else {
                            listaPalavras.addOrdenado(aux);
                        }
                    }
                        }
                    }
                }
        }
    }
    public static void printaPagina(int pagina){
        System.out.println("--------------------- Pagina " + pagina + " ---------------------");
        for (int i = (pagina*40)-40; i < (pagina*40); i++) {
                if(i<numLinhas){System.out.println(linhas[i]);}
                else{}

        }
    }

        /**"for (int i = 1; i <= 10; i++) {"
            System.out.println("\nPalavras da linha " + i + ": ");
            "linhas[i - 1] = linhas[i - 1].replaceAll("\\t", " "); // substitui tab por espaco em branco
            linhas[i - 1] = linhas[i - 1].replaceAll(",", ""); // para remover vírgulas"
            String[] tokens = linhas[i - 1].split(" "); // divide a string pelo espaco em branco
            for (String s : tokens) {
                s = s.toLowerCase();
                System.out.println("->" + s);
            }
        }*/
}

