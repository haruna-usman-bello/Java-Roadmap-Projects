package com.projects;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
                task = task.trim();
                if (task.isEmpty()) {
                    continue;
                }

                if (!task.endsWith("}")) {
                    task = task + "}";
                }

                try {
                    Task parsed = Task.fromJsonString(task);
                    if (parsed != null) {
                        storeTasks.add(parsed);
                    }
                } catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return storeTasks;
    }

    public void saveTasks(){
        List<Task> validTasks = tasks.stream().filter(Objects::nonNull).toList();
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for(int i = 1; i <= validTasks.size(); i++){
            sb.append(validTasks.get(i - 1).toJsonString());
            if(i != validTasks.size()){
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

    public void updateTask(String id, String description) {
        Task task = findTaskById(id).orElseThrow(() -> new RuntimeException("No task found with id: " + id));
        task.updateDescription(description);
        System.out.println("Task updated successfully (ID: " + task.getId() + ")");
    }

    public void deleteTask(String id) {
        Task task = findTaskById(id).orElseThrow(() -> new RuntimeException("Task with id " + id + " not found"));
        tasks.remove(task);
        System.out.println("Task deleted successfully (ID: " + id + ")");

    }

    public void listTasks(String type){
        for(Task task : tasks){
            if (task == null) {
                continue;
            }
            String status = task.getStatus().toString();
            if ( type.equals("All") || status.equals(type)) {
                System.out.println(task.toJsonString());
            }
        }
    }

    public void markAsDone(String id) {
        Task task = findTaskById(id).orElseThrow(() -> new RuntimeException("Task with id " + id + " not found"));
        task.markAsDone();
        System.out.println("Task with id " + task.getId() + " has been marked as done");
    }

    public void markAsInProgress(String id) {
        Task task = findTaskById(id).orElseThrow(() -> new RuntimeException("Task with id " + id + " not found"));
        task.markAsInProgress();
        System.out.println("Task with id " + task.getId() + " has been marked as in-progress");

    }

    public Optional<Task> findTaskById(String id) {
       return  tasks.stream()
               .filter(task -> task != null && task.getId() == Integer.parseInt(id))
               .findFirst();
    }

}
