public class Tester{
  public static void main(String[] args){
    Simulation system = new Simulation(.3,10,100,0);
    double expectedResponseTime = system.getAvgResponseTime();
    System.out.println(expectedResponseTime);
  }
}
