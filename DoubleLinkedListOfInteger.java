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

            if (aux.element.equals(element)) {

                return true;
            }

            aux = aux.next;

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

            if (aux.element.equals(element)) {

                return i;
            }

            aux = aux.next;

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

    private Node getNodeIndex(int index) {
        Node aux = null;

        if (index < count / 2) {
            aux = header.next;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
        } else {
            aux = trailer.prev;
            for (int i = count - 1; i > index; i--) {
                aux = aux.prev;
            }
        }

        return aux;

    }

    public void add(int index, Integer element) {

        if (index > count || index < 0) {

            throw new IndexOutOfBoundsException("Erro" + index);

        }

        if (index == count) {
            add(element);
        } else {

            Node aux = getNodeIndex(index);

            Node newNode = new Node(element);

            aux.prev.next = newNode;
            newNode.prev = aux.prev;

            newNode.next = aux;
            aux.prev = newNode;

            count++;

        }

    }

    public Integer get(int index) {

        if (index > count || index < 0) {

            throw new IndexOutOfBoundsException("Erro" + index);

        }

        Node aux = getNodeIndex(index);

        return aux.element;

    }

    public Integer set(int index, Integer element) {

        if (index > count || index < 0) {

            throw new IndexOutOfBoundsException("Erro" + index);

        }

        Node aux = getNodeIndex(index);

        Integer old_element = aux.element;

        aux.element = element;

        return old_element;
    }

    public Integer removeByIndex(int index) {

        if (index > count || index < 0) {

            throw new IndexOutOfBoundsException("Erro" + index);

        }

        Node aux = getNodeIndex(index);

        Integer old_element = aux.element;

        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;

        count--;

        return old_element;

    }

    public Integer[] subList(int fromIndex, int toIndex) {

        if (fromIndex > count || fromIndex < 0 || toIndex > count || toIndex < 0 || fromIndex > toIndex) {

            throw new IndexOutOfBoundsException("Erro" + fromIndex + toIndex);

        }

        int size = toIndex - fromIndex + 1;

        Integer[] aux_array_list = new Integer[size];

        for (int i = 0; i < size; i++) {

            Node aux = header.next;

            aux_array_list[i] = aux.element;

            aux = aux.next;

        }

        return aux_array_list;

    }

}