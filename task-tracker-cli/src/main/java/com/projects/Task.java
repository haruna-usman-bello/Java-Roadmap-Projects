package com.projects;

import java.util.Arrays;

public class Task {

    private int id ;
    private String description;
    private Status status;

    public Task(int id, String description, Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public String toJsonString() {
        return "{\"id\":" + id + ", \"description\":\"" + description.strip() + "\", \"status\":\"" + status.toString() + "\"}";
    }


    public static Task fromJsonString(String jsonContent) {
        jsonContent = jsonContent.replace("{", "").replace("}", "").replace("\"", "");

        String[] jsonTasks = jsonContent.split(",");

        int id = Integer.parseInt(jsonTasks[0].split(":")[1]);
        String description = jsonTasks[1].split(":")[1];
        Status status = Status.statusFromString(jsonTasks[2].split(":")[1]);

        Task task = new Task(id, description, status);
        task.id = id;
        task.description = description;
        task.status = status;

        return task;

    }

}
