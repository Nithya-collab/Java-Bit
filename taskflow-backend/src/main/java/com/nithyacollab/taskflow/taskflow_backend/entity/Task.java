package com.nithyacollab.taskflow.taskflow_backend.entity;

public class Task {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;

    public Task(String title, String description){
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Title cannot be null or empty.");
        } 
        this.title = title;
        this.description = description;
        this.status = TaskStatus.TODO;
    }

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;      
    }


    public String getDescription(){
        return description;
    }

    public TaskStatus getStatus(){
        return status;
    }

    public void startTask(){
        if(this.status != TaskStatus.TODO){
            throw new IllegalStateException("Task must be in TODO state to be started. ");
        }

     this.status = TaskStatus.IN_PROGRESS;
    }

    public void completeTask(){
        if(this.status != TaskStatus.IN_PROGRESS){
            throw new IllegalStateException("Task must be in progress to be completed. ");
        }   
     this.status = TaskStatus.DONE;
    }

}
