package br.com.andersonchoren.todo.service;

import java.time.LocalDate;
import java.util.List;

import br.com.andersonchoren.todo.model.ToDo;
import br.com.andersonchoren.todo.repository.ToDoRepository;

public class ToDoService {
    private ToDoRepository repository = new ToDoRepository();

    public List<ToDo> findAll() {
        return repository.findAll();
    }

    public ToDo save(ToDo todo) throws IllegalArgumentException {
        if (todo.getDescription() == null || todo.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição da tarefa não pode ficar em branco!!!");
        }
        if (todo.getDate() == null || todo.getDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("A data informada é inválida!!!");
        }
        if (todo.getIsDone() == null) {
            throw new IllegalArgumentException("O status da tarefa deve ser informado!!!");
        }
        return repository.save(todo);
    }

    public ToDo edit(ToDo todo) {
        if (todo.getDescription() == null || todo.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição da tarefa não pode ficar em branco!!!");
        }
        if (todo.getDate() == null || todo.getDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("A data informada é inválida!!!");
        }
        if (todo.getIsDone() == null) {
            throw new IllegalArgumentException("O status da tarefa deve ser informado!!!");
        }
        return repository.edit(todo);
    }

    public void delete(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição da tarefa não pode ficar em branco!!!");
        }
        repository.delete(description);
    }
}
