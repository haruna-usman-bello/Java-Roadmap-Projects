package com.projects;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final Path filePath = Path.of("tasks.json");
    private final List<Task> tasks;

    public TaskManager() {
        this.tasks = loadTasks();
    }

    public List<Task> loadTasks(){
        List<Task> storeTasks = new ArrayList<>();

        if(Files.exists(filePath)){
            return new ArrayList<>();
        }
        Task task1 = new Task(1, "Buy an iPhone",  Status.todo);
        Task task2 = new Task(2, "Buy a Samsung",  Status.todo);

        storeTasks.add(task1);
        storeTasks.add(task2);

        return storeTasks;
    }

    public void saveTasks(){
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for(int i = 1; i <= tasks.size(); i++){
            sb.append(tasks.get(i - 1).toJson());
            if(i != tasks.size()){
                sb.append(",\n");
            }
        }
        sb.append("\n]");
        System.out.println(sb.toString());
    }

}
