package com.projects;

import static java.awt.ComponentOrientation.UNKNOWN;

public  enum Status {
    todo,
    inProgress,
    done;


    public static Status statusFromString(String value) {
        try {
            return Status.valueOf(value.toUpperCase());
        }catch (IllegalArgumentException e) {
            return Status.todo;
        }
    }


}
