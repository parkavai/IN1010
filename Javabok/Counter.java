
class Counter {
  private static int antallCounter = 0;
  private int value;

  public Counter(){
    value = 0;
  }

  public static int getantallCounter() {
    return antallCounter;
  }

  public void count() {
    value = value + 5;
  }

  public int getValue() {
      return value;
  }


}
