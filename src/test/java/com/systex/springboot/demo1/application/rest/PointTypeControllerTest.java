package com.systex.springboot.demo1.application.rest;

import com.systex.springboot.demo1.domain.PointType;
import com.systex.springboot.demo1.domain.common.service.PointTypeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @WebMvcTest 只會自動配置 MVC 測試相關的部分
 * (不包含 @Component, @Service, Repository beans)
 * <p>
 * 會自動配置 MockMvc、Spring Security
 */
@WebMvcTest(PointTypeController.class)
public class PointTypeControllerTest {

    @Autowired
    MockMvc mockMVC;

    @MockBean // 因為用 @WebMvcTest，PointTypeService 沒有實例，所以要用 mock
    PointTypeService service;

    @Test
    void hasEndPoint() throws Exception {
        mockMVC.perform(MockMvcRequestBuilders
                .get("/points") // REST GET Method
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void doesNotHaveEndPoint() throws Exception {
        mockMVC.perform(MockMvcRequestBuilders
                .get("/users")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNotFound());
    }

    @Test
    void mockGetAllRecords() throws Exception {
        mockMVC.perform(MockMvcRequestBuilders.get("/points").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pointTypes", hasSize(0)));
        /*
            用 JSONPath expression => 找 JSON 格式資料    https://jsonpath.com/
         */
    }

    private static final PointType T1 = new PointType("course1", "description1");
    private static final PointType T2 = new PointType("course2", "description2");
    private static final PointType T3 = new PointType("course3", "description3");

    @Test
    void mockGetAllRecords2() throws Exception {
        List<PointType> types = Arrays.asList(T1, T2, T3);

        Mockito.when(service.allTypes()).thenReturn(types);

        mockMVC.perform(MockMvcRequestBuilders.get("/points").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pointTypes", hasSize(3)));
    }

}
