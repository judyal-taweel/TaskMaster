package com.android.taskmaster;

public class TaskItem {
    private String title;
    private String body;

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public TaskItem(String title, String body, String state) {
        this.title = title;
        this.body = body;
        this.state=state;
    }

    public TaskItem(String title) {
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
