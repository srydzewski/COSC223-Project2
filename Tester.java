public class Tester{
  public static void main(String[] args){
    Simulation system = new Simulation(.3,10,1000000,10000);
    double expectedResponseTime = system.getAvgResponseTime();
    System.out.println(expectedResponseTime);
  }
}
