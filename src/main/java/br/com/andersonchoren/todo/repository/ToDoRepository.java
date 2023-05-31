package br.com.andersonchoren.todo.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.andersonchoren.todo.model.ToDo;

public class ToDoRepository {
    private static List<ToDo> tasks = new ArrayList<>();

    public List<ToDo> findAll() {
        return tasks;
    }

    public ToDo save(ToDo todo) {
        // Preparar o objeto para a persistência
        tasks.add(todo);
        return todo;
    }

    public ToDo edit(ToDo todo) {
        for (int i = 0; i < tasks.size(); i++) {
            ToDo element = tasks.get(i);
            if (element.getDescription().equals(todo.getDescription())) {
                tasks.set(i, todo);
            }
        }
        return todo;
    }

    public void delete(String description) {
        for (int i = 0; i < tasks.size(); i++) {
            ToDo element = tasks.get(i);
            if (element.getDescription().equals(description)) {
                tasks.remove(i);
            }
        }
    }
}
