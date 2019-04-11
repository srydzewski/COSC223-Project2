import java.io.*;
public class TesterTwo{
  private static boolean debug = true;
  private static int repeats = 1000;

  public static void main(String[] args) throws IOException{

      double[] variances = {1, 10, 20, 50};
      double[] lambdas = {1,2,3,4,5,6,7,8,9,10};

      double[][] results = new double[variances.length*lambdas.length][3];
      int counter = 0;

      for (int i = 0; i<variances.length; i++){

          if (debug){
              System.out.println("Variance " + variances[i]);
          }

          for (int j = 0; j<lambdas.length; j++){

              if (debug){
                  System.out.println("\tLambda " + lambdas[j]);
              }

              double[] tempRTs = new double[repeats];

              for (int repeat = 0; repeat<repeats; repeat++){

                  if (debug){
                      System.out.println("\t\trepeat " + repeat);
                  }

                  SimulationTwo system = new SimulationTwo(lambdas[j], variances[i], 1000000, 10000);
                  tempRTs[repeat] = system.getAvgResponseTime();

              }//repeats

              double response_time = average(tempRTs);
              double v = variances[i];
              double lam = lambdas[j];
              double rt = response_time;
              results[counter][0] = v;
              results[counter][1] = lam;
              results[counter][2] = rt;

              if (debug){
                  //System.out.println("variance " + v + ", lambda " + lam + ", response time " + rt);
              }

              counter++;

          }//lambda
      }//variance

      //to csv
      FileWriter writer = new FileWriter("resultsTwo.csv");
      for (int k = 0; k<results.length; k++){

          for (int l = 0; l<results[0].length; l++){

              writer.append(String.valueOf(results[k][l]));
              writer.append(",");

          }//l loop

          writer.append("\n");

      }//k loop
      writer.close();

  }//main

  private static double average(double[] myArray) {

      double sum = 0;
      for (double item:myArray) {
          sum+=item;
      }
      double value = sum/(double)myArray.length;
      return Math.round(value * 100000d) / 100000d;
  }

}//tester
