package com.ontrack;

import java.util.*;

public class TaskService {

    public List<String> getTasksByStudentId(int studentId) {
        Map<Integer, List<String>> taskMap = new HashMap<>();

        taskMap.put(101, Arrays.asList("Task 1", "Task 2"));
        taskMap.put(102, Arrays.asList("Task 3"));

        return taskMap.getOrDefault(studentId, new ArrayList<>());
    }
}
