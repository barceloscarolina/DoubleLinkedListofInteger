public class main {

    public static void main(String args[]) {

        DoubleLinkedListOfInteger lista = new DoubleLinkedListOfInteger();

        for (Integer i = 1; i < 10; i++) {
            lista.add(i);
        }

        // Integer remover = 2;

        System.out.println(lista.remove(2));

        System.out.println(lista.toStringBacktoFront());

        System.out.println(lista.size());

    }

}
