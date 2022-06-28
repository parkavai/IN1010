public class TestPrioritetskoe {

    public static void main(String[] args) {
        Prioritetskoe<String> sortertListe = new Prioritetskoe();
        sortertListe.settInn("sss", 0);
        sortertListe.settInn("avscs", 1);
        sortertListe.settInn("sdafa", 2);
        sortertListe.settInn("gggggg", 4);
        System.out.println(sortertListe.toString());
    }
    
}
