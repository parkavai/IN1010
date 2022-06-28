/**
 * Oppretter classen BlaaResept som er en subklasse av Resept
 */
class BlaaResept extends Resept {
    /**
     * Oppretter konstruktoeren, og tar med paramterne fra super klassen
     */
    public BlaaResept(Legemiddel middel, Lege lg, Pasient p, int rt) {
        super(middel, lg, p, rt);
    }

    /**
     * Overrider metoden: farge() fra superklassen, og returnerer Stringer "hvit"
     */
    @Override
    public String farge() {
        return "blaa";
    }

    /**
     * Overrider metoden: farge() fra superklassen, og returnerer Stringer "hvit"
     */
    @Override
    public int prisAaBetale() {
        int pris = legemiddel.hentPris();
        return pris * 25 / 100;
    }

    /**
     * Returnerer en utskrift som er tilpasset klassen paa en ryddig og fin maate.
     */
    @Override
    public String toString() {
        String streng = super.toString();
        streng += "Pris aa betale: " + prisAaBetale() + "\n";
        streng += "Farge: " + farge() + "\n";
        return streng;
    }
}
