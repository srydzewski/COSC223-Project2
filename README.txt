Probability and Computing Project 2
Samantha Rydzewski and Lesley Zheng

To run our code:
  compile the code with javac *.java
  type java Tester to run Experiment 1 with implementation 1
  type java TesterWithN to run Experiment 1 with implementation 2
  type java TesterTwo to run Experiment 2

The Distribution Class:
This class is used to generate values from an exponential and a hyperexponential
distribution.
-generateExp() takes in a lambda or mu value and returns a value from
  an exponential distribution with that parameter
-generateHyperExp() takes in a variance and returns a value from
  a hyperexponential distribution with that variance
-setParameters() is used by generateHyperExp to set the values of p, mu1, and mu2
-getMu1() takes in the value p and calculates mu1 from it
-getMu2() takes in the value p and calculates mu2 from it

The Job Class:
This class is used to represent a single job in the system.
-getJobSize() returns the service time of the job
-getArrivalTime() returns the time the job arrived in the system

The Simulation Class:
This class is used to simulate a single-server queueing system
in which we keep track of the time each job spent in the system.
Interarrival times are generated from an exponential and job sizes
are generated from a hyperexponential.
-run() runs the simulation for a given number of jobs and records
how long each job spent in the system
-getAvgResponseTime() returns the mean response time of the simulation
by dividing he sum of the times the jobs spent in the system by the
number of jobs in total

The SimulationWithN Class:
This class is used to simulate a single-server queueing system in
which we keep track of the number of jobs in the system every arrival sees.
Interarrival times are generated from an exponential and job sizes
are generated from a hyperexponential.
-run() runs the simulation for a given number of jobs and records
how long each job spent in the system
-getAvgResponseTime() returns the mean response time of the simulation
by calculating the average number of jobs seen at every arrival and dividing
that by lambda

The SimulationTwo Class:
This class is used to simulate a single-server queueing system in which we keep
track of the time each job spent in the system. Job sizes are generated from an
exponential and interarrival times are generated from a hyperexponential.
-run() runs the simulation for a given number of jobs and records
how long each job spent in the system
-getAvgResponseTime() returns the mean response time of the simulation
by dividing he sum of the times the jobs spent in the system by the
number of jobs in total

The Tester Class:
This class is used to run Experiment 1 under the first implementation
-main() runs 1000 trials for every lambda value and under every variance
using Simulation, saving the results to a csv
-average() returns the mean of values in an array

The TesterWithN Class:
This class is used to run Experiment 1 under the second implementation
-main() runs 1000 trials for every lambda value and under every variance
using SimulationWithN, saving the results to a csv
-average() returns the mean of values in an array

The TesterTwo Class:
This class is used to run Experiment 2
-main() runs 1000 trials for every lambda value and under every variance using
SimulationTwo, saving the results to a csv
-average() returns the mean of values in an array
