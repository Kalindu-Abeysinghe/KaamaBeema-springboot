package KaamaBeemacom.example.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController<T> {

    public ResponseEntity getNotFoundErrorResponse(String modelType, String parameterName, String parameterValue){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND.value())
                .body(modelType+" with "+parameterName+" "+parameterValue+" is not found");
    }

    public ResponseEntity getSuccessResponse(T objectToReturn){
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(objectToReturn);
    }
}
