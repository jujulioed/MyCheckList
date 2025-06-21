package com.jujulioed.MyCheckList.controllers;

import com.jujulioed.MyCheckList.models.TestModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("Test")
    public TestModel Test(@RequestParam(value = "text", defaultValue = "Testing") String message) {
        return new TestModel(message);
    }
}
