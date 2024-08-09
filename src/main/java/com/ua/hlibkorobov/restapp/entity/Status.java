package com.ua.hlibkorobov.restapp.entity;

import lombok.Getter;

@Getter
public enum Status {

    CREATED(0), IN_PROGRESS(1), COMPLETED(2), CANCELED(3);

    private final int value;

    Status(int value) {
        this.value = value;
    }



}
