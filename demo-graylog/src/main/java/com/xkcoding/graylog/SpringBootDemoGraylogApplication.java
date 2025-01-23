package com.xkcoding.graylog;
import cn.hutool.core.util.StrUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 启动器
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019-04-23 09:43
 */
@SpringBootApplication
public class SpringBootDemoGraylogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoGraylogApplication.class, args);
    }

}
