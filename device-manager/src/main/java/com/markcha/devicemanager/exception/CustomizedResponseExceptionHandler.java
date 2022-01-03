package com.markcha.devicemanager.exception;

import com.markcha.devicemanager.exception.auth.AuthException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseExceptionHandler
extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));


        return new ResponseEntity(exceptionResponse, HttpStatus.UNAUTHORIZED);
    }

//    @ExceptionHandler(TestException.class)
//    public final ResponseEntity<Object> TestHandleExceptions(TestException ex, WebRequest request) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse(
//                new Date(),
//                ex.getMessage(),
//                request.getDescription(false));
//
//
//        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
//    }
//    @ExceptionHandler(BadCredentialsException.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public ResponseEntity<ErrorResponse> handleBadCredentials(Exception ex) {
//        ErrorResponse errorResponse = new ErrorResponse(RestExceptionCode.FC_RE_001, "Authorisierung erforderlich");
//        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
//    }
//
//    @ExceptionHandler(AccessDeniedException.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public ResponseEntity<ErrorResponse> handleAccessDenied(Exception ex) {
//        ErrorResponse errorResponse = new ErrorResponse(RestExceptionCode.FC_RE_001, "Zugriff verweigert");
//        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
//    }
//    @ExceptionHandler(BadCredentialsException.class)
//    @ResponseBody
//    public final ResponseEntity<Object> dontHaveAuthorization(BadCredentialsException ex, WebRequest request) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse(
//                new Date(),
//                ex.getMessage(),
//                request.getDescription(false));
//
//
//        return new ResponseEntity(exceptionResponse, HttpStatus.UNAUTHORIZED);
//    }

//    @ExceptionHandler(BadCredentialsException.class)
//    @ResponseBody
//    public ResponseEntity<Object> handleBadCredentials(Exception ex, WebRequest request) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse(
//                new Date(),
//                ex.getMessage(),
//                request.getDescription(false));
//
//
//        return new ResponseEntity(exceptionResponse, HttpStatus.FORBIDDEN);
//    }
//
//    @ExceptionHandler(AccessDeniedException.class)
//    @RequestMapping
//    public ResponseEntity<Object> handleAccessDenied(Exception ex, WebRequest request) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse(
//                new Date(),
//                ex.getMessage(),
//                request.getDescription(false));
//
//
//        return new ResponseEntity(exceptionResponse, HttpStatus.UNAUTHORIZED);
//    }


//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers,
//                                                                  HttpStatus status,
//                                                                  WebRequest request) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse(
//                new Date(),
//               ex.getMessage(), ex.getBindingResult().toString());
//        return new ResponseEntity(exceptionResponse, HttpStatus.OK);
//    }



}
