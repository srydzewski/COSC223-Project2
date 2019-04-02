public class Job{
  private int arrivalTime;
  private int jobSize;
  public Job(int arrivalTime, int jobSize){
    this.arrivalTime = arrivalTime;
    this.jobSize = jobSize
  }

  public int getJobSize(){
    return jobSize;
  }

  public int getArrivalTime(){
    return arrivalTime;
  }
}
