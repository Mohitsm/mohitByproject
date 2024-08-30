package com.mohit_project.serviceIpml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit_project.Entity.Task;
import com.mohit_project.Repositry.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task saveTask(Task task) {
    	task.setStatus("Task Assign");
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> getTasksByEmployeeId(String employeeId) {
        return taskRepository.findByEmployeeId(employeeId);
    }
}
