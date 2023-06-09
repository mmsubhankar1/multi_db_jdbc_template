package com.ey.demo.controller;

import com.ey.demo.model.TestPost;
import com.ey.demo.service.DemoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    DemoService demoService;
    @GetMapping("/test/{schema}")
    public ResponseEntity<?> test(@PathVariable("schema") String schema)
    {
        return new ResponseEntity<>(demoService.test(schema), HttpStatus.OK);
    }

    @PostMapping("/test-post")
    public ResponseEntity<?> testpost(@RequestBody TestPost testPost)
    {
        demoService.testpost(testPost);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

}
