package br.com.andersonchoren.todo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
    @GetMapping
    public ResponseEntity<String> getKey(@RequestParam String key) {
        if (key.equals("12345")) {
            return new ResponseEntity<String>("Autorizado", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<String>("Não autorizado", HttpStatus.UNAUTHORIZED);
    }
}
