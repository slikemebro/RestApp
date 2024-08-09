package com.ua.hlibkorobov.restapp.service;

import com.ua.hlibkorobov.restapp.dto.TodoListDto;
import com.ua.hlibkorobov.restapp.entity.TodoList;

import java.util.List;

public interface TodoListService {


    List<TodoList> findAll();
    TodoList findById(long id);
    TodoList save(TodoListDto todoListDto);
    TodoList update(TodoList todoList);
    void deleteById(long id);

}
