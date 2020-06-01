import java.util.Scanner;

public class Menu {

    Scanner in = new Scanner(System.in);
    int opcao;
    ListaPalavras lista = new ListaPalavras();

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
        mostraMenu();
        do{
            switch (opcao){
                case 1:
                    break;
                case 2:
                    System.out.println("Porcentagem de StopWords encontradas no texto: "+StopWords.porcentagemStopWords());
                    break;
                case 3:
                    //*****************lista.palavraMaisRecorrente();
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        } while (opcao != 99);
    }


}

