import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	private static Scanner input = new Scanner(System.in);
	private static ArrayList<TaskList> tasksList = new ArrayList<>();
	private static TaskList taskList;
	private static Task task;
	
	final private static String YES = "yes";
	final private static String NO = "no";
	
	private static void createNewTask() {
		
		AllTxt.newTask();
		String newTask;
		task = null;
		do {
			
			AllTxt.taskName();
			newTask = input.nextLine();
			task = taskList.findTask(newTask);
			if (task != null)
				AllTxt.nameError();
			
		} while (task != null);
		task = new Task(newTask);
		taskList.addToList(task);
		
	}
	
	private static void removeTask() {
		
		int number;
		do {
			
			task = null;
			AllTxt.numberChoice();
			number = input.nextInt();
			task = taskList.findTask(number);
			if (task == null) {
				AllTxt.doesntExist();
				continue;
			}
			taskList.removeTask(task);
			
			
		} while (task == null);
		return;
		
	}
	
	private static void markAsDone() {
		
		int number;
		do {
			
			task = null;
			AllTxt.numberChoice();
			number = input.nextInt();
			task = taskList.findTask(number);
			if (task == null) {
				AllTxt.doesntExist();
				continue;
			}
			taskList.setTaskStatusDone(task);
			
			
		} while (task == null);
		return;
		
	}
	
	private static void markAsNotDone() {
		
		int number;
		task = null;
		do {
			
			AllTxt.numberChoice();
			number = input.nextInt();
			task = taskList.findTask(number);
			if (task == null) {
				AllTxt.doesntExist();
				continue;
			}
			taskList.setTaskStatusNotDone(task);
			
			
		} while (task == null);
		return;
		
	}
	
	private static void activeTasks() {
		
		if (!taskList.checkIfHasActive()) {
			AllTxt.noActiveTask();
			return;
		}
		
		int choice;
		do {
			
			taskList.checkActiveTasks();
			AllTxt.optionsList();
			choice = input.nextInt();
			
			switch (choice) {
		
			case 1:
				input.nextLine();
				markAsDone();
				if (!(taskList.checkIfHasActive()))
					return;
				break;
			
			case 2:
				input.nextLine();
				removeTask();
				if (taskList.checkIfEmpty())
					return;
				break;
				
			default:
				if (choice != 0)
					AllTxt.optionNotAvailable();
				break;
		
			}
			
		} while  (choice != 0);
	}
	
	private static void finishedTasks() {
		
		if (!taskList.checkIfHasFinished()) {
			AllTxt.noFinishedTask();
			return;
		}
		
		int choice;
		do {
			
			taskList.checkFinishedTasks();
			AllTxt.optionsList();
			choice = input.nextInt();
			
			switch (choice) {
		
			case 1:
				input.nextLine();
				markAsNotDone();
				if (!(taskList.checkIfHasFinished()))
					return;
				break;
			
			case 2:
				input.nextLine();
				removeTask();
				if (taskList.checkIfEmpty())
					return;
				break;
				
			default:
				if (choice != 0)
					AllTxt.optionNotAvailable();
				break;
		
			}
			
		} while  (choice != 0);
		
	}
	
	private static void allTasks() {
		
		if (taskList.checkIfEmpty()) {
			AllTxt.noCreatedTask();
			return;
		}
		
		int choice;
		do {
			
			AllTxt.allTask();
			taskList.listOfAllTasks();
			AllTxt.optionsList();
			choice = input.nextInt();
			
			switch (choice) {
		
			case 1:
				input.nextLine();
				markAsDone();
				break;
			
			case 2:
				input.nextLine();
				markAsNotDone();
				break;
				
			case 3:
				input.nextLine();
				removeTask();
				if (taskList.checkIfEmpty())
					return;
				break;
				
			default:
				if (choice != 0)
					AllTxt.optionNotAvailable();
				break;
		
			}
			
		} while  (choice != 0);
		
	}
	
	private static void createTaskList() {
		
		AllTxt.createTask();
		String newTaskList;
		do {
			
			taskList = null;
			AllTxt.taskListName();
			newTaskList = input.nextLine();
			for (TaskList tL: tasksList)
				if (newTaskList.equals(tL.getName()))
					taskList = tL;
			if (taskList != null)
				AllTxt.existingTaskList();
			
		} while (taskList != null);
		taskList = new TaskList(newTaskList);
		tasksList.add(taskList);
		AllTxt.successfullyCreated();
		
	}
	
	private static void taskListMenu() {
		
		byte choice;
		do {
			
			AllTxt.taskListMenuTxt();
			choice = input.nextByte();
			
			switch (choice) {
			
			case 1:
				input.nextLine();
				createNewTask();
				break;
				
			case 2:
				input.nextLine();
				activeTasks();
				break;
				
			case 3:
				input.nextLine();
				finishedTasks();
				break;
				
			case 4:
				allTasks();
				break;
				
			default:
				if (choice != 0)
					AllTxt.optionNotAvailable();
				break;
			
			}
			
		} while (choice != 0);
		
	}
	
	private static void pickExisting() {
		
		if (tasksList.isEmpty()) {
			AllTxt.noCreatedTaskList();
			return;
		}
		AllTxt.pickFromList();
		for (TaskList tL: tasksList) {
			System.out.print((tasksList.indexOf(tL) + 1) + ". " + tL.getName());
			AllTxt.activeTask();
			System.out.println(tL.activeTasks());
		}
		int number;
		do {
			
			taskList = null;
			AllTxt.numberChoice();
			number = input.nextInt();
			number--;
			for (TaskList tL: tasksList)
				if (tasksList.indexOf(tL) == number) {
					taskList = tL;
					break;
				}
			if (taskList == null)
				AllTxt.nameError();
			
		} while (taskList == null);
		taskListMenu();
		
	}
	
	private static boolean yesOrNo() {
		
		AllTxt.removeSelected();
		String choice;
		do {
			
			AllTxt.pickChoice();
			choice = input.nextLine();
			if (choice.equals(YES) || choice.equals(NO))
				break;
			else
				AllTxt.wrongInput();
			
		} while (!(choice.equals(YES)) || !(choice.equals(NO)));
		if (choice.equals(YES))
			return true;
		else
			return false;
		
	}
	
	private static void removeTaskList() {
		
		if (tasksList.isEmpty()) {
			AllTxt.noCreatedTaskList();
			return;
		}
		AllTxt.pickFromList();
		for (TaskList tL: tasksList) {
			System.out.print((tasksList.indexOf(tL) + 1) + ". " + tL.getName());
			AllTxt.activeTask();
			System.out.println(tL.activeTasks());
		}
		int number;
		do {
			
			taskList = null;
			AllTxt.numberChoice();
			number = input.nextInt();
			number--;
			for (TaskList tL: tasksList)
				if (tasksList.indexOf(tL) == number) {
					taskList = tL;
					break;
				}
			if (taskList == null)
				AllTxt.nameError();
			
		} while (taskList == null);
		input.nextLine();
		if (yesOrNo()) {
			AllTxt.removedTaskList();
			tasksList.remove(taskList);
		} else
			return;
		
	}
	
	private static void mainMenu() {
		
		byte choice;
		do {
			
			AllTxt.mainMenuTxt();
			choice = input.nextByte();
			
			switch (choice) {
			
			case  1:
				input.nextLine();
				createTaskList();
				break;
				
			case 2:
				input.nextLine();
				pickExisting();
				break;
				
			case 3:
				input.nextLine();
				removeTaskList();
				break;
				
			default:
				if (choice != 0)
					AllTxt.optionNotAvailable();
				break;
			
			}
			
		} while (choice != 0);
		AllTxt.exit();
		
	}
	
	public static void main(String[] args) {
		
		mainMenu();
		input.close();
		
	}
	
}
