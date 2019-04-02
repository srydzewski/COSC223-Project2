import java.util.ArrayList;
public class Simulation {
  private double lamda;
  private int varX;
  private int numJobs;
  private int numThrowOut;
  private int sumResponseTime;
  private ArrayList<Job> queue = new ArrayList<Job>();
  private int arrivalTime=0;
  private int departureTime=0;
  private int time;
  private Job currentJob = null;
  //fix paramters based on Lesley's code
  public Simulation(double lamda, int var, int N, int throwOut){
    this.lamda = lamda;
    varX = var;
    numJobs = N;
    numThrowOut = throwOut;
    sumResponseTime = 0;
    time = 0;

    start()
  }

  public void start(){
    //initialzing the queue to have a job on the server
    int arrival0 = generateArrival(lamda);
    int size0 = generateSize(varX);
    Job job0 = new Job(arrival0, size0);
    currentJob = job0;
    time = arrival0;
    departureTime = arrival0 + size0;
    int arrival1 = generateArrival(lamda);
    arrivalTime = arrival0 + arrival1;
  }

  public double run(){
    int jobsDone = 0;
    while (jobsDone < numJobs){
      //if next event is an arrival
      if (arrivalTime < departureTime){
        time = arrivalTime;
        //generate new job
        int new_arrival = generateArrival(lamda);
        int new_size = generateSize(varX);
        Job new_job = new Job(time+new_arrival,new_size);
        //if server is idle
        if (currentJob == null){
          currentJob = new_job;
          departureTime = time + new_size;
        }
        //else add to queue
        else{
          queue.add(new_job);
        }
        arrivalTime = time + generateArrival(lamda);
      }
      else {
        time = departureTime;
        
      }

    }
  }


}
