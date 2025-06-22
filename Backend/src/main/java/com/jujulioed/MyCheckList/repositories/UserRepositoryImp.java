package com.jujulioed.MyCheckList.repositories;

import com.jujulioed.MyCheckList.models.User;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImp implements UserRepository{
    private final JdbcClient jdbcClient;

    public UserRepositoryImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.jdbcClient
                .sql(   "SELECT * FROM users WHERE id = :id")
                .param("id", id)
                .query(User.class)
                .optional();
    }

    @Override
    public List<User> findAll(int size, int offset) {
        return this.jdbcClient
                .sql("SELECT * FROM users LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(User.class)
                .list();
    }

    @Override
    public Integer save(User user) {
        return this.jdbcClient
                .sql("INSERT INTO users (name, email) VALUES (:name, :email)")
                .param("name", user.getName())
                .param("email", user.getEmail())
                .update();
    }

    @Override
    public Integer update(User user) {
        return this.jdbcClient
                .sql("UPDATE users SET name = :name, email = :email WHERE id = :id")
                .param("name", user.getName())
                .param("email", user.getEmail())
                .param("id", user.getId())
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM users WHERE id = :id")
                .param("id", id)
                .update();
    }
}
