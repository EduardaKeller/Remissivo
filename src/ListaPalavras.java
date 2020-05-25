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
        }

        public void palavraRepetida(String palavra){
            for(int i = 0; i <repositorio.length; i++){
                if(!repositorio[i].equals(palavra)){
                    insereRepositorio(palavra);
                    // falta criar o nodo pra inserir a palavra
                }
            }
        }

        public void insereRepositorio(String palavra){
            repositorio[count] = palavra;
        }





}
