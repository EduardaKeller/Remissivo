public class DoubleLinkedListPaginas {
    // Referencia para o sentinela de inicio da lista encadeada.
    private Node header;
    // Referencia para o sentinela de fim da lista encadeada.
    private Node trailer;
    // Referencia para a posicao corrente
    private Node current;
    // Contador do numero de elementos da lista.
    private int count;

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

    public DoubleLinkedListPaginas() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) {
        //Primeiro: instancia o nodo
        Node n = new Node(element);
        // Segundo: "gruda" o novo nodo na lista
        n.next = trailer;
        n.prev = trailer.prev;
        // Terceiro: ajusta os encadeamentos para o novo nodo
        trailer.prev.next = n;
        trailer.prev = n;
        // Quarto: atualiza count
        count++;
    }

    /**
     * Retorna true se a lista contem o elemento especificado
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(Integer element) {
        Node aux = header.next;
        while (aux != trailer) {
            if (aux.element.equals(element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }


    // Metodo que retorna a referencia para o nodo
    // da posicao index
    private Node getNodeRef(int index) {
        Node aux = null;
        if (index < count/2) {
            // Percorre do inicio ate o meio
            aux = header.next;
            for (int i=0; i<index; i++)
                aux = aux.next;
        }
        else {
            // Percorre do fim ate o meio
            aux = trailer.prev;
            for(int i=count-1; i>index; i--)
                aux = aux.prev;
        }
        return aux;
    }

    /**
     * Retorna o numero de elementos da lista
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }


    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }

    /**
     * Retorna um arranjo com uma copia de um subconjunto dos elementos da
     * lista.
     *
     * @param fromIndex a posição inicial ("inclusive") dos elementos a serem
     * incluídos
     * @param toIndex a posição final ("exclusive") dos elementos a serem
     * incluídos
     * @return um arranjo com um subconjunto da lista
     * @throws IndexOutOfBoundsException se (fromIndex < 0 || toIndex > size())
     * @throws IllegalArgumentException se (fromIndex > toIndex)
     */
    public Integer[] subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size())
            throw new IndexOutOfBoundsException();
        if (fromIndex > toIndex)
            throw new IllegalArgumentException();

        Integer a[] = new Integer[toIndex-fromIndex];

        Node aux = header.next;

        for(int i=0; i<fromIndex; i++)
            aux = aux.next;

        for(int i=0; i<(toIndex-fromIndex); i++) {
            a[i] = aux.element;
            aux = aux.next;
        }

        return a;
    }

    public void reset() {
        current = header.next;
    }

    public Integer next() { // O(1)
        if (current != trailer) {
            Integer num = current.element;
            current = current.next;
            return num;
        }
        return null;
    }


    // Retorna o índice da última ocorrência de "element",
    // ou -1 se a lista não contém "element".
    // lista: 10 <-> 50 <-> 30 <-> 10 <-> 40 <-> 50
    //         0      1     2      3       4     5
    // lastIndexOf(50) retorna 5
    // lastIndexOf(30) retorna 2
    public int lastIndexOf(int element) {
        Node aux = trailer.prev;
        for (int i=count-1; i>=0; i--) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.prev;
        }
        return -1;
    }
    public Integer getTail(){
        return trailer.element;
    }

    public Integer getHead(){
        return header.element;
    }
}
