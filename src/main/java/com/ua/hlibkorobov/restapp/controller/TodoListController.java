package com.ua.hlibkorobov.restapp.controller;

import com.ua.hlibkorobov.restapp.dto.TodoListDto;
import com.ua.hlibkorobov.restapp.model.TodoList;
import com.ua.hlibkorobov.restapp.service.TodoListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo-list")
@Log4j2
@RequiredArgsConstructor
public class TodoListController {

    private final TodoListService todoListService;


    @GetMapping
    public ResponseEntity<List<TodoList>> getAllTodoList(){
        return ResponseEntity.ok(todoListService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoList> getTodoListById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(todoListService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TodoList> saveTodoList(@RequestBody TodoListDto todoListDto){
        return ResponseEntity.ok(todoListService.save(todoListDto));
    }

    @PutMapping
    public ResponseEntity<TodoList> updateTodoList(@RequestBody TodoList todoList){
        return ResponseEntity.ok(todoListService.update(todoList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoList(@PathVariable(name = "id") long id){
        todoListService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
