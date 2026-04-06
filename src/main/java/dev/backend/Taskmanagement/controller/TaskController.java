package dev.backend.Taskmanagement.controller;
import dev.backend.Taskmanagement.model.Task;
import dev.backend.Taskmanagement.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {

    private final TaskService taskService;

    // Constructor injection
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {

        return ResponseEntity.ok(taskService.getTasks());
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task created = taskService.addTask(task);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id) {
        try {
            return ResponseEntity.ok(taskService.updateTask(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        try {
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build(); // 204
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // 404
        }
    }
}