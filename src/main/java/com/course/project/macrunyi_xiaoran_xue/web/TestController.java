package com.course.project.macrunyi_xiaoran_xue.web;

import com.course.project.macrunyi_xiaoran_xue.mq.producer.TestSender;
import jakarta.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health")
public class TestController {

    @Resource
    private TestSender testSender;

    @GetMapping("sendMsg")
    public String sendMsg(@RequestParam(required = true) String content) {
        testSender.sender(content);
        return "success, msg sent to mq";
    }

    @RequestMapping("")
    public String info() {
        return "OK";
    }
}
