import java.util.Scanner;

public class Menu {

    Scanner in = new Scanner(System.in);
    int opcao;

    public void pegarArquivo(){
        // Pega o nome do arquivo que o usuário deseja ler
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo a ser lido");
        String arquivo = in.next();

        Leitura leitura = new Leitura();
        leitura.lerArquivo(arquivo);
    }

    public void mostraMenu(){
        System.out.println("|-------------------------------------------------------------------------------|");
        System.out.println("1 - Exibir todo o índice remissivo"); // ordem alfabética
        System.out.println("2 - Exibir o percentual de stopwords do texto");
        System.out.println("3 - Encontrar a palavra mais frequente, isto é, com maior número de ocorrências ");
        System.out.println("4 - Pesquisar palavra ");
        System.out.println("5 - Sair");
        System.out.println("|-------------------------------------------------------------------------------|");
        opcao = in.nextInt();
    }

    public void opcoes(){
        do{
        mostraMenu();
            switch (opcao){
                case 1:
                    System.out.println(Leitura.listaPalavras.toString());
                    break;
                case 2:
                    StopWords.getPorcentagemStopWords();
                    break;
                case 3:

                    //*****************lista.palavraMaisRecorrente();
                    break;
                case 4:
                    break;

            }
        } while (opcao != 5);
    }


}

