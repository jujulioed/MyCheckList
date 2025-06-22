package com.jujulioed.MyCheckList.models.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record TaskDTO(
        @NotNull(message = "Must contain a task name")
        String name,

        String description,

        @NotNull(message = "Must contain a valid user id")
        Long userId) {
}
