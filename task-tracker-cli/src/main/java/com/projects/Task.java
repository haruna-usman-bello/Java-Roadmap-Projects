package com.projects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern fieldPattern = Pattern.compile("\"(\\w+)\":\"([^\"]*)\"");
        Matcher matcher = fieldPattern.matcher(jsonContent);
        Map<String, String> fields = new HashMap<>();

        while (matcher.find()) {
            fields.put(matcher.group(1), matcher.group(2));
        }

        if (fields.isEmpty()) {
            return null;
        }

        int id = Integer.parseInt(fields.get("id"));
        String description = fields.get("description");
        Status status = Status.statusFromString(fields.get("status"));
        LocalDateTime createdAt = LocalDateTime.parse(fields.get("createdAt"), formatter);
        LocalDateTime updatedAt = LocalDateTime.parse(fields.get("updatedAt"), formatter);

        Task task = new Task(description);
        task.id = id;
        task.description = description;
        task.status = status;
        task.createdAt = createdAt;
        task.updatedAt = updatedAt;


        if (id > lastId) {
            lastId = id;
        }

        return task;

    }

    public void updateDescription(String newDescription) {
        this.description = newDescription;
    }

    public void markAsDone() {
        this.status = Status.done;
        this.updatedAt = LocalDateTime.now();
    }

    public void markAsInProgress() {
        this.status = Status.inProgress;
        this.updatedAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

}
