package com.cloud.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘佳俊
 */
@RefreshScope // 用于手动刷新配置中心的数据
@RestController
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @Value("${user.username}")
    private String username;
    @Value("${user.password}")
    private String password;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }

    @GetMapping("/userInfo")
    public String getUserInfo() {
        return username + password;
    }
}