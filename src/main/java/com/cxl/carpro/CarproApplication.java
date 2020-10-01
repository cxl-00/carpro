package com.cxl.carpro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @author chenxiaoling
 */
@SpringBootApplication(scanBasePackages = {"com.cxl"}, exclude = {SecurityAutoConfiguration.class})
@MapperScan("com.cxl.carpro.dao.mapper")
public class CarproApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarproApplication.class, args);
    }

}
