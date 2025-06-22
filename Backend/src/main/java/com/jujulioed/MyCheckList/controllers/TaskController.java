package com.jujulioed.MyCheckList.controllers;

import com.jujulioed.MyCheckList.models.Task;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/users/{userId}/tasks")
public class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @GetMapping
    public ResponseEntity<List<Task>> findAllTasks(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @PathVariable Long userId
    ) {
        return null;
    }
}
