package dev.backend.Taskmanagement.repository;

import dev.backend.Taskmanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
