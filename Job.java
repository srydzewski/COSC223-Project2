public class Job{
  private double jobSize;
  private double arrivalTime;
  public Job(double jobSize, double arrivalTime){
    this.jobSize = jobSize;
    this.arrivalTime = arrivalTime;
  }
  //return the service time of the job
  public double getJobSize(){
    return jobSize;
  }
  //return the time the job arrived in the system
  public double getArrivalTime(){
    return arrivalTime;
  }
}
