/**
 * Oppretter classen Vanedannende som er en subklasse av legemiddel Tar ogsaa og
 * opretter en til variabel: int styrke
 */
class Vanedannende extends Legemiddel {
    int styrke;

    /**
     * Oppretter konstruktoeren, og tar med paramterne fra super klassen + int styrke
     */
    public Vanedannende(String navn, int pris, double virkestoff, int s) {
        super(navn, pris, virkestoff);
        styrke = s;
    }

    /**
     * Returnerer styrke
     */
    public int hentVanedannendeStyrke() {
        return styrke;
    }

    /**
     * Returnerer en utskrift som er tilpasset klassen paa en ryddig og fin maate.
     */
    @Override
    public String toString() {
        String streng = super.toString();
        streng += "Styrke: " + styrke + "\n";
        return streng;
    }
}
