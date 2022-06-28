class OrdnetLenkeliste{
    public static void main(String[] args) {
        Liste<String> ordListe = new Liste<String>();
        String[] navn = {"I", "dag", "er", "det", "eksamen", "i", "IN1010. \n",
                        "Jeg", "haaper", "du", "liker","denne", "oppgaven.\n",
        "Lykke","til", "hilsen", "oppgaveforfatteren\n"};
        System.out.println("Setter inn:" );
        for(String n: navn){
            System.out.println(n);
            ordListe.settInn(n);
        }
        System.out.println();
        ordListe.skrivAlle();
        System.out.println();
    }
}