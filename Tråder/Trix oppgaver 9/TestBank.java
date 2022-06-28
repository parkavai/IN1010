class TestBank {
    public static void main(String[] args) {

        BankMonitor bank = new BankMonitor();

        for (int i = 0; i < 1000; i++){
            MinRunnableBank g = new MinRunnableBank(i, bank);
            Thread traad = new Thread(g);
            traad.start();
        }
    }
}