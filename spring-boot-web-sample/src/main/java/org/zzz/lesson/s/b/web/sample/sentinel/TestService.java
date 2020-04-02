package org.zzz.lesson.s.b.web.sample.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @SentinelResource(value = "testSentinel")
    public String testSentinel() {
        return "test sentinel";
    }
}
