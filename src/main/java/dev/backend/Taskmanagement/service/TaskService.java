package dev.backend.Taskmanagement.service;
import dev.backend.Taskmanagement.model.Task;
import dev.backend.Taskmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {


    private final TaskRepository taskRepository;
    TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(Task task) {
       task.setCompleted(false);
       return taskRepository.save(task);
    }

    public Task updateTask(int id) {
        Task task = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"));
        task.setCompleted(!task.isCompleted());
        return taskRepository.save(task);
    }

    public void deleteTask(int id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        taskRepository.delete(task);
    }
}
