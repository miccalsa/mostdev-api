package nl.yacht.mostdevapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import nl.yacht.mostdevapi.dto.ErrorDto;
import nl.yacht.mostdevapi.model.NotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundExceptions(NotFoundException ex) {
        this.logger.error(ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex) {
        this.logger.error(ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Error found during the process");
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
