import java.io.*;
public class TesterWithN{
  private static boolean debug = false; //Change to true if you want to track the progress of the simulation
  private static int repeats = 1000; //Determines the number of times you want to repeat the experiment for

  public static void main(String[] args) throws IOException{

      double[] variances = {1, 10, 20, 50}; //List of variances to vary
      double[] lambdas = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9}; //List of lambdas to vary

      double[][] results = new double[variances.length*lambdas.length][3]; //Initializing results array
      int counter = 0; //Keep track  of row in results 'table'

      for (int i = 0; i<variances.length; i++){ //Loop over all variances

          if (debug){
              System.out.println("Variance " + variances[i]);
          }

          for (int j = 0; j<lambdas.length; j++){ //Loop over all lambda values

              if (debug){
                  System.out.println("\tLambda " + lambdas[j]);
              }

              double[] tempRTs = new double[repeats]; //Temporary storage of response time; used to calculate average

              for (int repeat = 0; repeat<repeats; repeat++){ //Repeat to obtain average

                  if (debug){
                      System.out.println("\t\trepeat " + repeat);
                  }

                  SimulationWithN system = new SimulationWithN(lambdas[j], variances[i], 1000000, 10000);
                  tempRTs[repeat] = system.getAvgResponseTime();

              }//repeats

              //Fill out results 'table'
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

      //Write results to csv file
      FileWriter writer = new FileWriter("results.csv");
      for (int k = 0; k<results.length; k++){

          for (int l = 0; l<results[0].length; l++){

              writer.append(String.valueOf(results[k][l]));
              writer.append(",");

          }//l loop

          writer.append("\n");

      }//k loop
      writer.close();

  }//main

  //Method to return the average of all values in an array
  private static double average(double[] myArray) {

      double sum = 0;
      for (double item:myArray) {
          sum+=item;
      }
      double value = sum/(double)myArray.length;
      return Math.round(value * 100000d) / 100000d;
  }
}
