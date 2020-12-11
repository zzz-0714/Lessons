package spring.boot.aop.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import spring.boot.aop.sample.service.AopService;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author zhaozhizheng3
 * @date 2020/12/7
 */
@SpringBootApplication
public class Bootstrap {

    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }

    @Component
    public class ExecutorRunner implements CommandLineRunner {

        @Autowired
        private AopService aopService;

        @Override
        public void run(String... args) throws Exception {
            aopService.showBase();
            aopService.showExt(Objects.toString(LocalDateTime.now()));
        }
    }

}
