package com.ontrack;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class TaskServiceTest {

    // R – Right Result
    @Test
    public void testGetTasksByStudentId_Right() {
        TaskService service = new TaskService();
        List<String> tasks = service.getTasksByStudentId(101);
        assertEquals(2, tasks.size());
        assertTrue(tasks.contains("Task 1"));
        assertTrue(tasks.contains("Task 2"));
    }

    // B – Boundary
    @Test
    public void testGetTasksForEmptyStudent() {
        TaskService service = new TaskService();
        List<String> tasks = service.getTasksByStudentId(999); // no tasks
        assertTrue(tasks.isEmpty());
    }

    // I – Inverse
    @Test
    public void testSubmitThenDeleteTask_Inverse() {
        TaskService service = new TaskService();
        service.submitTask(103, "Task X");
        boolean deleted = service.deleteTask(103, "Task X");
        assertTrue(deleted);
        assertFalse(service.getTasksByStudentId(103).contains("Task X"));
    }

    // C – Cross-check
    @Test
    public void testSubmitAndVerify_CrossCheck() {
        TaskService service = new TaskService();
        service.submitTask(104, "Task Y");
        List<String> tasks = service.getTasksByStudentId(104);
        assertTrue(tasks.contains("Task Y"));
    }

    // E – Error Conditions
    @Test
    public void testSubmitNullTask_Error() {
        TaskService service = new TaskService();
        boolean result = service.submitTask(105, null);
        assertTrue(result);  // This will pass but could be flagged in design
    }

    @Test
    public void testGetFeedbackForInvalidTask_Error() {
        TaskService service = new TaskService();
        String feedback = service.getFeedback(101, "Nonexistent Task");
        assertEquals("No feedback available.", feedback);
    }

    // P – Performance (Simulated via large input)
    @Test
    public void testSubmitMultipleTasks_Performance() {
        TaskService service = new TaskService();
        for (int i = 0; i < 1000; i++) {
            assertTrue(service.submitTask(200, "Task_" + i));
        }
        List<String> tasks = service.getTasksByStudentId(200);
        assertEquals(1000, tasks.size());
    }
}
