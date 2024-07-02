package lists;

import lists.ownlist.VerketteteListe;

public class Main {

    public static void main(String[] args) {
        VerketteteListe<String> testListe = new VerketteteListe<>();

        System.out.println(testListe.istLeer());

        testListe.anhaengen("Test Inhalt");

        System.out.println(testListe.istLeer());

        System.out.println(testListe.inhalt(0));

        testListe.entfernenElement("Test Inhalt");

        System.out.println(testListe.inhalt(0));
    }

}
