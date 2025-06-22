package com.jujulioed.MyCheckList.models.dtos;

import jakarta.validation.constraints.NotNull;

public record TaskUpdateDTO(@NotNull(message = "Must contain a task name")
                            String name,

                            String description) {
}
