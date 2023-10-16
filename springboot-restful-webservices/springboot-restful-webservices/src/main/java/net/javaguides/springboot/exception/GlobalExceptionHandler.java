package javaguides.springboot.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                      WebRequestwebrequest){
    ErrorDetails errorDetails = new ErrorDetails(
      LocalDateTime.now(),
      exception.getMessage(),
      webRequest.getDescription(includeClientInfo: false),
    errorCode:"USER_NOT_FOUND"
    );
    return new ResponsEntity<>(erroDetails, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDetails> handleGloablException(EmailAlreadyExistsException exception,
                                                                      WebRequest webrequest){
    ErrorDetails errorDetails = new ErrorDetails(
      LocalDateTime.now(),
      exception.getMessage(),
      webRequest.getDescription(includeClientInfo : false),
      errorCode: "INTERNAL SERVER ERROR"
    );
    return new ResponsEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @Override

  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                HttpHeaders headers,
                                                                HttpStatusCode status,
                                                                WebRequest request){
    Map <String, String> errors =   new HashMap<>();
    List<ObjectError> errorList - ex.getBindingResult().getAllErrors();

    errorList.forEach((error)=>{

      String fieldName = ((FieldError)error).getField();
      String message = error.getDefaultMessage();
      errors.put(fieldName, message);
    });

    return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);


  }
}
