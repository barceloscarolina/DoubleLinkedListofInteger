public class main {

    public static void main(String args[]) {

        DoubleLinkedListOfInteger lista = new DoubleLinkedListOfInteger();

        for (Integer i = 1; i < 20; i++) {
            lista.add(i);
        }

        System.out.println(lista.toStringBacktoFront());

    }

}
