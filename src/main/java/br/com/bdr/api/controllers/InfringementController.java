package br.com.bdr.api.controllers;

import br.com.bdr.api.models.Infringement;
import br.com.bdr.api.services.InfringementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static br.com.bdr.api.shared.Utils.REGISTERED_INFRINGEMENT_OK;

@RestController
@RequestMapping(value = "api/v1/infringement/")
@CrossOrigin
public class InfringementController {

    @Autowired
    private InfringementService infringementService;

    @PostMapping("create")
    @ResponseBody
    @CrossOrigin
    public ResponseEntity<?> register (@RequestBody @Valid Infringement infringement) {
        if (infringementService.register(infringement)) {
            return new ResponseEntity<>(REGISTERED_INFRINGEMENT_OK,HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();

            errors.put(fieldName, errorMessage);
        });

        return errors;
    }
}
