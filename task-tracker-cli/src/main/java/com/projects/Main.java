package com.projects;

import java.util.Arrays;

public class Main {
    static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        boolean shouldSave = false;
        if(args.length < 1) {
            System.out.println("Usage: task-cli <command> [arguments]");
            return;

        }

        String command = args[0];


        switch (command) {
            case "add":
                if(args.length < 2) {
                    System.out.println("Usage: task-cli <command> <task-description>");
                    return;
                }

                taskManager.addTask(args[1]);
                shouldSave = true;
                break;
            case "delete":
                if(args.length < 2) {
                    System.out.println("Usage: task-cli <command> <task-id>");
                    return;
                }
                try {
                taskManager.deleteTask(args[1]);
                }
                catch(Exception e) {
                    System.out.println(e.getMessage());
                }

                shouldSave = true;
                break;
            case "update":
                if(args.length < 2) {
                    System.out.println("Usage: task-cli <command> <task-id> <task-description>");
                    return;
                }
                try {
                taskManager.updateTask(args[1], args[2]);
                }
                catch(Exception e) {
                    System.out.println(e.getMessage());
                }
                shouldSave = true;
                break;
            case "list":
                if(args.length < 2) {
                    taskManager.listTasks("All");
                }else {
                    Status status = Status.statusFromString(args[1]);
                    taskManager.listTasks(status.toString());

                }

                break;
            case "mark-done":
                if(args.length < 2) {
                    System.out.println("Usage: task-cli <command>-<task-status> <task-id>");
                    return;
                }
                try {

                    taskManager.markAsDone(args[1]);
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                shouldSave = true;
                break;
            case "mark-in-progress":
                if(args.length < 2) {
                    System.out.println("Usage: task-cli <command>-<task-id>");
                    return;
                }
                try {
                taskManager.markAsInProgress(args[1]);
                }
                catch(Exception e) {
                    System.out.println(e.getMessage());
                }
                shouldSave = true;
                break;
            default:
                System.out.println("Unknown command");
        }
        if (shouldSave) {
            taskManager.saveTasks();
        }
    }
}





