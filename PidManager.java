import java.util.*;

public class PidManager {
	public static void main(String[] args) {

		Task task = new Task();
		int answer = task.allocate_map();
		if(answer == 1) {
			System.out.println(answer + " : Map allocation was successful\n");
		}
		else {
			System.out.println(answer + " : Map allocation was not successful.\n");
		}

		//array of all the different tasks so each one can use a thread
		Task[] tasks = new Task[10];
		for(int i = 0; i < 10; i++) {
			tasks[i] = new Task();
			tasks[i].start(); //runs the thread while the loop continues running
			//separate the output
			if(i == 9) {
				//sometimes thread 9 happens before this condition, so wait 
				try {
					Thread.sleep(50); 
        		}
		        catch(Exception e) {
		          System.out.println("error");
				}
				System.out.println("-----------------------------------");
			}
		}
	}
}