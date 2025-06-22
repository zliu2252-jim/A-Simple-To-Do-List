package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TaskTest.java
 * <p>
 * Tests for the Task class.
 * <p>
 * The test verities tasks are initialized correctly, markAsComplete () have the
 * completed flag, and each task receives a unique value.
 */
public class TaskTest {

    /**
     * Tests that a new Task stores the provided description, starts incomplete, and
     * has a positive value.
     */
    @Test
    void initialState_shouldHaveDescriptionAndNotCompleted() {
        Task t = new Task("Write unit tests");
        assertEquals("Write unit tests", t.getDescription());
        assertFalse(t.isCompleted(), "New task should start incomplete");
        assertTrue(t.getValue() > 0, "Value should be a positive number");
    }

    /**
     * Tests that calling markAsComplete()
     * sets the completed flag to true.
     */
    @Test
    void markAsComplete_shouldFlipCompletedFlag() {
        Task t = new Task("Do the work");
        assertFalse(t.isCompleted());
        t.markAsComplete();
        assertTrue(t.isCompleted(), "After markAsComplete(), isCompleted() must be true");
    }

    /**
     * Tests that two Task instances receive
     * distinct values.
     */
    @Test
    void idsShouldBeUnique_acrossMultipleInstances() {
        Task a = new Task("A");
        Task b = new Task("B");
        assertNotEquals(a.getValue(), b.getValue(), "Each Task should get a unique Value");
    }
}