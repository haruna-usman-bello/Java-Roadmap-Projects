package com.projects;

public class Task {

    private final int id ;
    private final String description;
    private final Status status;

    public Task(int id, String description, Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public String toJson() {
        return "{\"id\":" + id + ", \"description\":\"" + description.strip() + "\", \"status\":\"" + status.toString() + "\"}";
    }

}
