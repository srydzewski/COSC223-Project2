public class Distribution {

    public static double generateArrival(double lambda){
        double u = Math.random();
        return (-1/lambda)*Math.log(1-u);
    }

    public static double generateSize(double variance){
        return 1.0;
    }

}
