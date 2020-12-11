package spring.boot.aop.sample.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @author zhaozhizheng3
 * @date 2020/12/11
 */
@Component
@Aspect
public class WatchPointInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(WatchPointInterceptor.class);

    @Pointcut("@annotation(spring.boot.aop.sample.aop.WatchPoint)")
    public void watchPointAspect() {
    }

    @Around("watchPointAspect()")
    public Object executePoint(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch watch = new StopWatch(pjp.getSignature().toLongString());
        LOGGER.info("pjp point is : {}", pjp);
        watch.start();
        try {

            showTarget(pjp.getTarget());
            showSignature(pjp.getSignature());
            showKind(pjp.getKind());
            showStaticPart(pjp.getStaticPart());

            return pjp.proceed();
        } finally {
            watch.stop();
            showWatch(watch);
        }
    }

    private void showWatch(StopWatch watch) {
        LOGGER.info("watch pretty is : {}", watch.prettyPrint());
    }

    private void showTarget(Object target) {
        LOGGER.info("target is : {}", target);
    }

    private void showSignature(Signature signature) {
        LOGGER.info("signature is : {}", JSON.toJSONString(signature));
        LOGGER.info("signature name is : {}", signature.getName());
        LOGGER.info("declaring type is : {}", signature.getDeclaringType());
        LOGGER.info("declaring type name is : {}", signature.getDeclaringTypeName());
        LOGGER.info("signature long string is : {}", signature.toLongString());
        LOGGER.info("signature short string is : {}", signature.toShortString());
    }

    private void showKind(String kind) {
        LOGGER.info("kind is : {}", kind);
    }

    private void showStaticPart(JoinPoint.StaticPart staticPart) {
        LOGGER.info("static part is : {}", staticPart);
        LOGGER.info("static part id is : {}", staticPart.getId());
        LOGGER.info("static part kind is : {}", staticPart.getKind());
        LOGGER.info("static part signature : {}", staticPart.getSignature());
        LOGGER.info("static part long string is : {}", staticPart.toLongString());
        LOGGER.info("static part short string is : {}", staticPart.toShortString());
    }

}
