package org.example;

import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TaskAppTest.java
 * <p>
 * Verifies the output of App
 */
public class AppTest {
    private final ByteArrayOutputStream Content = new ByteArrayOutputStream();
    private PrintStream originalOutput;

    /**
     * Redirect System.setOut to outContent before each test.
     */
    @BeforeEach
    void captureOutput() {
        originalOutput = System.out;
        System.setOut(new PrintStream(Content));
    }

    /**
     * Restore original System.setOut and clear buffer after each test.
     */
    @AfterEach
    void restoreOutput() {
        System.setOut(originalOutput);
        Content.reset();
    }

    /**
     * Runs TaskApp and asserts that the first-task message appears,
     * "All tasks:" lists both items
     * "Completed tasks:" lists only the egg task
     * "Incomplete tasks:" lists the other three
     */
    @Test
    void main_shouldPrintFullDemoFlow() {
        TaskApp.main(new String[0]);
        String output = Content.toString();

        assertTrue(output.contains("First task added: Buy milk (completed? false)"));

        assertTrue(output.contains("All tasks:"));
        assertTrue(output.contains("Buy milk"));
        assertTrue(output.contains("Buy eggs"));

        assertTrue(output.contains("Completed tasks:"));
        assertTrue(output.contains("Buy eggs"));

        assertTrue(output.contains("Incomplete tasks:"));
        assertTrue(output.contains("Buy milk"));
        assertTrue(output.contains("Prepare a lesson for CSC 122"));
        assertTrue(output.contains("Sow beet seeds"));

        assertTrue(output.contains("Your todo list is empty."));
    }
}




