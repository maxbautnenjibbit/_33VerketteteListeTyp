package lists;


import lists.ownlist.VerketteteListe;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


public class TestList {

    @BeforeAll
    public static void init() {
        System.out.println("TestList init");
    }

    @Test
    public void istLeer() {
        VerketteteListe<Integer> verkettetePrimZahlenListe = new VerketteteListe<>();
        boolean b1 = verkettetePrimZahlenListe.istLeer();

        verkettetePrimZahlenListe.anhaengen(1);
        boolean b2 = verkettetePrimZahlenListe.istLeer();

        assumeTrue(b1);
        assumeFalse(b2);
    }


    @Test
    public void anzahlElemente() {
        VerketteteListe<Integer> verkettetePrimZahlenListe = new VerketteteListe<>();
        int a = verkettetePrimZahlenListe.anzahlElemente();

        verkettetePrimZahlenListe.anhaengen(1);
        verkettetePrimZahlenListe.anhaengen(1);
        int b = verkettetePrimZahlenListe.anzahlElemente();

        verkettetePrimZahlenListe.anhaengen(1);
        verkettetePrimZahlenListe.anhaengen(1);
        verkettetePrimZahlenListe.anhaengen(1);
        int c = verkettetePrimZahlenListe.anzahlElemente();

        assertEquals(a, 0);
        assertEquals(b, 2);
        assertEquals(c, 5);
    }

    @Test
    public void inhalt() {
        VerketteteListe<Integer> verkettetePrimZahlenListe = new VerketteteListe<>();
        verkettetePrimZahlenListe.anhaengen(1);
        verkettetePrimZahlenListe.anhaengen(3);
        verkettetePrimZahlenListe.anhaengen(6);
        verkettetePrimZahlenListe.anhaengen(8);

        assertEquals(verkettetePrimZahlenListe.inhalt(0), 1);
        assertEquals(verkettetePrimZahlenListe.inhalt(1), 3);
        assertEquals(verkettetePrimZahlenListe.inhalt(2), 6);
        assertEquals(verkettetePrimZahlenListe.inhalt(3), 8);
    }

    @Test
    public void ersetzen() {
        VerketteteListe<Integer> verkettetePrimZahlenListe = new VerketteteListe<>();
        verkettetePrimZahlenListe.anhaengen(1);
        verkettetePrimZahlenListe.anhaengen(2);
        verkettetePrimZahlenListe.anhaengen(3);
        verkettetePrimZahlenListe.anhaengen(4);

        verkettetePrimZahlenListe.ersetzen(0, 3);
        verkettetePrimZahlenListe.ersetzen(3, 8);

        assertEquals(verkettetePrimZahlenListe.inhalt(0), 3);
        assertEquals(verkettetePrimZahlenListe.inhalt(3), 8);
    }

    @Test
    public void einfuegen() {
        VerketteteListe<Integer> verkettetePrimZahlenListe = new VerketteteListe<>();
        //
        verkettetePrimZahlenListe.anhaengen(1);
        //
        verkettetePrimZahlenListe.anhaengen(2);
        verkettetePrimZahlenListe.anhaengen(3);
        verkettetePrimZahlenListe.anhaengen(4);

        verkettetePrimZahlenListe.einfuegen(0, 3);
        verkettetePrimZahlenListe.einfuegen(2, 4);

        assertEquals(verkettetePrimZahlenListe.inhalt(0), 3);
        assertEquals(verkettetePrimZahlenListe.inhalt(2), 4);
        assertEquals(verkettetePrimZahlenListe.inhalt(1), 1);
        assertEquals(verkettetePrimZahlenListe.inhalt(3), 2);
    }

    @Test
    public void einfuegenVorne() {
        VerketteteListe<Integer> verkettetePrimZahlenListe = new VerketteteListe<>();
        verkettetePrimZahlenListe.anhaengen(1);
        verkettetePrimZahlenListe.anhaengen(6);

        verkettetePrimZahlenListe.einfuegenVorne(3);

        assertEquals(verkettetePrimZahlenListe.inhalt(0), 3);
        assertEquals(verkettetePrimZahlenListe.inhalt(1), 1);
        assertEquals(verkettetePrimZahlenListe.inhalt(2), 6);
    }

    @Test
    public void anhaengen() {
        VerketteteListe<Integer> verkettetePrimZahlenListe = new VerketteteListe<>();
        verkettetePrimZahlenListe.anhaengen(1);

        assertEquals(verkettetePrimZahlenListe.inhalt(0), 1);

        verkettetePrimZahlenListe.anhaengen(2);

        assertEquals(verkettetePrimZahlenListe.inhalt(1), 2);

        assertEquals(verkettetePrimZahlenListe.anzahlElemente(), 2);
    }

    @Test
    public void entfernen() {
        VerketteteListe<Integer> verkettetePrimZahlenListe = new VerketteteListe<>();
        verkettetePrimZahlenListe.anhaengen(1);
        verkettetePrimZahlenListe.anhaengen(2);
        verkettetePrimZahlenListe.anhaengen(3);
        verkettetePrimZahlenListe.anhaengen(4);

        int e1 = verkettetePrimZahlenListe.entfernen(0);
        int e2 = verkettetePrimZahlenListe.entfernen(1);

        assertEquals(e1, 1);
        assertEquals(e2, 3);
    }

    @Test
    public void entfernenVorne() {
        VerketteteListe<Integer> verkettetePrimZahlenListe = new VerketteteListe<>();
        verkettetePrimZahlenListe.anhaengen(1);
        verkettetePrimZahlenListe.anhaengen(2);
        verkettetePrimZahlenListe.anhaengen(3);
        verkettetePrimZahlenListe.anhaengen(4);

        int e1 = verkettetePrimZahlenListe.entfernenVorne();
        int e2 = verkettetePrimZahlenListe.entfernenVorne();
        int e3 = verkettetePrimZahlenListe.entfernenVorne();
        int i = verkettetePrimZahlenListe.anzahlElemente();

        assertEquals(e1, 1);
        assertEquals(e2, 2);
        assertEquals(e3, 3);
        assertEquals(i, 1);
    }

    @Test
    public void entfernenElement() {
        VerketteteListe<Integer> verkettetePrimZahlenListe = new VerketteteListe<>();
        verkettetePrimZahlenListe.anhaengen(1);
        verkettetePrimZahlenListe.anhaengen(2);
        verkettetePrimZahlenListe.anhaengen(3);
        verkettetePrimZahlenListe.anhaengen(3);
        verkettetePrimZahlenListe.anhaengen(4);

        verkettetePrimZahlenListe.entfernenElement(1);
        verkettetePrimZahlenListe.entfernenElement(4);
        verkettetePrimZahlenListe.entfernenElement(3);

        assumeFalse(verkettetePrimZahlenListe.enthaelt(1));
        assumeFalse(verkettetePrimZahlenListe.enthaelt(4));
        assumeTrue(verkettetePrimZahlenListe.enthaelt(3));

        verkettetePrimZahlenListe.entfernenElement(3);

        assumeFalse(verkettetePrimZahlenListe.enthaelt(3));
    }

    @Test
    public void enthaellt() {
        VerketteteListe<Integer> verkettetePrimZahlenListe = new VerketteteListe<>();
        verkettetePrimZahlenListe.anhaengen(1);
        verkettetePrimZahlenListe.anhaengen(2);
        verkettetePrimZahlenListe.anhaengen(3);
        verkettetePrimZahlenListe.anhaengen(3);
        verkettetePrimZahlenListe.anhaengen(4);

        assumeTrue(verkettetePrimZahlenListe.enthaelt(3));
        assumeTrue(verkettetePrimZahlenListe.enthaelt(4));
        assumeTrue(verkettetePrimZahlenListe.enthaelt(1));
        assumeFalse(verkettetePrimZahlenListe.enthaelt(8));
        assumeFalse(verkettetePrimZahlenListe.enthaelt(10));
    }


}