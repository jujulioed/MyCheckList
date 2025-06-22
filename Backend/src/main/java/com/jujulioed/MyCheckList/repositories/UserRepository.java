package com.jujulioed.MyCheckList.repositories;

import com.jujulioed.MyCheckList.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);
    List<User> findAll(int size, int offset);
    Integer save(User user);
    Integer update(User user);
    Integer delete(Long id);
}
