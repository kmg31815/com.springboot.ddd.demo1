package com.systex.springboot.demo1.infrastructure.repository;

import com.systex.springboot.demo1.domain.PointType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @SpringBootTest 會啟用 JPA (console 可看到 HikariPool)
 * <p>
 * HikariPool 是一個開源數據庫連接池管理工具
 */
@SpringBootTest
public class PointTypeJPARepositoryTest {
    @Autowired
    private PointTypeJPARepository repository;

    @Test
    void repositoryShouldNotBeNull() {
        assertNotNull(repository);
    }

    @Test
    void savePointTypeAndCheck() {
        PointType pointType = repository.save(new PointType("JAVA", "JAVA Web"));
        System.out.println("TypeId: " + pointType.getTypeId());
        assertThat(repository.findById(pointType.getTypeId())).isNotNull();
    }
}
