package com.phanhlearning.rest.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class TodoJpaResource {
    @Autowired
    private TodoHardcodedService todoHardcodedService;

    @Autowired
    private TodoJpaRepository todoJpaRepository;

    @GetMapping("/jpa/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoJpaRepository.findByUsername(username);
    }

    @PostMapping("/jpa/users/{username}/todos")
    public ResponseEntity<Void> saveTodo(@PathVariable String username,
                               @RequestBody Todo todo) {
        Todo createTodo = todoJpaRepository.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/jpa/users/{username}/todos/{todo_id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username,
                                           @PathVariable long todo_id) {
        try {
            todoJpaRepository.deleteById(todo_id);
        }
        catch(Exception e) {
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/jpa/users/{username}/todos/{todo_id}")
    public Todo getTodo(@PathVariable String username,
                        @PathVariable long todo_id) {
        Optional<Todo> todo = todoJpaRepository.findById(todo_id);
        if (todo.isPresent()) {
            return todo.get();
        }
        return null;
    }

    @PutMapping("/jpa/users/{username}/todos/{todo_id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,
                           @PathVariable long todo_id,
                           @RequestBody Todo todo) {
        Todo update = todoJpaRepository.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }
}