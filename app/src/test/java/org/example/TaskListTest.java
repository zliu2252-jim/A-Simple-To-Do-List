package org.example;

import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TaskListTest.java
 * <p>
 * JUnit tests for the TaskList class.
 * The test verifies new tasks are created with correct description and incomplete status,
 * completing by a valid value marks only that task complete,
 * completing by an invalid value prints an error, and
 * the full flow of all(), complete(), incomplete(), and clear()
 */
public class TaskListTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut;

    /**
     * Redirect System.setOut to outContent before each test.
     */
    @BeforeEach
    void setUpStreams() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Restore original System.setOut and clear buffer after each test.
     */
    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        outContent.reset();
    }

    /**
     * Test the createNewTask()
     */
    @Test
    void createNewTask_shouldReturnTaskWithDescription() {
        TaskList list = new TaskList();
        Task t = list.createNewTask("Buy the object");
        assertEquals("Buy the object", t.getDescription());
        assertFalse(t.isCompleted());
    }

    /**
     * Test that complete value marks only the matching
     * task complete when given a valid value.
     */
    @Test
    void complete_byValidValue_shouldMarkThatTaskComplete() {
        TaskList list = new TaskList();
        Task t1 = list.createNewTask("Pay bills");
        Task t2 = list.createNewTask("Send a mail");

        list.complete(t1.getValue());

        assertTrue(t1.isCompleted());
        assertFalse(t2.isCompleted(), "Other tasks should remain incomplete");
    }

    /**
     * Test that complete value with no matching task
     */
    @Test
    void complete_byInvalidValue_shouldPrintError() {
        TaskList list = new TaskList();
        list.complete(999);
        String out = outContent.toString();
        assertTrue(out.contains("No task found with value"), "Should notify when value not found");
    }

    /**
     * Test overall: mark one task complete, verify all(), complete(), incomplete() outputs,
     * clear the list and verify empty-list message
     */
    @Test
    void all_complete_incomplete_andClear_flow() {
        TaskList list = new TaskList();
        Task a = list.createNewTask("A");
        Task b = list.createNewTask("B");

        list.complete(a.getValue());
        assertFalse(b.isCompleted(), "Task B should still be incomplete");

        list.all();
        String allOut = outContent.toString();
        assertTrue(allOut.contains("All tasks:"), "Should label all");
        assertTrue(allOut.contains("A"), "Should list A");
        assertTrue(allOut.contains("B"), "Should list B");

        outContent.reset();
        list.complete();
        String compOut = outContent.toString();
        assertTrue(compOut.contains("Completed tasks:"), "Should label completed");
        assertTrue(compOut.contains("A"), "Should list only A");

        outContent.reset();
        list.incomplete();
        String incOut = outContent.toString();
        assertTrue(incOut.contains("Incomplete tasks:"), "Should label incomplete");
        assertTrue(incOut.contains("B"), "Should list only B");

        outContent.reset();
        list.clear();
        list.all();
        assertTrue(outContent.toString().contains("empty"), "After clear, all() should say empty");
    }
}








