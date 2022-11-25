package com.systex.springboot.demo1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PointType {
    /*
     * 從 JPA 3.1 開始，可以使用 @GeneratedValue 註釋主鍵屬性並將策略設置為 GenerationType.UUID
     * @GeneratedValue(strategy = GenerationType.UUID)
     */
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID typeId;
    private String type;
    private String description;

    public PointType(String type, String description) {
        this.type = type;
        this.description = description;
    }

}
