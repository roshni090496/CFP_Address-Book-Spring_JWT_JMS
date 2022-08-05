package com.example.addressbookapp.exception;

import com.example.addressbookapp.dto.ResponseDTO;
import com.example.addressbookapp.model.AddressModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

    @ControllerAdvice
    @Slf4j
    public class CustomException {
        @ExceptionHandler(AddressException.class)
        public ResponseEntity<ResponseDTO> handleUserException(AddressException exception){
            ResponseDTO respDTO = new ResponseDTO("Exception while processing REST Request",
                    exception.getMessage());
            return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.BAD_REQUEST);
        }
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
            List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
            List<String> errMsg = errorList.stream()
                    .map(objErr -> objErr.getDefaultMessage())
                    .collect(Collectors.toList());
            ResponseDTO respDTO = new ResponseDTO("Exception while processing rest request", (AddressModel) errMsg);
            return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.BAD_REQUEST);
        }
        @ExceptionHandler(ConstraintViolationException.class)
        public ResponseEntity<ResponseDTO> exceptionHandler(ConstraintViolationException exception){
            ResponseDTO respDTO = new ResponseDTO(exception.getMessage());
            return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.BAD_REQUEST);
        }
    }


