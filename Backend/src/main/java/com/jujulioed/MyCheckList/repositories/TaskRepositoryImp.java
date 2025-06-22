package com.jujulioed.MyCheckList.repositories;

import com.jujulioed.MyCheckList.models.Task;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class TaskRepositoryImp implements TaskRepository {
    private final JdbcClient jdbcClient;

    @Override
    public Optional<Task> findTaskById(Long taskId) {
        return this.jdbcClient
                .sql("SELECT FROM tasks WHERE id = :task_id")
                .param("task_id", taskId)
                .query(Task.class)
                .optional();
    }

    @Override
    public List<Task> findTasksByUserId(int size, int offset, Long id) {
        return this.jdbcClient
                .sql("SELECT FROM tasks WHERE user_id = :id LIMIT :size OFFSET :offset")
                .param("id", id)
                .param("size", size)
                .param("offset", offset)
                .query(Task.class)
                .list();
    }

    @Override
    public Integer save(Task task) {
        return jdbcClient
                .sql("INSERT INTO tasks (name, description, user_id, done, created_date) VALUES (:name, :description, :user_id, :done, created_date)")
                .param("name", task.getName())
                .param("description", task.getDescription())
                .param("user_id", task.getUserId())
                .param("done", task.getDone())
                .param("created_date", task.getCreatedDate())
                .update();
    }

    @Override
    public Integer update(Task task) {
        return jdbcClient
                .sql("""
                        UPDATE tasks SET
                        name = :name,
                        description = :description,
                        user_id = :user_id,
                        done = :done,
                        created_date = :created_date,
                        finished_at = :finished_at
                        WHERE id = :id;
                        """)
                .param("name", task.getName())
                .param("description", task.getDescription())
                .param("user_id", task.getUserId())
                .param("done", task.getDone())
                .param("created_date", task.getCreatedDate())
                .param("finished_at", task.getFinishedAt())
                .param("id", task.getId())
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM tasks WHERE id = :id")
                .param("id", id)
                .update();
    }
}
