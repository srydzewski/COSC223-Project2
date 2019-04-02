public class Distribution {

    private static double mu1 = 0;
    private static double mu2 = 0;
    private static double p = 0;


    public static double generateArrival(double lambda){
        double u = Math.random();
        return (-1/lambda)*Math.log(1-u);
    }

    public static double generateSize(double variance){

        double size = -1;

        if (setParameters(variance)){

            double bernoulli = Math.random();
            if (bernoulli<=p){ //first exp
                size = generateArrival(mu1);
            } else{ //second exp
                size = generateArrival(mu2);
            }

        } else{
            System.out.println("error in set paramters");
        }

        return size;
    }

    private static boolean setParameters(double V){
        //need to figure this out
        return true;
    }

}

//try {
//  SimpleMatrix x = A.solve(b);
//} catch ( SingularMatrixException e ) {
//  throw new IllegalArgument("Singular matrix");
//}
//http://ejml.org/wiki/index.php?title=Solving_Linear_Systems