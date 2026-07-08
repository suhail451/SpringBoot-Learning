package org.learnspringframework.jobboard.exceptions;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    Logger logger =  LoggerFactory.getLogger(CustomizeResponseEntityExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<ErrorDetailsPojo> HandleAllExceptions(Exception ex, WebRequest request) throws Exception{
        ErrorDetailsPojo errorDetailsPojo = new ErrorDetailsPojo(HttpStatus.INTERNAL_SERVER_ERROR.value() ,ex.getMessage(), LocalDate.now(), request.getDescription(false));

        return new ResponseEntity<ErrorDetailsPojo>( errorDetailsPojo ,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = JobNotFoundException.class)
    public final ResponseEntity<ErrorDetailsPojo> HandleJobNotFoundException(Exception ex, WebRequest request ) throws Exception{
        ErrorDetailsPojo errorDetailsPojo = new ErrorDetailsPojo( HttpStatus.NOT_FOUND.value(), ex.getMessage(), LocalDate.now(), request.getDescription(false) );
        logger.error("JobNotFound error is for : " , ex);
        return new ResponseEntity<ErrorDetailsPojo>( errorDetailsPojo, HttpStatus.NOT_FOUND );
    }

    @ExceptionHandler(value = InvalidJobDataException.class)
    public final ResponseEntity<ErrorDetailsPojo> HandleInvalidJobDataException(Exception ex, WebRequest request) throws Exception{
        ErrorDetailsPojo errorDetailsPojo = new ErrorDetailsPojo(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), LocalDate.now(), request.getDescription(false) );
        return new ResponseEntity<ErrorDetailsPojo>(errorDetailsPojo, HttpStatus.BAD_REQUEST );
    }

    @Override
    protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

            ErrorDetailsPojo errorDetailsPojo = new ErrorDetailsPojo(HttpStatus.METHOD_NOT_ALLOWED.value(), "Total Error : " +ex.getErrorCount() + " --> Error : "+ ex.getFieldError().getDefaultMessage(), LocalDate.now(), request.getDescription(false) );
    return new ResponseEntity(errorDetailsPojo, HttpStatus.METHOD_NOT_ALLOWED);
    }



}
