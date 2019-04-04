import java.util.ArrayList;
public class Simulation {
  private double lamda;
  private double varX;
  private int numJobs;
  private int numThrowOut;
  private double sumArrivalsSeen;
  private ArrayList<Job> queue = new ArrayList<Job>();
  private double arrivalTime;
  private double departureTime;
  private double time;
  private Job currentJob;

  public Simulation(double lamda, int var, int N, int throwOut){
    this.lamda = lamda;
    varX = var;
    numJobs = N;
    numThrowOut = throwOut;
    sumArrivalsSeen = 0;
    arrivalTime = generateExp(lamda);
    departureTime = -1.0;
    time = 0;
    currentJob = null;
  }

  public void run(){
    int jobsDone = 0;
    while (jobsDone < numJobs){
      //if next event is an arrival
      if (arrivalTime < departureTime || departureTime < 0){
        time = arrivalTime;
        //add how many jobs are before the arrival
        if (jobsDone >= numThrowOut){
          sumArrivalsSeen += queue.size();
        }
        //generate new job
        double new_size = generateHyperExp(varX);
        Job new_job = new Job(new_size);
        //if server is idle
        if (currentJob == null){
          currentJob = new_job;
          departureTime = time + new_size;
        }
        //else add to queue
        else{
          queue.add(new_job);
        }
        arrivalTime = time + generateExp(lamda);
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
          Job upNext = queue.remove(0);
          currentJob = upNext;
          depatureTime = time + currentJob.getJobSize();
        }
        jobsDone++;
      }
    }
  }

  public double getAvgResponseTime(){
    run();
    //finding E[T] by Little's Law
    double avgJobsBefore = sumArrivalsSeen/(numJobs - numThrowOut);
    return avgJobsBefore/lamda;
  }

}
