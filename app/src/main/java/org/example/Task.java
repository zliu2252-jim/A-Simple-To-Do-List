package org.example;

/**
 * Task.java
 * </p>
 * Represents a single to-do program.
 * Each Task has a unique value, a text description and
 * a completed signal indicating whether the program is finished.
 * </p>
 * New tasks start off not completed. Call markAsComplete() to mark them done.
 */
public class Task {
    /** Counter used to generate the unique values for each Task. */
    private static int nextValue = 1;

    /** About the unique value for the task. */
    private final int value;

    /** The description of this Task. */
    private final String description;

    /** True if this Task has been marked complete. */
    private boolean completed;

    /**
     * Constructs a new Task.
     * The Task is initially not completed.
     *
     * @param description text describing things need to be done
     */
    public Task(String description) {
        this.value = nextValue++;
        this.description = description;
        this.completed = false;
    }

    /**
     * Returns the unique value of this Task.
     *
     * @return the value of the task
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the description of this Task.
     *
     * @return the text provided at construction
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns whether this Task has been completed.
     *
     * @return true if completed, false otherwise
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Marks this Task as complete.
     */
    public void markAsComplete() {
        this.completed = true;
    }

    /**
     * Returns the summary of this Task.
     *
     * @return summary: value, description, and completed flag
     */
    public String toString() {
        return "Task value=" + value
                + ", description='" + description + "'"
                + ", completed=" + completed;
    }
}