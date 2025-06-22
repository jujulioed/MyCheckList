package com.jujulioed.MyCheckList.repositories;

import com.jujulioed.MyCheckList.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Optional<Task> findTaskById(Long taskId);
    List<Task> findTasksByUserId(int size, int offset, Long id);
    Integer save(Task task);
    Integer update(Task task);
    Integer delete(Long id);
}
