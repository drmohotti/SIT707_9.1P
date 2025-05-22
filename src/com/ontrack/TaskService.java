package com.ontrack;

import java.util.*;

public class TaskService {

    private Map<Integer, List<String>> taskMap = new HashMap<>();
    private Map<String, String> feedbackMap = new HashMap<>();

    // Constructor with sample data
    public TaskService() {
        taskMap.put(101, new ArrayList<>(Arrays.asList("Task 1", "Task 2")));
        taskMap.put(102, new ArrayList<>(Arrays.asList("Task 3")));

        feedbackMap.put("101_Task 1", "Well done!");
        feedbackMap.put("101_Task 2", "Needs improvement.");
    }

    // Existing method from 9.1P
    public List<String> getTasksByStudentId(int studentId) {
        return taskMap.getOrDefault(studentId, new ArrayList<>());
    }

    // New method: Simulate task submission
    public boolean submitTask(int studentId, String taskTitle) {
        taskMap.putIfAbsent(studentId, new ArrayList<>());
        return taskMap.get(studentId).add(taskTitle);
    }

    // New method: Get feedback for a task
    public String getFeedback(int studentId, String taskTitle) {
        return feedbackMap.getOrDefault(studentId + "_" + taskTitle, "No feedback available.");
    }

    // New method: Simulate deleting a task
    public boolean deleteTask(int studentId, String taskTitle) {
        List<String> tasks = taskMap.get(studentId);
        if (tasks != null) {
            return tasks.remove(taskTitle);
        }
        return false;
    }
}
