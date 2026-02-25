package com.projects;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

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

    public void listTasks(){
        StringBuilder sb = new StringBuilder();

        for(Task task : tasks){
            sb.append(task.toJsonString());
            sb.append("\n");
        }
        String jsonString = sb.toString();
        System.out.println(jsonString);
    }

}
