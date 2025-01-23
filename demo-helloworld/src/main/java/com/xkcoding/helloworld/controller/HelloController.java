package com.xkcoding.helloworld.controller;

import cn.hutool.core.util.StrUtil;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam(defaultValue = "xkcoding") String who) {
        if (StrUtil.isBlank(who)) {
            who = "World";
        }
        return StrUtil.format("Hello, {}!", who);
    }
}
