import java.util.LinkedList;
import java.util.Queue;
public class Simulation {
  private double lamda;
  private double varX;
  private int numJobs;
  private int numThrowOut;
  private Queue<Job> queue = new LinkedList<Job>();
  private double arrivalTime;
  private double departureTime;
  private double time;
  private Job currentJob;
  private double sumOfTimes;

  public Simulation(double lamda, double var, int N, int throwOut){
    this.lamda = lamda;
    varX = var;
    numJobs = N;
    numThrowOut = throwOut;
    arrivalTime = Distribution.generateExp(lamda);
    departureTime = -1.0;
    time = 0;
    currentJob = null;
    sumOfTimes = 0;
  }

  public void run(){
    int jobsDone = 0;
    while (jobsDone < numJobs){
      //if next event is an arrival
      if (arrivalTime < departureTime || departureTime < 0){
        time = arrivalTime;
        //generate new job
        double new_size = Distribution.generateHyperExp(varX);
        Job new_job = new Job(new_size,time);
        //if server is idle
        if (currentJob == null){
          currentJob = new_job;
          departureTime = time + new_size;
        }
        //else add to queue
        else{
          queue.add(new_job);
        }
        arrivalTime = time + Distribution.generateExp(lamda);
      }
      //if next event is a departure
      else {
        time = departureTime;
        //if nothing in the queue
        if (queue.size() == 0){
          currentJob = null;
          //setting departureTime < 0 since a departure can't happen
          departureTime = -1.0;
        }
        //otherwise put first job in queue on server
        else {
          if (jobsDone >= numThrowOut){
            sumOfTimes += (time - currentJob.getArrivalTime());
          }
          Job upNext = queue.remove();
          currentJob = upNext;
          departureTime = time + currentJob.getJobSize();
        }
        jobsDone++;
      }
    }
  }

  public double getAvgResponseTime(){
    run();
    double avgResponseTime = sumOfTimes/(numJobs - numThrowOut);
    return avgResponseTime;
  }

}
