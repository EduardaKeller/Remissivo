import java.util.Scanner;


public class Main {
    public static void main (String [] args){

        // Pega o nome do arquivo que o usuário deseja ler
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo a ser lido");
        String arquivo = in.next();

        StopWords.InicializaStopWords();

        Leitura leitura = new Leitura();
        leitura.lerArquivo(arquivo);

       Menu menu = new Menu();
       menu.mostraMenu();

        //leitura.separaPalavras();

        //ListaPalavras listaPalavras = new ListaPalavras();
        //listaPalavras.ListaRepositorio();
    }
}
