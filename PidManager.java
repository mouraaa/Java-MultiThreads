import java.util.*;
import javax.swing.JOptionPane;

public class PidManager {
	public static void main(String[] args) {

		Task task = new Task();
		ask(task);
	}

	//repeatedly asks the user what they would like to do
	//also takes care of edge cases
	public static void ask(Task task) {

		int answer = 0;
		Scanner input = new Scanner(System.in);
		while(answer != 1 || answer != 2 || answer != 3) {
			System.out.print("\nWhat would you like to do?\nAllocate a pid (1)\nRelease a pid (2)\nEnd program (3)\nAnswer: ");
			try {
				answer = input.nextInt();
				if(answer == 1) {
					int key = task.allocate_pid();
					if(key == -1) {
						JOptionPane.showMessageDialog(null, key + " : No pids were available" );
					}
				}
				else if(answer == 2) {
					System.out.print("\nWhat pid number would you like to release?\nAnswer: ");
					int int_pid = input.nextInt();
					task.release_pid(int_pid);
				}
				else if(answer == 3) {
					break;
				}
				else {
					JOptionPane.showMessageDialog(null, "\nThat was an invalid answer. Please try again.");
				}
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "That was an invalid answer. Please try again.");
				ask(task);
			}
		}
	}
}