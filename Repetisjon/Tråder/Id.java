public class Id {

    public static void main(String[] args) {

        for (int i = 0; i <= 10; i++){
            TraadId runnable = new TraadId(i);
            Thread traad = new Thread(runnable);
            traad.start();
        }
        
    }

}

class TraadId implements Runnable{

    int id;

    TraadId(int id){
        this.id = id;
    }

    public void run(){
        for (int i = 0; i <= 10; i++){
            int teller = id*i;
            System.out.println(id + "* " + i + " = " + teller);
        }
    }




}