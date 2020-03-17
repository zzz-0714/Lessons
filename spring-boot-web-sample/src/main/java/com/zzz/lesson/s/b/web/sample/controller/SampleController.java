package com.zzz.lesson.s.b.web.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zzz.lesson.core.domain.Hello;
import org.zzz.lesson.core.enums.Sex;

@RestController
@RequestMapping(path = "/sample")
public class SampleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping(path = "/")
    public String index() {
        return "this page is for sample controller";
    }

    @RequestMapping(path = "/sayHello")
    public Hello sayHello() {
        Hello hello = new Hello();
        hello.setName("zzz");
        hello.setAge(18);
        hello.setSex(Sex.MALE);
        return hello;
    }

}
