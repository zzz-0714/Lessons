package org.zzz.lesson.s.b.web.sample.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zzz.lesson.core.domain.Hello;
import org.zzz.lesson.core.enums.Sex;
import org.zzz.lesson.s.b.properties.autoconfigure.AutoCommunicationClient;
import org.zzz.lesson.s.b.web.sample.sentinel.TestService;

@RestController
@RequestMapping(path = "/sample")
public class SampleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

    private final AutoCommunicationClient communicationClient;

    private final TestService testService;

    public SampleController(AutoCommunicationClient communicationClient, TestService testService) {
        this.communicationClient = communicationClient;
        this.testService = testService;
    }

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

    @RequestMapping(path = "/communication")
    public String communication() {
        return communicationClient.sayHello();
    }

    @RequestMapping(path = "/test/sentinel")
    public String sentinel() {
        return testService.testSentinel();
    }

}
