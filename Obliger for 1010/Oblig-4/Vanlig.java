/**
 * Oppretter classen Vanlig som er en subklasse av legemiddel
 */
class Vanlig extends Legemiddel {
    /**
     * Oppretter konstruktoeren, og tar med parameterne fra super klassen + int styrke
     */
    public Vanlig(String navn, int pris, double virkestoff) {
        super(navn, pris, virkestoff);
    }
}
