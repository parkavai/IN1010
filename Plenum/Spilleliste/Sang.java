class Sang {
	private String[] artist;
	private String tittel;
	Sang (String tittel, String[] artister) {
		artist = artister; //artist i steden for artister. Typisk skrivefeil!!
		this.tittel = tittel;

	}

	public void spill(){
		System.out.println("Spiller "
                + this);
	}
    public boolean sjekkArtister(String navn){
        return true; //Hjemmelekse!
    }
	public String[] hentArtist(){
        return artist;
	}
	public String hentTittel(){
		return tittel;
	}
    public String toString(){
        return tittel + " av " + artist[0];
    }
}
