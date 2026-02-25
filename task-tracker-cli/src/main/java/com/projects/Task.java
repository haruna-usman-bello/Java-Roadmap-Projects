package com.projects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

public class Task {
    private static int lastId = 0;
    private int id ;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(String description) {
        this.id = ++lastId;
        this.description = description;
        this.status = Status.todo;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    private  static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public String toJsonString() {
        return "{\"id\":\"" + id + "\", \"description\":\"" + description.strip() + "\", \"status\":\"" + status.toString() +
                "\", \"createdAt\":\"" + createdAt.format(formatter) + "\", \"updatedAt\":\"" + updatedAt.format(formatter) + "\"}";
    }


    public static Task fromJsonString(String jsonContent) {
        jsonContent = jsonContent.replace("{", "").replace("}", "").replace("\"", "");

        String[] jsonTasks = jsonContent.split(",");

        if (jsonTasks.length != 2) {

        }

        int id = Integer.parseInt(jsonTasks[0].split(":")[1]);
        String description = jsonTasks[1].split(":")[1];
        Status status = Status.statusFromString(jsonTasks[2].split(":")[1]);

        Task task = new Task(description);
        task.id = id;
        task.description = description;
        task.status = status;

        return task;

    }

    public void updateDescription(String newDescription) {
        this.description = newDescription;
    }

    public int getId() {
        return id;
    }

}
