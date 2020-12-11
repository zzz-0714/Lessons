package spring.boot.aop.sample.aop;

import java.lang.annotation.*;

/**
 * @author zhaozhizheng3
 * @date 2020/12/10
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WatchPoint {
}
