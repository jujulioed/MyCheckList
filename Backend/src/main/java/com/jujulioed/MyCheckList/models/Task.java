package com.jujulioed.MyCheckList.models;
import lombok.*;
import java.util.Date;

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
    private Date createdDate;
    private Date finishedAt;

}
