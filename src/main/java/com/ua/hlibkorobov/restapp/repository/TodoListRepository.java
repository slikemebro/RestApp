package com.ua.hlibkorobov.restapp.repository;

import com.ua.hlibkorobov.restapp.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {
}
