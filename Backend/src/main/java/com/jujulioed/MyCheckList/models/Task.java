package com.jujulioed.MyCheckList.models;
import com.jujulioed.MyCheckList.models.dtos.TaskDTO;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Task {
    private Long id;
    private String name;
    private String description;
    private Long userId;
    private Boolean done;
    private LocalDate createdDate;
    private LocalDate finishedAt;

    public Task(TaskDTO taskDTO) {
        this.name = taskDTO.name();
        this.description = taskDTO.description();
        this.userId = taskDTO.userId();
        this.createdDate = LocalDate.now();
        this.done = false;
    }
}
