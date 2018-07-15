
public class CPU_Scheduling_Algorithms {
	
	public void RoundRobin(double[] burstTimes, double time, double quantum, int numProcesses) {
		
		double completionTimes[] = new double[30];
		
		//keep traversing processes until they're all done
		while(true) {
			boolean done = true;
			//traverse all the processes
			for(int x = 0; x < numProcesses; ++x) {
				//if there is still code to execute in the process
				if(burstTimes[x] > 0) {
					done = false;//there is still another process to complete
					if(burstTimes[x] > quantum) {
						time += quantum;
						burstTimes[x] -= quantum;
					}
				    else {
						time += burstTimes[x];
						burstTimes[x] = 0;
						completionTimes[x] = time;
					}
				}
				
			}
		    if(done == true) {
			    break;
		    }
		}

	    avgCompletionTime(completionTimes, numProcesses);
		//System.out.println("Average Completion Time: " + avgCompletionTime)
	}
	// ========================================================================
	public void FirstComeFirstServe(double[] burstTimes, double time, int numProcesses) {
		
		double completionTimes[] = new double[30];
		
		for(int x = 0; x < numProcesses; ++x) {
			time += burstTimes[x];
			completionTimes[x] = time;	
		}
		avgCompletionTime(completionTimes,numProcesses);
	}
	// ========================================================================
	public void ShortestJobFirst(double[] burstTimes, double time, int numProcesses) {
		
		double completionTimes[] = new double[30];
		//double shortestJob = burstTimes[0];
		//int x;
		//int y = 0;
	    boolean swapped;
	    
	    // bubble sort to sort the array smallest-->biggest
	    for(int x = 0; x < numProcesses-1; x++) {
	    	swapped = false;
	        for(int y = 0; y < numProcesses - x - 1; y++)
	            if(burstTimes[y] > burstTimes[y+1]) {
	                //swap
	                double temp = burstTimes[y];
	                burstTimes[y] = burstTimes[y+1];
	                burstTimes[y+1] = temp;
	                swapped = true;
	            }
	        //if the inner loop doesn't swap anything then the array is sorted
	        if(!swapped)
	            break;
	    }
	    for(int z = 0; z < numProcesses;++z) {
	    	time += burstTimes[z];
	    	completionTimes[z] += time;
	    }
	    avgCompletionTime(completionTimes, numProcesses);
		
	}
	// ========================================================================
	public void avgCompletionTime(double[] completionTimes,int numProcesses) {
		double avgCompletionTime;
		double sum = 0;
		for(int x = 0; x < 30; ++x) {
			sum += completionTimes[x];
		}
		avgCompletionTime = (sum/numProcesses);
		
		System.out.println("Average Completion Time: " + avgCompletionTime);
	}

}
