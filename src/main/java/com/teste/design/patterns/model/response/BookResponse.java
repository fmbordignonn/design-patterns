package com.teste.design.patterns.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookResponse {
    private final Long id;
    private final String name;
    private final String description;
}
