package com.course.project.macrunyi_xiaoran_xue;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health")
public class TestController {

    @RequestMapping("")
    public String info() {
        return "OK";
    }
}
