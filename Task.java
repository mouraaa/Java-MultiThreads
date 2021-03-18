import java.util.*;
import javax.swing.JOptionPane; //for dialogue box

public class Task {

	public final int MIN_PID = 300;
	public final int MAX_PID = 5000;
	public LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();


	public Task() {
		int answer = allocate_map();
		if(answer == 1) {
			System.out.println(answer + " : Map allocation was successful");
		}
		else {
			System.out.println(answer + " : Map allocation was not successful.");
		}
	}

	//creates a map and itializes all pids to 0
	public int allocate_map() {
		try {
			for(int i = 0; i < 10; i++) {
				Random rnd = new Random();
				int pid = rnd.nextInt(MAX_PID - MIN_PID + 1) + MIN_PID;
				if(map.containsKey(pid)) {
					while(true) {
						int new_pid = rnd.nextInt(MAX_PID - MIN_PID + 1) + MIN_PID;
						if(!map.containsKey(new_pid)) {
							map.put(new_pid,0);
							break;
						}
					}
				}
				else {
					map.put(pid,0);
				}
			}
			return 1;
		}
		catch(Exception e) {
			return -1;
		}
	}

	//iterators through the map until it finds the first pid that can be allocated
	//otherwise, returns -1
	public int allocate_pid() {
		Iterator iterator = map.entrySet().iterator(); 
		while(iterator.hasNext()) {
			Map.Entry mapElement = (Map.Entry)iterator.next(); 
			int key = (int)mapElement.getKey();
			int value = (int)mapElement.getValue();
			if(value == 0) {
				System.out.println("\npid " + key + " was allocated successfuly.");
				map.replace(key,1);
				return key;
			}
		}
		return -1;
	}

	//iterators through the map until it finds the first pid that can be released
	//otherwise, prints all in use
	public void release_pid(int int_pid) {
		if(map.containsKey(int_pid) && map.get(int_pid) == 1) {
			map.replace(int_pid,0);
			JOptionPane.showMessageDialog(null, "pid " + int_pid +  " was released successfully.");
		}
		else {
			JOptionPane.showMessageDialog(null, int_pid + " was either not in the map or not in use.\nPlease try again.");
		}
	}
}

