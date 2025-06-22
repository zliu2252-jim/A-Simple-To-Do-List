package org.example;

/**
 * TaskApp.java
 * </p>
 * Demonstrates how to use TaskList and Task to manage
 * a simple to-do list program.
 */
public class App {
    /**
     * Entry point for the Task demo.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a new to-do list
        TaskList list = new TaskList();

        // Add four tasks
        Task t1 = list.createNewTask("Buy milk");
        Task t2 = list.createNewTask("Buy eggs");
        list.createNewTask("Prepare a lesson for CSC 122");
        list.createNewTask("Sow beet seeds");

        // Use t1: print the description and status
        System.out.println("First task added: "
                + t1.getDescription()
                + " (completed? "
                + t1.isCompleted()
                + ")");

        // Mark “Buy eggs” as complete by its value
        list.complete(t2.getValue());

        // Print all tasks (both complete and incomplete)
        list.all();

        // Print only the completed tasks
        list.complete();

        // Print only the incomplete tasks
        list.incomplete();

        // Remove all tasks from the list
        list.clear();

        // Verify the list is now empty
        list.all();
    }
}






