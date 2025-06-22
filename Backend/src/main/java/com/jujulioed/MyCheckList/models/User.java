package com.jujulioed.MyCheckList.models;
import com.jujulioed.MyCheckList.models.dtos.UserDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    private Long id;
    private String name;
    private String email;

    public User(UserDTO userDTO) {
        name = userDTO.name();
        email = userDTO.email();
    }
}
