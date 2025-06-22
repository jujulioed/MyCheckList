package com.jujulioed.MyCheckList.services;

import com.jujulioed.MyCheckList.models.User;
import com.jujulioed.MyCheckList.models.dtos.UserDTO;
import com.jujulioed.MyCheckList.models.dtos.UserUpdateDTO;
import com.jujulioed.MyCheckList.repositories.UserRepository;
import com.jujulioed.MyCheckList.exceptions.ResourceNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAllUsers(int page, int size) {
        int offset = (page - 1) * size;
        return this.userRepository.findAll(size, offset);
    }

    public User findUserById(Long id) {
        return this.userRepository
                .findById(id).orElseThrow(() -> new ResourceNotFound("Could not find the user"));
    }

    public void updateUser(UserUpdateDTO user, Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Could not find the user"));

        existingUser.setEmail(user.email());
        existingUser.setName(user.name());

        if(userRepository.update(existingUser) == 0) {
            throw  new ResourceNotFound("The user with the id" + existingUser.getId() + " is not registered in the database");
        }
    }

    public void insertUser(UserDTO userDTO) {
        User user = new User(userDTO);
        userRepository.save(user);
    }


    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Could not find this user"));
        userRepository.delete(id);

    }

}
