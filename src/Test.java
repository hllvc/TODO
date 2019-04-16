import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	private static Scanner input = new Scanner(System.in);
	private static ArrayList<TaskList> tasksList = new ArrayList<>();
	private static TaskList taskList;
	private static Task task;
	
	private static void mainMenuTxt() {
		
		System.out.print("____________________\n\n"
				+ "---MAIN MENU---\n\n"
				+ "1. Create Task List\n"
				+ "2. Pick Existing\n"
				+ "3. Remove Task List\n\n"
				+ "0. Exit\n\n"
				+ "Your Choice: ");
		
	}
	
	private static void taskListMenuTxt() {
		
		System.out.print("____________________\n\n"
				+ "---TASK LIST MENU---\n\n"
				+ "1. Create New Task\n"
				+ "2. Active Tasks\n"
				+ "3. Finished Tasks\n"
				+ "4. All Tasks\n\n"
				+ "0. Return\n\n"
				+ "Your Choice: ");
		
	}
	
	private static void createNewTask() {
		
		System.out.print("____________________\n\n"
				+ "--CREATE NEW TASK--\n\n");
		String newTask;
		task = null;
		do {
			
			System.out.print("Task Name: ");
			newTask = input.nextLine();
			task = taskList.findTask(newTask);
			if (task != null)
				System.out.println("\n**Task With Entered Name Already Existing!**");
			
		} while (task != null);
		task = new Task(newTask);
		taskList.addToList(task);
		
	}
	
	private static void removeTask() {
		
		int number;
		do {
			
			task = null;
			System.out.print("\nType Number Of Task You Want To Remove: ");
			number = input.nextInt();
			task = taskList.findTask(number);
			if (task == null) {
				System.out.println("\n**Task With Selected Number Doesn't Exist!**");
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
			System.out.print("\nType Number Of Task You Want To Mark As Done: ");
			number = input.nextInt();
			task = taskList.findTask(number);
			if (task == null) {
				System.out.println("\n**Task With Selected Number Doesn't Exist!**");
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
			
			System.out.print("\nType Number Of Task You Want To Mark As Not Done: ");
			number = input.nextInt();
			task = taskList.findTask(number);
			if (task == null) {
				System.out.println("\n**Task With Selected Number Doesn't Exist!**");
				continue;
			}
			taskList.setTaskStatusNotDone(task);
			
			
		} while (task == null);
		return;
		
	}
	
	private static void activeTasks() {
		
		if (!taskList.checkIfHasActive()) {
			System.out.println("\n**There Are No Active Tasks**");
			return;
		}
		
		int choice;
		do {
			
			taskList.checkActiveTasks();
			System.out.print("____________________\n\n"
					+ "--OPTIONS--\n\n"
					+ "1. Mark As Done\n"
					+ "2. Remove Task\n\n"
					+ "0. Return\n\n"
					+ "Your Choice: ");
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
					System.out.println("\n**Selected Option Is Not Available**");
				break;
		
			}
			
		} while  (choice != 0);
	}
	
	private static void finishedTasks() {
		
		if (!taskList.checkIfHasFinished()) {
			System.out.println("\n**There Are No Finished Tasks**");
			return;
		}
		
		int choice;
		do {
			
			taskList.checkFinishedTasks();
			System.out.print("____________________\n\n"
					+ "--OPTIONS--\n\n"
					+ "1. Mark As Not Done\n"
					+ "2. Remove Task\n\n"
					+ "0. Return\n\n"
					+ "Your Choice: ");
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
					System.out.println("\n**Selected Option Is Not Available**");
				break;
		
			}
			
		} while  (choice != 0);
		
	}
	
	private static void allTasks() {
		
		if (taskList.checkIfEmpty()) {
			System.out.println("\n**There Are No Created Tasks**");
			return;
		}
		
		int choice;
		do {
			
			System.out.print("____________________\n\n"
					+ "--ALL TASKS--\n\n");
			taskList.listOfAllTasks();
			System.out.print("____________________\n\n"
					+ "--OPTIONS--\n\n"
					+ "1. Mark As Done\n"
					+ "2. Mark As Not Done\n"
					+ "3. Remove Task\n\n"
					+ "0. Return\n\n"
					+ "Your Choice: ");
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
					System.out.println("\n**Selected Option Is Not Available**");
				break;
		
			}
			
		} while  (choice != 0);
		
	}
	
	private static void createTaskList() {
		
		System.out.print("____________________\n\n"
				+ "--CREATE TASK LIST--\n\n");
		String newTaskList;
		do {
			
			taskList = null;
			System.out.print("Task List Name: ");
			newTaskList = input.nextLine();
			for (TaskList tL: tasksList)
				if (newTaskList.equals(tL.getName()))
					taskList = tL;
			if (taskList != null)
				System.out.println("\n**Task List With Entered Name Already Existing!**\n");
			
		} while (taskList != null);
		taskList = new TaskList(newTaskList);
		tasksList.add(taskList);
		System.out.println("\n**Successfully Created New Task List!**");
		
	}
	
	private static void taskListMenu() {
		
		byte choice;
		do {
			
			taskListMenuTxt();
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
					System.out.println("\n**Selected Option Is Not Available**");
				break;
			
			}
			
		} while (choice != 0);
		
	}
	
	private static void pickExisting() {
		
		if (tasksList.isEmpty()) {
			System.out.println("\n**There Are No Created Task Lists**");
			return;
		}
		System.out.print("____________________\n"
				+ "--PICK FROM THE LIST--\n\n"
				+ "All Task Lists:\n\n");
		for (TaskList tL: tasksList)
			System.out.println((tasksList.indexOf(tL) + 1) + ". " + tL.getName() + " - Active Tasks: " + tL.activeTasks());
		int number;
		do {
			
			taskList = null;
			System.out.print("\nType Number Of List You Want To Access: ");
			number = input.nextInt();
			number--;
			for (TaskList tL: tasksList)
				if (tasksList.indexOf(tL) == number) {
					taskList = tL;
					break;
				}
			if (taskList == null)
				System.out.println("\n**Task List With Entered Name Doesn't Exist!**");
			
		} while (taskList == null);
		taskListMenu();
		
	}
	
	private static boolean yesOrNo() {
		
		System.out.print("\nAre You Sure You Want To Remove Selected??\nAll Data Will Be Lost!**\n\n");
		String choice;
		do {
			
			System.out.print("Your Choice (yes/no): ");
			choice = input.nextLine();
			if (choice.equals("yes") || choice.equals("no"))
				break;
			else
				System.out.println("\n**Wrong Input**\n");
			
		} while (!(choice.equals("yes")) || !(choice.equals("no")));
		if (choice.equals("yes"))
			return true;
		else
			return false;
		
	}
	
	private static void removeTaskList() {
		
		if (tasksList.isEmpty()) {
			System.out.println("\n**There Are No Created Task Lists**");
			return;
		}
		System.out.print("____________________\n"
				+ "--PICK FROM THE LIST--\n\n"
				+ "All Task Lists:\n\n");
		for (TaskList tL: tasksList)
			System.out.println((tasksList.indexOf(tL) + 1) + ". " + tL.getName() + " - Active Tasks: " + tL.activeTasks());
		int number;
		do {
			
			taskList = null;
			System.out.print("\nType Number Of List You Want To Access: ");
			number = input.nextInt();
			number--;
			for (TaskList tL: tasksList)
				if (tasksList.indexOf(tL) == number) {
					taskList = tL;
					break;
				}
			if (taskList == null)
				System.out.println("\n**Task List With Entered Name Doesn't Exist!**");
			
		} while (taskList == null);
		input.nextLine();
		if (yesOrNo()) {
			System.out.println("\n**Task List Successfully Removed**\n");
			tasksList.remove(taskList);
		} else
			return;
		
	}
	
	private static void mainMenu() {
		
		byte choice;
		do {
			
			mainMenuTxt();
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
					System.out.println("\n**Selected Option Is Not Available**");
				break;
			
			}
			
		} while (choice != 0);
		System.out.println("\n**You Have Exited TODO Manager**");
		
	}
	
	public static void main(String[] args) {
		
		mainMenu();
		input.close();
		
	}
	
}
