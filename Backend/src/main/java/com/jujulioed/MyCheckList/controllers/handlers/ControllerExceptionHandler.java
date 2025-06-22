package com.jujulioed.MyCheckList.controllers.handlers;

import com.jujulioed.MyCheckList.models.dtos.errors.ResourceNotFoundDTO;
import com.jujulioed.MyCheckList.exceptions.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ResourceNotFoundDTO> handlerResourceNotFound(ResourceNotFound e) {
        var status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status.value()).body(new ResourceNotFoundDTO(e.getMessage(), status.value()));
    }
}
