
public class DoubleLinkedListPalavras {
    private Node header;
    private Node trailer;
    private int count;

    private class Node {
        public Palavra element;
        public Node next;
        public Node prev;
        public Node(Palavra e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    public DoubleLinkedListPalavras() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    public Node getNodeRef(Palavra palavra){
        Node aux = new Node(null);
        aux = header.next;
        for(int i=0; i<count;i++){
            if(aux.element.getPalavra().equals(palavra.getPalavra())){return aux;}
            aux = aux.next;
        }
        return aux;
    }

    public void palavraMaisFrequente(){
        Node aux = new Node(null);
        Node auxMaisFrequente = new Node(null);
        auxMaisFrequente = header.next;
        aux = header.next;
        for(int i=0; i<count;i++){
            if(aux.element.getVezesQueAparece()>= auxMaisFrequente.element.getVezesQueAparece()){auxMaisFrequente = aux;}
            aux = aux.next;
        }
        System.out.println("Palavra mais frequente do texto: " +auxMaisFrequente.element.getPalavra());
    }

    /**
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Palavra element) {
        Node n = new Node(element);
        n.next = trailer;
        n.prev = trailer.prev;
        trailer.prev.next = n;
        trailer.prev = n;
        count++;
    }

    /**
     * Adiciona uma pagina no nodo da palavra
     * @param palavra pega a nova pagina e adiciona ao nodo existente referente a palavra em questão
     */
    public void addPagina(Palavra palavra){
        Node aux = getNodeRef(palavra);
        aux.element.addVezesQueApareceu();
        if(aux.element.getPagina()!=palavra.getPagina()) {
            aux.element.addPagina(palavra.getPagina());
        }
    }

    /**
     * Verifica se existe um nodo com a palavra desejada
     * @param element pega a palavra desejada e compara com os nodos existentes
     */
    public boolean contains(Palavra element) {
        Node aux = header.next;
        while (aux != trailer) {
            if (aux.element.getPalavra().equals(element.getPalavra())) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    public void add(Palavra element, int index){
        if (index < 0 || index > count)
            throw new IndexOutOfBoundsException();

        if (index == count) {
            add(element);
        }

        Node n = new Node(element);
        Node aux = getNodeRefIndex(index);

                n.prev = aux.prev;
        n.next = aux;
        aux.prev.next = n;
        aux.prev = n;
        count++;
    }

    /**
     * Insere um elemento em uma determinada posicao da lista
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void addOrdenado(Palavra element) throws IndexOutOfBoundsException {
        if(count == 0){
            add(element);
            return;
            }
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            int compare = element.getPalavra().compareTo(aux.element.getPalavra());

            if(compare <= 0){
                add(element,i);
                return;
            }else{
                if(aux.equals(trailer.prev)){
                    add(element);
                    return;
                }
            }
            aux = aux.next;

        }
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Palavra get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeRefIndex(index);
        return aux.element;
    }

    // Metodo que retorna a referencia para o nodo da posicao index
    private Node getNodeRefIndex(int index) {
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
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     */
    public int indexOf(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n ");
            aux = aux.next;
        }
        return s.toString();
    }




}

