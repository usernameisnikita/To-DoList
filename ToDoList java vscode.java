import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String description;

    Task(String description) {
        this.description = description;
    }

    String getDescription() {
        return description;
    }

    void editDescription(String newDescription) {
        this.description = newDescription;
    }
}

class TodoTask extends Task {
    TodoTask(String description) {
        super(description);
    }
}

class DoneTask extends Task {
    DoneTask(String description) {
        super(description);
    }
}

public class ToDoList {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Todo List Options:");
            System.out.println("1. Add Task");
            System.out.println("2. Display All Tasks");
            System.out.println("3. Edit Task");
            System.out.println("4. Mark Task as Done");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the task description: ");
                    String taskDescription = scanner.nextLine();
                    TodoTask newTask = new TodoTask(taskDescription);
                    tasks.add(newTask);
                    System.out.println("Task added to the list.");
                    break;
                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks in the list.");
                    } else {
                        System.out.println("All Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i).getDescription());
                        }
                    }
                    break;
                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks in the list to edit.");
                    } else {
                        System.out.print("Enter the task number to edit: ");
                        int taskNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                            System.out.print("Enter the new task description: ");
                            String newDescription = scanner.nextLine();
                            tasks.get(taskNumber - 1).editDescription(newDescription);
                            System.out.println("Task edited successfully.");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    break;
                case 4:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks in the list to mark as done.");
                    } else {
                        System.out.print("Enter the task number to mark as done: ");
                        int taskNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                            Task task = tasks.remove(taskNumber - 1);
                            DoneTask doneTask = new DoneTask(task.getDescription());
                            tasks.add(doneTask);
                            System.out.println("Task marked as done.");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
