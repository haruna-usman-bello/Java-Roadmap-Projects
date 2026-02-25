package com.projects;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TaskManager {
    private final Path filePath = Path.of("./task-tracker-cli/src/main/resources/tasks.json");
    private final List<Task> tasks;

    public TaskManager() {
        this.tasks = loadTasks();
    }

    public List<Task> loadTasks(){
        List<Task> storeTasks = new ArrayList<>();

        if(!Files.exists(filePath)){
            return new ArrayList<>();
        }

        try {
            String jsonFileContent = Files.readString(filePath);
            String[] tasksArray = jsonFileContent.replace("[", "").replace("]", "").split("},");

            for(String task : tasksArray) {
                if (!task.endsWith("}")) {
                    task = task + "}";
                    storeTasks.add(Task.fromJsonString(task));
                }else {
                    storeTasks.add(Task.fromJsonString(task));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return storeTasks;
    }

    public void saveTasks(){
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for(int i = 1; i <= tasks.size(); i++){
            sb.append(tasks.get(i - 1).toJsonString());
            if(i != tasks.size()){
                sb.append(",\n");
            }
        }
        sb.append("\n]");
        String jsonString = sb.toString();

        try {
            Files.writeString(filePath,jsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("Task added successfully (ID: " + task.getId() + ")");
    }

    public void deleteTask(String id) {
        Task task = findTaskById(id).orElseThrow(() -> new RuntimeException("Task with id " + id + " not found"));
        tasks.remove(task);
        System.out.println("Task deleted successfully (ID: " + id + ")");

    }

    public Optional<Task> findTaskById(String id) {
       return  tasks.stream().filter(task -> task.getId() == Integer.parseInt(id)).findFirst();
    }

}
