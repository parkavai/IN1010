public class MinRunnableBank implements Runnable{

    int belop;
    BankMonitor bank;

    public MinRunnableBank(int belop, BankMonitor bank){
        this.belop = belop;
        this.bank = bank;
    }

    public void run(){
        for (int i = 0; i < 5; i++){
            bank.ta(belop);
            bank.gi(belop);
            System.out.println(bank.saldo());
        }
    }


    
}
