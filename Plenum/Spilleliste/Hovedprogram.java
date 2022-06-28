class Hovedprogram {
    public static void main(String[] argumentene){
        String tittel = "Dont go breaking my heart";
        String[] artister = new String[]{"Elton John", "Kiki Dee"};
        Sang sang1 = new Sang(tittel, artister);
        Spilleliste sp = new Spilleliste("liste");
        sp.leggTilSang(sang1);
        Sang sang2 = new Sang(tittel, artister);

        sp.leggTilSang(sang2);

    }

}
