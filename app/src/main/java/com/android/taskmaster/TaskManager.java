package com.android.taskmaster;

import com.amplifyframework.datastore.generated.model.TaskItem;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static TaskManager instance=null;
    private List<TaskItem> taskLists = new ArrayList<>();


    private TaskManager() {
    }

    public static TaskManager getInstance(){
        if (instance == null) {
            instance = new TaskManager();
        }

        return instance;

    }
    public void setData(List<TaskItem> data) {
        taskLists = data;
    }

    public List<TaskItem> getData() {
        return taskLists;
    }
}
