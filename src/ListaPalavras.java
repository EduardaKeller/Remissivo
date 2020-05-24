public class ListaPalavras {
        private Node header;
        private Node trailer;
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

        public void ListaPalavras() {
            header = new Node(null);
            trailer = new Node(null);
            header.next = trailer;
            trailer.prev = header;
            count = 0;
        }
}
