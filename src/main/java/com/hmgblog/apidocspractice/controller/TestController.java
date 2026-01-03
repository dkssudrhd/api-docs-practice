package com.hmgblog.apidocspractice.controller;

import com.hmgblog.apidocspractice.dto.TestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/test/{id}")
    public TestResponse getTest(@PathVariable Long id){
        return new TestResponse(id, "Test Title", "Test Content");
    }

    @PostMapping("/test")
    public TestResponse postTest(@RequestBody TestResponse request){
        return request;
    }
}
