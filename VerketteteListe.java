package lists.ownlist;

public class VerketteteListe<Typ> {

    private Knoten<Typ> ersterKnoten = null;

    public boolean istLeer() {
        return ersterKnoten == null;
    }

    public int anzahlElemente() {
        int anzahl = 0;
        Knoten<?> derzeitigerZaehlKnoten = ersterKnoten;

        while (derzeitigerZaehlKnoten != null) {
            anzahl++;
            derzeitigerZaehlKnoten = derzeitigerZaehlKnoten.gibNaechsten();
        }

        return anzahl;
    }

    public Typ inhalt(int pIndex) {
        Knoten<Typ> derzeitigerZaehlKnoten = ersterKnoten;

        for (int i = 0; derzeitigerZaehlKnoten != null; i++) {
            if (i == pIndex) {
                return derzeitigerZaehlKnoten.gibInhalt();
            }
            derzeitigerZaehlKnoten = derzeitigerZaehlKnoten.gibNaechsten();
        }

        return null;
    }

    public void ersetzen(int pIndex, Typ pInhalt) {
        Knoten<Typ> derzeitigerZaehlKnoten = ersterKnoten;

        for (int i = 0; derzeitigerZaehlKnoten != null; i++) {
            if (i == pIndex) {
                derzeitigerZaehlKnoten.setzeInhalt(pInhalt);
                return;
            }
            derzeitigerZaehlKnoten = derzeitigerZaehlKnoten.gibNaechsten();
        }
    }

    public void einfuegen(int pIndex, Typ pInhalt) {
        Knoten<Typ> neuerKnoten = new Knoten<>(pInhalt);

        if (pIndex <= 0) {
            neuerKnoten.setzeNaechsten(ersterKnoten);
            ersterKnoten = neuerKnoten;
        } else {
            Knoten<Typ> derzeitigerZaehlKnoten = ersterKnoten;

            for (int i = 0; derzeitigerZaehlKnoten != null; i++) {
                if (i == pIndex - 1) {
                    neuerKnoten.setzeNaechsten(derzeitigerZaehlKnoten.gibNaechsten());
                    derzeitigerZaehlKnoten.setzeNaechsten(neuerKnoten);
                    return;
                }
                derzeitigerZaehlKnoten = derzeitigerZaehlKnoten.gibNaechsten();
            }
        }
    }

    public void einfuegenVorne(Typ pInhalt) {
        Knoten<Typ> neuerKnoten = new Knoten<Typ>(pInhalt);
        neuerKnoten.setzeNaechsten(ersterKnoten);
        ersterKnoten = neuerKnoten;
    }

    public void anhaengen(Typ pInhalt) {
        Knoten<Typ> neuerKnoten = new Knoten<>(pInhalt);

        if (ersterKnoten == null) {
            ersterKnoten = neuerKnoten;
        } else {
            Knoten<Typ> derzeitigerZaehlKnoten = ersterKnoten;

            while (derzeitigerZaehlKnoten.gibNaechsten() != null) {
                derzeitigerZaehlKnoten = derzeitigerZaehlKnoten.gibNaechsten();
            }

            derzeitigerZaehlKnoten.setzeNaechsten(neuerKnoten);
        }
    }

    public Typ entfernen(int pIndex) {
        if (pIndex <= 0) {
            Knoten<Typ> zuLoeschenderKnoten = ersterKnoten;

            if (zuLoeschenderKnoten != null) {
                ersterKnoten = zuLoeschenderKnoten.gibNaechsten();
                return zuLoeschenderKnoten.gibInhalt();
            }
        } else {
            Knoten<Typ> derzeitigerZaehlKnoten = ersterKnoten;

            for (int i = 0; derzeitigerZaehlKnoten != null; i++) {
                if (i == pIndex - 1 && derzeitigerZaehlKnoten.gibNaechsten() != null) {
                    Knoten<Typ> zuLoeschenderKnoten = derzeitigerZaehlKnoten.gibNaechsten();
                    derzeitigerZaehlKnoten.setzeNaechsten(zuLoeschenderKnoten.gibNaechsten());
                    return zuLoeschenderKnoten.gibInhalt();
                }
                derzeitigerZaehlKnoten = derzeitigerZaehlKnoten.gibNaechsten();
            }
        }

        return null;
    }

    public Typ entfernenVorne() {
        Knoten<Typ> zuLoeschenderKnoten = ersterKnoten;

        if (zuLoeschenderKnoten != null) {
            ersterKnoten = zuLoeschenderKnoten.gibNaechsten();

            return zuLoeschenderKnoten.gibInhalt();
        }

        return null;
    }

    public void entfernenElement(Typ pInhalt) {
        if (ersterKnoten == null) return;

        if (ersterKnoten.gibInhalt() == pInhalt) {
            ersterKnoten = ersterKnoten.gibNaechsten();
        } else {
            Knoten<Typ> derzeitigerZaehlKnoten = ersterKnoten;

            while (derzeitigerZaehlKnoten.gibNaechsten() != null) {
                if (derzeitigerZaehlKnoten.gibNaechsten().gibInhalt() == pInhalt) {
                    derzeitigerZaehlKnoten.setzeNaechsten(derzeitigerZaehlKnoten.gibNaechsten().gibNaechsten());
                    return;
                }
                derzeitigerZaehlKnoten = derzeitigerZaehlKnoten.gibNaechsten();
            }
        }
    }

    public boolean enthaelt(Typ pInhalt) {
        Knoten<Typ> derzeitigerZaehlKnoten = ersterKnoten;

        while (derzeitigerZaehlKnoten != null) {
            if (derzeitigerZaehlKnoten.gibInhalt() == pInhalt) {
                return true;
            }
            derzeitigerZaehlKnoten = derzeitigerZaehlKnoten.gibNaechsten();
        }

        return false;
    }
}