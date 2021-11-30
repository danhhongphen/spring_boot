package com.phanhlearning.rest.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList<>();
    private static long idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "in28minutes", "Learn to Dance", new Date(), false));
        todos.add(new Todo(++idCounter, "in28minutes", "Learn about Microservices 2", new Date(), false));
        todos.add(new Todo(++idCounter, "in28minutes", "Learn about React", new Date(), false));
    }

    public List<Todo> findAll() {
        return todos;
    }

    public Todo deleteById(long id) {
        Todo todo = findById(id);
        if (todo == null) {
            return null;
        }
        if (todos.remove(todo)) {
            return todo;
        }
        return null;
    }

    public Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public void saveTodo(Todo todo) {
        this.todos.add(new Todo(++idCounter, "in28minutes", todo.getDescription(), todo.getTargetDate(), false));
    }

    public Todo update(Todo todo) {
        for (Todo t : todos) {
            if (t.getId() == todo.getId()) {
                t.setDescription(todo.getDescription());
                t.setTargetDate(todo.getTargetDate());
                t.setDone(todo.isDone());
                return t;
            }
        }
        return null;
    }
}
