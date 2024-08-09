package com.ua.hlibkorobov.restapp.service.impl;

import com.ua.hlibkorobov.restapp.dto.TodoListDto;
import com.ua.hlibkorobov.restapp.entity.Status;
import com.ua.hlibkorobov.restapp.entity.TodoList;
import com.ua.hlibkorobov.restapp.exception.IllegalChangingOfStatusException;
import com.ua.hlibkorobov.restapp.exception.TodoListNotFound;
import com.ua.hlibkorobov.restapp.repository.TodoListRepository;
import com.ua.hlibkorobov.restapp.service.TodoListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class TodoListServiceImpl implements TodoListService {

    private final TodoListRepository repository;

    @Override
    public List<TodoList> findAll() {
        return repository.findAll();
    }

    @Override
    public TodoList findById(long id) {
        Optional<TodoList> todoListOptional = repository.findById(id);
        return todoListOptional.orElseThrow(() -> new TodoListNotFound("Todo list wasn't find"));
    }

    @Override
    public TodoList save(TodoListDto todoListDto) {
        TodoList todoList = convertDtoToTodoList(todoListDto);
        return repository.save(todoList);
    }

    private TodoList convertDtoToTodoList(TodoListDto todoListDto) {
        TodoList todoList = new TodoList();

        todoList.setTitle(todoListDto.getTitle());
        todoList.setStatus(Status.CREATED);
        todoList.setDescription(todoListDto.getDescription());
        todoList.setCreatedDate(LocalDate.now());

        return todoList;
    }

    @Override
    public TodoList update(TodoList todoList) {
        TodoList oldTodoList = findById(todoList.getId());

        updateTodoList(oldTodoList, todoList);

        return repository.save(oldTodoList);
    }

    private void updateTodoList(TodoList oldTodoList, TodoList todoList) {
        if (todoList.getTitle() != null) {
            oldTodoList.setTitle(todoList.getTitle());
        }
        if (todoList.getDescription() != null) {
            oldTodoList.setDescription(todoList.getDescription());
        }

        if (todoList.getStatus() != null &&
                todoList.getStatus().getValue() > oldTodoList.getStatus().getValue()){
            oldTodoList.setStatus(todoList.getStatus());
        }else {
            throw new IllegalChangingOfStatusException(
                    "You can't change status from " + oldTodoList.getStatus() +
                    " to " + todoList.getStatus());
        }
    }

    @Override
    public void deleteById(long id) {
        findById(id);
        repository.deleteById(id);
    }
}
