package com.ua.hlibkorobov.restapp.dto;

import com.ua.hlibkorobov.restapp.entity.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class TodoListDto {

    private String title;

    private String description;

    private Status status;

}
