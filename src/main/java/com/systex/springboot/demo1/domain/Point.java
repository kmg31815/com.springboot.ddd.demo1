package com.systex.springboot.demo1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point {
    PointType pointType;
    PointStatus pointStatus;
    float value;
}
