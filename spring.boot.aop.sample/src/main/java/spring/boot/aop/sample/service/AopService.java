package spring.boot.aop.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import spring.boot.aop.sample.aop.WatchPoint;

/**
 * @author zhaozhizheng3
 * @date 2020/12/7
 */
@Service
public class AopService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AopService.class);

    private String aopFieldName = "showBase";

    @WatchPoint
    public void showBase() {
        LOGGER.info("show base is : {}", aopFieldName);
    }

    @WatchPoint
    public void showExt(String ext) {
        LOGGER.info("show ext is : {}", ext);
    }

}
