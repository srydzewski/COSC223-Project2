public class Job{
  private double jobSize;
  private double arrivalTime;
  public Job(double jobSize, double arrivalTime){
    this.jobSize = jobSize;
    this.arrivalTime = arrivalTime;
  }

  public double getJobSize(){
    return jobSize;
  }

  public double getArrivalTime(){
    return arrivalTime;
  }
}
