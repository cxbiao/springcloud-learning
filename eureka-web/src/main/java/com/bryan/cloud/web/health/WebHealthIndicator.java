package com.bryan.cloud.web.health;


import com.bryan.cloud.web.controller.OrderController;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        if(OrderController.canDbUse){
            return Health.up().build();
        }else {
            return Health.down().build();
        }
    }
}
