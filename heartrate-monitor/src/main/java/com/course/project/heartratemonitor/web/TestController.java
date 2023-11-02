package com.course.project.heartratemonitor.web;

//import com.course.project.macrunyi_xiaoran_xue.domain.event.producer.TestProducer;
//import com.course.project.macrunyi_xiaoran_xue.web.resp.Response;

import com.course.project.heartratemonitor.web.resp.Response;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hrm")
public class TestController {

    @Resource
    private TestProducer testSender;

    @GetMapping("sendMsg")
    public Response sendMsg(@RequestParam(required = true) String content) {
        testSender.sender(content);
        return new Response().success("send success");
    }

    @RequestMapping("")
    public String info() {
        return "ooOK";
    }
}
