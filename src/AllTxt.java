
public class AllTxt {

	public static void mainMenuTxt() {
		System.out.print("____________________\n\n"
				+ "---MAIN MENU---\n\n"
				+ "1. Create Task List\n"
				+ "2. Pick Existing\n"
				+ "3. Remove Task List\n\n"
				+ "0. Exit\n\n"
				+ "Your Choice: ");
	}
	
	
	public static void taskListMenuTxt() {
		System.out.print("____________________\n\n"
				+ "---TASK LIST MENU---\n\n"
				+ "1. Create New Task\n"
				+ "2. Active Tasks\n"
				+ "3. Finished Tasks\n"
				+ "4. All Tasks\n\n"
				+ "0. Return\n\n"
				+ "Your Choice: ");
	}
	
	public static void newTask() {
		System.out.print("____________________\n\n"
				+ "--CREATE NEW TASK--\n\n");
	}
	
	public static void taskName() {
		System.out.print("Task Name: ");
	}
	
	public static void nameError() {
		System.out.println("\n**Task With Entered Name Already Existing!**");
	}
	
	public static void numberChoice() {
		System.out.print("\nType Number Of Task: ");
	}
	
	public static void doesntExist() {
		System.out.println("\n**Task With Selected Number Doesn't Exist!**");
	}
	
	public static void noActiveTask() {
		System.out.println("\n**There Are No Active Tasks**");
	}
	
	public static void noCreatedTask() {
		System.out.println("\n**There Are No Created Tasks**");
	}
	
	public static void noCreatedTaskList() {
		System.out.println("\n**There Are No Created Task Lists**");
	}
	
	public static void optionsList() {
		System.out.print("____________________\n\n"
				+ "--OPTIONS--\n\n"
				+ "1. Mark As Done\n"
				+ "2. Remove Task\n\n"
				+ "0. Return\n\n"
				+ "Your Choice: ");
	}
	
	public static void optionNotAvailable() {
		System.out.println("\n**Selected Option Is Not Available**");
	}
	
	public static void noFinishedTask() {
		System.out.println("\n**There Are No Finished Tasks**");
	}
	
	public static void allTask() {
		System.out.print("____________________\n\n"
				+ "--ALL TASKS--\n\n");
	}
	
	public static void createTask() {
		System.out.print("____________________\n\n"
				+ "--CREATE TASK LIST--\n\n");
	}
	
	public static void taskListName() {
		System.out.print("Task List Name: ");
	}
	
	public static void existingTaskList() {
		System.out.println("\n**Task List With Entered Name Already Existing!**\n");
	}
	
	public static void successfullyCreated() {
		System.out.println("\n**Successfully Created New Task List!**");
	}
	
	public static void pickFromList() {
		System.out.print("____________________\n"
				+ "--PICK FROM THE LIST--\n\n"
				+ "All Task Lists:\n\n");
	}
	
	public static void activeTask() {
		System.out.print(" - Active Tasks: ");
	}
	
	public static void removeSelected() {
		System.out.print("\nAre You Sure You Want To Remove Selected??"
				+ "All Data Will Be Lost!**\n\n");
	}
	
	public static void pickChoice() {
		System.out.print("Your Choice (yes/no): ");
	}
	
	public static void wrongInput() {
		System.out.println("\n**Wrong Input**\n");
	}
	
	public static void removedTaskList() {
		System.out.println("\n**Task List Successfully Removed**\n");
	}
	
	public static void exit() {
		System.out.println("\n**You Have Exited TODO Manager**");
	}
	
}
