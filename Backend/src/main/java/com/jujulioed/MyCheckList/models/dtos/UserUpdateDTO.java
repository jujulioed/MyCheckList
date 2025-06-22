package com.jujulioed.MyCheckList.models.dtos;

import jakarta.validation.constraints.NotNull;

public record UserUpdateDTO(@NotNull(message = "Must contain the a name")
                            String name,

                            @NotNull(message = "Must contain a email")
                            String email) {
}
