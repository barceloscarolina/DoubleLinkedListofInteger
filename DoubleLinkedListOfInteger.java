public class DoubleLinkedListOfInteger {

    private Node header;
    private Node trailer;
    private int count;

    private class Node {
        public Integer element;
        public Node next;
        public Node prev;

        public Node(Integer element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }

        public Node(Integer element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;

        }

    }

    public DoubleLinkedListOfInteger() {

        this.header = new Node(null);
        this.trailer = new Node(null);

        header.next = trailer;
        trailer.prev = header;

        count = 0;

    }

    public boolean isEmpty() {

        return (count == 0);

    }

    public int size() {
        return count;
    }

    public void clear() {

        this.header = new Node(null);
        this.trailer = new Node(null);

        header.next = trailer;
        trailer.prev = header;

        count = 0;

    }

    public boolean contains(Integer element) {

        Node aux = header.next;

        for (int i = 0; i < count; i++) {

            if (aux.element.equals(element))
                ;
            return true;

        }

        return false;

    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();

        Node aux = header.next;

        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");

            aux = aux.next;
        }

        return s.toString();

    }

    public String toStringBacktoFront() {

        StringBuilder s = new StringBuilder();

        Node aux = trailer.prev;

        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");

            aux = aux.prev;
        }

        return s.toString();

    }

    public int indexOf(Integer element) {

        Node aux = header.next;

        for (int i = 0; i < count; i++) {

            if (aux.element.equals(element))
                ;
            return i;

        }

        return -1;

    }

    public void add(Integer element) {

        Node n = new Node(element);

        trailer.prev.next = n;

        n.prev = trailer.prev;

        n.next = trailer;

        trailer.prev = n;

        count++;

    }

    public boolean remove(Integer element) {

        Node aux = header.next;

        for (int i = 0; i < count; i++) {

            if (aux.element.equals(element)) {

                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;

                count--;

                return true;

            }

            aux = aux.next;

        }

        return false;

    }

}