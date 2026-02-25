package com.projects;

import java.util.Arrays;

public class Main {
    static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
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

                break;
            case "list":
                System.out.println("Listing tasks");
                break;
            default:
                System.out.println("Unknown command");
        }
        taskManager.saveTasks();

        }
}






