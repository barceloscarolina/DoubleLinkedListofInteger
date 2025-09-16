public class main {

    public static void main(String args[]) {

        DoubleLinkedListOfInteger lista = new DoubleLinkedListOfInteger();

        for (Integer i = 1; i < 10; i++) {
            lista.add(i);
        }

        // Integer remover = 2;

        System.out.println(lista.toString());

        Integer[] sub = lista.subList(3, 8);

        // System.out.println(sub[4]);

        // System.out.println(lista.toString());

        for (int i = 0; i < sub.length; i++) {

            System.out.println(sub[i]);

        }

    }

}
