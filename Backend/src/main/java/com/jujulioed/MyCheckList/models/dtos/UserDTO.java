package com.jujulioed.MyCheckList.models.dtos;

import jakarta.validation.constraints.NotNull;

public record UserDTO(
        @NotNull(message = "Must contain the name")
        String name,

        @NotNull(message = "Must contain the email")
        String email) {
}
