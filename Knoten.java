package lists.ownlist;

public class Knoten<Typ> {

    private Knoten<Typ> naechsterKnoten;
    private Typ inhalt;

    public Knoten(Typ pInhalt) {
        this.inhalt = pInhalt;
    }

    public void setzeNaechsten(Knoten<Typ> pKn) {
        naechsterKnoten = pKn;
    }

    public Knoten<Typ> gibNaechsten() {
        return naechsterKnoten;
    }

    public void setzeInhalt(Typ pInhalt) {
        inhalt = pInhalt;
    }

    public Typ gibInhalt() {
        return inhalt;
    }


}