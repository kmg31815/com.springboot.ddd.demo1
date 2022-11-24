package com.systex.springboot.demo1.application.rest.response;

import lombok.Getter;

import java.util.UUID;

public class CreatePointTypeRs {
    @Getter
    private final UUID id;

    public CreatePointTypeRs(UUID id) {
        this.id = id;
    }
}
