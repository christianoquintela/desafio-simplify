package com.example.desafio_simplify.converter;

import com.example.desafio_simplify.dto.TaskResponseDTO;
import com.example.desafio_simplify.entities.TaskEntity;
import lombok.*;


@Data
public class Converter {

    public TaskResponseDTO mapToDTO(TaskEntity taskEntity){
        TaskResponseDTO taskResponseDTO = new TaskResponseDTO();
        taskResponseDTO.setNome(taskEntity.getNome());
        taskResponseDTO.setDescricao(taskEntity.getDescricao());
        taskResponseDTO.setRealizado(taskEntity.isRealizado());
        taskResponseDTO.setPrioridade(taskEntity.getPrioridade());
        return taskResponseDTO;
    }
}
