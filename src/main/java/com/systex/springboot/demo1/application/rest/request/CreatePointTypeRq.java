package com.systex.springboot.demo1.application.rest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePointTypeRq {
    private String type;
    private String description;
}
