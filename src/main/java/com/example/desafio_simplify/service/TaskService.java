package com.example.desafio_simplify.service;


import com.example.desafio_simplify.dto.TaskRequestDTO;
import com.example.desafio_simplify.dto.TaskResponseDTO;
import com.example.desafio_simplify.entities.TaskEntity;
import com.example.desafio_simplify.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskResponseDTO create(TaskRequestDTO taskRequestDTO) {

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setNome(taskRequestDTO.getNome());
        taskEntity.setDescricao(taskRequestDTO.getDescricao());
        taskEntity.setPrioridade(taskRequestDTO.getPrioridade());
        taskRepository.save(taskEntity);
        return mapToDTO(taskEntity);
    }

    public List<TaskResponseDTO> getAllTasks() {
        return taskRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public TaskResponseDTO getTaskById(Long id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        return mapToDTO(taskEntity);
    }

    public TaskResponseDTO updateTask(Long id, TaskRequestDTO taskRequestDTO) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task não encontrada"));
        taskEntity.setNome(taskRequestDTO.getNome());
        taskEntity.setDescricao(taskRequestDTO.getDescricao());
        taskEntity.setPrioridade(taskRequestDTO.getPrioridade());
        taskEntity.setRealizado(taskRequestDTO.isRealizado());
        taskRepository.save(taskEntity);
        return mapToDTO(taskEntity);

    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    private TaskResponseDTO mapToDTO(TaskEntity taskEntity) {
        TaskResponseDTO taskResponseDTO = new TaskResponseDTO();

        taskResponseDTO.setId(taskEntity.getId());
        taskResponseDTO.setNome(taskEntity.getNome());
        taskResponseDTO.setDescricao(taskEntity.getDescricao());
        taskResponseDTO.setRealizado(taskEntity.isRealizado());
        taskResponseDTO.setPrioridade(taskEntity.getPrioridade());

        return taskResponseDTO;
    }


}
