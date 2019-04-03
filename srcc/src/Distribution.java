public class Distribution {

    private static double mu1 = -1;
    private static double mu2 = -1;
    private static double p = -1;


    public static double generateExp(double lambda){
        double u = Math.random();
        return (-1/lambda)*Math.log(1-u);
    }

    public static double generateHyperExp(double variance){

        double size = -1;

        if (setParameters(variance)){

            double bernoulli = Math.random();
            if (bernoulli<=p){ //first exp
                size = generateExp(mu1);
            } else{ //second exp
                size = generateExp(mu2);
            }

        } else{
            System.out.println("error in set paramters");
        }

        return size;
    }

    private static boolean setParameters(double V){

        if (V==1){
            p=0.5; //see paper solution for why
        } else if (V==10){
            p=0.952267016867;
        } else if (V==20){
            p=0.975594865606;
        } else if (V==50){
            p=0.990098;
        } else{
            throw new IllegalArgumentException("Wrong V value. Must be 1, 10, 20, or 50.");
        }

        mu1 = getMu1(p);
        mu2 = getMu2(p);

        return true;
    }

    private static double getMu1(double p){
        return 2*p;
    }

    private static double getMu2(double p){
        return 2-2*p;
    }

}