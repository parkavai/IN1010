class Bits{
    public static void main(String[] args) {
        System.out.println(konverterBits(94));
    }

    static int konverterBits(int nummer){
        String bitstreng = "";
        int antEnere = 0;
        while(nummer != 0){
            if(nummer % 2 == 0){
                bitstreng += "0";
            }
            else if (nummer % 2 == 1){
                bitstreng += "1";
                antEnere += 1;
            }
            nummer = nummer/2;
        }
        return antEnere;
    }
}