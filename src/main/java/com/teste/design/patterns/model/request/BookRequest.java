package com.teste.design.patterns.model.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class BookRequest {
    private final String name;
    private final String description;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public BookRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
