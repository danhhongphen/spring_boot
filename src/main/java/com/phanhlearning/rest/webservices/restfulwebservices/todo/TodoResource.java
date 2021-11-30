package com.phanhlearning.rest.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TodoResource {
    @Autowired
    private TodoHardcodedService todoHardcodedService;

    @GetMapping("users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {

        return todoHardcodedService.findAll();
    }

    @PostMapping("users/{username}/todos")
    public List<Todo> saveTodo(@PathVariable String username,
                                    @RequestBody Todo todo) {

        todoHardcodedService.saveTodo(todo);
        return todoHardcodedService.findAll();
    }

    @DeleteMapping("users/{username}/todos/{todo_id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username,
                                      @PathVariable long todo_id) {
        Todo todo = todoHardcodedService.deleteById(todo_id);
        if (todo != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("users/{username}/todos/{todo_id}")
    public Todo getTodo(@PathVariable String username,
                                           @PathVariable long todo_id) {
        Todo todo = todoHardcodedService.findById(todo_id);
        if (todo != null) {
            return todo;
        }
        return null;
    }

    @PutMapping("users/{username}/todos/{todo_id}")
    public Todo updateTodo(@PathVariable String username,
                           @PathVariable long todo_id,
                           @RequestBody Todo todo) {
        Todo update = todoHardcodedService.update(todo);
        return update;
    }
}
