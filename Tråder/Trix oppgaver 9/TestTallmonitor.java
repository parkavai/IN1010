class TestTallmonitor{
  public static void main(String[] args) {
    Tallmonitor tm = new Tallmonitor();
    Thread traad1 = new Thread(new Nedover(tm));
    Thread traad2 = new Thread(new Oppover(tm));
    traad1.start();
    traad2.start();
  }
}