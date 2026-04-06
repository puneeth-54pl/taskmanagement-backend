package dev.backend.Taskmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;
    private boolean completed;

    public  Task() {}



    public int getId() { return id; }
    public String getText() { return text; }
    public boolean isCompleted() { return completed; }

    public void setText(String text) { this.text = text; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
