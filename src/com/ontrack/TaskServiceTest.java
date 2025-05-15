package com.ontrack;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class TaskServiceTest {

    @Test
    public void testTasksForStudent101() {
        TaskService service = new TaskService();
        List<String> tasks = service.getTasksByStudentId(101);
        assertEquals(2, tasks.size());
        assertTrue(tasks.contains("Task 1"));
        assertTrue(tasks.contains("Task 2"));
    }

    @Test
    public void testTasksForStudent102() {
        TaskService service = new TaskService();
        List<String> tasks = service.getTasksByStudentId(102);
        assertEquals(1, tasks.size());
        assertTrue(tasks.contains("Task 3"));
    }

    @Test
    public void testTasksForUnknownStudent() {
        TaskService service = new TaskService();
        List<String> tasks = service.getTasksByStudentId(999);
        assertTrue(tasks.isEmpty());
    }
}
