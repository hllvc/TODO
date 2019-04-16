import java.util.ArrayList;

public class TaskList {

	private String name;
	private int numberOfActive;
	private int numberOfFinished;
	private ArrayList<Task> taskList = new ArrayList<>();
	
	public TaskList(String name) {
		this.name = name;
		this.numberOfActive = 0;
		this.numberOfFinished = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addToList(Task task) {
		this.taskList.add(task);
		numberOfActive++;
	}
	
	public void listOfAllTasks() {
		System.out.println("____________________\n\n"
				+ "--ACTIVE TASKS (" + this.numberOfActive + ")--\n");
		for (Task task: taskList) {
			if (!(task.isStatus()))
				System.out.println((taskList.indexOf(task) + 1) + ". " + task.getName());
		}
		System.out.println("____________________\n\n"
				+ "--FINISHED TASKS (" + this.numberOfFinished + ")--\n");
		for (Task task: taskList) {
			if (task.isStatus())
				System.out.println((taskList.indexOf(task) + 1) + ". " + task.getName());
		}
	}
	
	public void checkFinishedTasks() {
		System.out.println("____________________\n\n"
				+ "--FINISHED TASKS (" + this.numberOfFinished + ")--\n");
		for (Task task: taskList)
			if (task.isStatus())
				System.out.println((taskList.indexOf(task) + 1) + ". " + task.getName());
	}
	
	public void checkActiveTasks() {
		System.out.println("____________________\n\n"
				+ "--ACTIVE TASKS (" + this.numberOfActive + ")--\n");
		for (Task task: taskList)
			if (!task.isStatus())
				System.out.println((taskList.indexOf(task) + 1) + ". " + task.getName());
	}
	
	public int activeTasks() {
		return this.numberOfActive;
	}
	
	public Task findTask(int number) {
		if (number > taskList.size() || number < 1)
			return null;
		else
			number--;
		for (Task task: taskList)
			if (taskList.get(number).getName().equals(task.getName()))
				return task;
		return null;
	}
	
	public Task findTask(String taskName) {
		for (Task task: taskList)
			if (taskName.equals(task.getName()))
				return task;
		return null;
	}
	
	public void removeTask(Task task) {
		if (task.isStatus())
			numberOfFinished--;
		else
			numberOfActive--;
		taskList.remove(task);
	}
	
	public void setTaskStatusDone(Task wantedTask) {
		for (Task task: taskList)
			if (wantedTask == task && !(task.isStatus())) {
				task.setStatus(true);
				numberOfActive--;
				numberOfFinished++;
			}
	}
	
	public void setTaskStatusNotDone(Task wantedTask) {
		for (Task task: taskList)
			if (wantedTask == task && task.isStatus()) {
				task.setStatus(false);
				numberOfActive++;
				numberOfFinished--;
			}
	}
	
	public boolean checkIfEmpty() {
		if (taskList.isEmpty())
			return true;
		else
			return false;
	}
	
	public boolean checkIfHasActive() {
		boolean existing = false;
		for (Task task: taskList)
			if (!(task.isStatus()))
				existing = true;
		return existing;
	}
	
	public boolean checkIfHasFinished() {
		boolean existing = false;
		for (Task task: taskList)
			if (task.isStatus())
				existing = true;
		return existing;
	}
	
}
