package br.com.andersonchoren.todo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.andersonchoren.todo.model.ToDo;
import br.com.andersonchoren.todo.service.ToDoService;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {
    private ToDoService service = new ToDoService();

    @GetMapping
    public List<ToDo> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody ToDo todo) {
        try {
            return new ResponseEntity<>(service.save(todo), HttpStatus.CREATED);
        } catch (IllegalArgumentException ia) {
            return new ResponseEntity<>(ia.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Object> edit(@RequestBody ToDo todo) {
        try {
            return new ResponseEntity<>(service.edit(todo), HttpStatus.CREATED);
        } catch (IllegalArgumentException ia) {
            return new ResponseEntity<>(ia.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public void delete(@RequestParam String description) {
        try{
            service.delete(description);
        } catch (Exception e) {
            // Gerar um log de sistema
        }
    }
}