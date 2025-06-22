package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * TaskList.java
 * <p>
 * Manages a collection of Task objects.
 *
 */
public class TaskList {
    /** Internal storage of tasks. */
    private final List<Task> tasks = new ArrayList<>();

    /**
     * Create and store a new Task with the given description.
     *
     * @param description the text of the new to-do item
     * @return the newly created Task object
     */
    public Task createNewTask(String description) {
        Task t = new Task(description);
        tasks.add(t);
        return t;
    }

    /**
     * Mark the task identified by the given value as complete.
     * If no appropriate task is found, prints an error message.
     *
     * @param value the unique value of the task to mark complete
     */
    public void complete(int value) {
        for (Task t : tasks) {
            if (t.getValue() == value) {
                t.markAsComplete();
                return;
            }
        }
        // no matching task found
        System.out.println("No task found with value " + value);
    }

    /**
     * Print all tasks, both completed and incomplete.
     */
    public void all() {
        if (tasks.isEmpty()) {
            System.out.println("Your todo list is empty.");
            return;
        }

        System.out.println("All tasks:");
        for (Task t : tasks) {
            System.out.println("  " + t);
        }
    }

    /**
     * Print only the completed tasks.
     * If none are completed, prints a placeholder.
     */
    public void complete() {
        System.out.println("Completed tasks:");
        boolean found = false;

        // list tasks whose completed flag is true
        for (Task t : tasks) {
            if (t.isCompleted()) {
                System.out.println("  " + t);
                found = true;
            }
        }

        if (!found) {
            System.out.println("  (none)");
        }
    }

    /**
     * Print only the incomplete tasks.
     * If all tasks are completed, prints a placeholder.
     */
    public void incomplete() {
        System.out.println("Incomplete tasks:");
        boolean found = false;

        // list tasks whose completed flag is false
        for (Task t : tasks) {
            if (!t.isCompleted()) {
                System.out.println("  " + t);
                found = true;
            }
        }

        if (!found) {
            System.out.println("  (none)");
        }
    }

    /**
     * Remove every task from the list.
     */
    public void clear() {
        tasks.clear();
    }
}








