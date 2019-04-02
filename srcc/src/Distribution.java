import Math;

public class Distribution {

    public static double generateArrival(double lambda){
        double u = Math.random();
        double interArrivalTime = (-1/lambda)*Math.log(1-u);
        return interArrivalTime;
    }

    public static double generateSize(double variance){
        return 1.0;
    }

}
