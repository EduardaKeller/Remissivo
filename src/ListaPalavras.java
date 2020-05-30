public class ListaPalavras {
        private Node header;
        private Node trailer;
        private int count;
        private String [] repositorio; // guarda as palavras

        private class Node {
            public Integer element;
            public Node next;
            public Node prev;

            public Node(Integer e) {
                element = e;
                next = null;
                prev = null;
            }
        }

        public ListaPalavras() {
            this.header = new Node(null);
            this.trailer = new Node(null);
            this.count = 0;
            this.header.next = trailer;
            this.trailer.prev = header;
        }

        public void palavraRepetida(String palavra){
            for(int i = 0; i <repositorio.length; i++){
                if(!repositorio[i].equals(palavra)){
                    insereRepositorio(palavra);
                    Node n = new Node(Integer.parseInt(palavra));  // instancia o nodo
                    n.next = trailer; // "gruda" o novo nodo na lista
                    n.prev = trailer.prev;
                    trailer.prev.next = n; // ajusta os encadeamentos para o novo nodo
                    trailer.prev = n;
                    count++;   // atualiza count
                }
            }
        }

        public void insereRepositorio(String palavra){
            repositorio[count] = palavra;
        }

        public void ListaRepositorio(){
            for(String p : repositorio ){
                System.out.println(p);
            }
        }

        public void palavraMaisRecorrente (){ // a principio exibir a palavra mais recorrente
            int contadorPalavrasRepetidas = 0;
            String palavraRecorrente = "";
            for(int i = 0; i < repositorio.length; i++){ // percorre o vetor
                for (int j = 0; j < repositorio.length; j++){ // percorre vetor e vai coparando com o vetor de cima
                    if (repositorio[i].equals(repositorio[j])){
                        contadorPalavrasRepetidas +=0; // conta a cocorrecias da palavra
                    }
                    int max = 0;
                    if(max < contadorPalavrasRepetidas){
                        max = contadorPalavrasRepetidas; // se contador for maior que max altera max e guarda indice da palavra
                        palavraRecorrente = repositorio[i];
                    }
                }
            }
            System.out.println("Palavra mais recorrente: " + palavraRecorrente);
        }





}
