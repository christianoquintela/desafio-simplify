package com.example.desafio_simplify.controller;

import com.example.desafio_simplify.dto.TaskRequestDTO;
import com.example.desafio_simplify.dto.TaskResponseDTO;
import com.example.desafio_simplify.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/task")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/create")
    public ResponseEntity<TaskResponseDTO> create(@RequestBody TaskRequestDTO taskDTO) {
        TaskResponseDTO taskResponseDTO = service.create(taskDTO);
        return ResponseEntity.status(201).body(taskResponseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
//        System.out.println(service.getAllTasks());
        return ResponseEntity.status(200).body(service.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getById(@PathVariable Long id) {
        try {
            TaskResponseDTO taskResponseDTO = service.getTaskById(id);
            return ResponseEntity.status(200).body(taskResponseDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long id, @RequestBody TaskRequestDTO reqDTO) {
        TaskResponseDTO taskResponseDTO = service.updateTask(id, reqDTO);
        return ResponseEntity.ok(taskResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
