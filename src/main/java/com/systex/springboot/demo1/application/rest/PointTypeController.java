package com.systex.springboot.demo1.application.rest;

import com.systex.springboot.demo1.application.rest.request.CreatePointTypeRq;
import com.systex.springboot.demo1.application.rest.response.CreatePointTypeRs;
import com.systex.springboot.demo1.application.rest.response.ListPointTypeRs;
import com.systex.springboot.demo1.domain.PointType;
import com.systex.springboot.demo1.domain.common.service.PointTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/points")
@Slf4j
public class PointTypeController {

    @Autowired
    private PointTypeService pointTypeService;

    @PostMapping
    CreatePointTypeRs createPointType(@RequestBody CreatePointTypeRq rq) {
        log.info("Create PointType Rq: {}", rq);
        PointType pointType = new PointType(rq.getType(), rq.getDescription());
        UUID id = pointTypeService.createPointType(pointType);
        CreatePointTypeRs rs = new CreatePointTypeRs(id);
        return rs;
    }

    @GetMapping
    ListPointTypeRs listPointType() {
        List<PointType> types = pointTypeService.allTypes();
        ListPointTypeRs rs = new ListPointTypeRs(types);
        return rs;
    }

}
