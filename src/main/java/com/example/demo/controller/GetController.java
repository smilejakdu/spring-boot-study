package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        return "Hello World!";
    }

    @GetMapping("/name")
    public String getName() {
        return "My name is John Ash";
    }

    @GetMapping(value = "/variable/{variable}")
    public String getVariable(@PathVariable String variable) {
        return variable;
    }

    @GetMapping(value = "/request1")
    public String getRequestParam2(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization
    ) {
        return "name: " + name + ", email: " + email + ", organization: " + organization;
    }

    @GetMapping(value = "/request2")
    public String getRequestParam2(
            @RequestParam Map<String, String> requestParams
    ) {
        StringBuilder sb = new StringBuilder();
        requestParams.entrySet().forEach(entry -> {
            sb.append(entry.getKey() + ": " + entry.getValue() + ", ");
        });
//      requestParams.forEach((key, value) -> sb.append(key).append(": ").append(value).append(", "));
//      이렇게 바꿔 줄 수도 있다.
        return sb.toString();
    }

    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto) {
        return memberDto.toString();
    }
}
