package pl.polsl.temperature;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(WrongBodyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Message wrongBodyHandler(WrongBodyException e) {
        return generateBasicMessage(e);
    }

    private Message generateBasicMessage(Exception e){
        return new Message(e.getClass().getSimpleName(), e.getMessage());
    }


}
