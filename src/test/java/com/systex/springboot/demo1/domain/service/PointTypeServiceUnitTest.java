package com.systex.springboot.demo1.domain.service;

import com.systex.springboot.demo1.domain.PointType;
import com.systex.springboot.demo1.domain.common.repository.PointTypeRepository;
import com.systex.springboot.demo1.domain.common.service.PointTypeService;
import com.systex.springboot.demo1.domain.common.service.PointTypeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class PointTypeServiceUnitTest {
    private PointTypeRepository repository;
    private PointTypeService service;

    @BeforeEach
    void prepare() {
        System.out.println("===== prepare (bofore demo1,demo2) =====");

        repository = mock(PointTypeRepository.class);
        service = new PointTypeServiceImpl(repository);

        when(repository.save(ArgumentMatchers.any(PointType.class))).thenReturn(UUID.randomUUID());
    }

    @Test
    void demo1() {
        System.out.println("===== demo1 =====");

        PointType pointType = new PointType("type", "description");
        UUID id = service.createPointType(pointType);
        System.out.println("UUID: " + id);

        verify(repository).save(ArgumentMatchers.any(PointType.class));
        assertNotNull(id); // assert 斷言
    }

    @Test
    void demo2() {
        System.out.println("===== demo2 =====");

        service.allTypes();
        verify(repository).getAll(); // verify 驗證方法是否被呼叫
    }

}
