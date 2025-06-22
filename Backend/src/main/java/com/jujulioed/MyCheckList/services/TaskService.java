package com.jujulioed.MyCheckList.services;

import com.jujulioed.MyCheckList.exceptions.ResourceNotFound;
import com.jujulioed.MyCheckList.models.Task;
import com.jujulioed.MyCheckList.models.dtos.TaskDTO;
import com.jujulioed.MyCheckList.models.dtos.TaskUpdateDTO;
import com.jujulioed.MyCheckList.models.dtos.TaskUpdateStatusDTO;
import com.jujulioed.MyCheckList.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> findAllTaksByUserId(int page, int size, Long userId) {
        int offset = (page - 1) * size;
        return this.taskRepository.findTasksByUserId(size, offset, userId);
    }

    public void insertTask(TaskDTO taskDTO) {
        Task task = new Task(taskDTO);
        this.taskRepository.save(task);
    }

    public void updateTask(TaskUpdateDTO taskUpdateDTO, Long id) {
        Task existingTask = taskRepository.findTaskById(id)
                .orElseThrow(() -> new ResourceNotFound("Could not find this task"));

        existingTask.setName(taskUpdateDTO.name());
        existingTask.setDescription(taskUpdateDTO.description());

        taskRepository.update(existingTask);
    }

    public void updateTaskStatus(TaskUpdateStatusDTO taskUpdateStatusDTO, Long id){
        Task existingTask = taskRepository.findTaskById(id)
                .orElseThrow(() -> new ResourceNotFound("Could not find this task"));

        existingTask.setDone(taskUpdateStatusDTO.status());
        if (taskUpdateStatusDTO.status()) {
            existingTask.setFinishedAt(LocalDate.now());
        } else {
            existingTask.setFinishedAt(null);
        }
    }

    public void deleteTask(Long id) {
        Task existingTask = taskRepository.findTaskById(id)
                .orElseThrow(() -> new ResourceNotFound("Could not find this task"));

        this.taskRepository.delete(id);
    }

}
