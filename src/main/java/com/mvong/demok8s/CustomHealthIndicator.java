package com.mvong.demok8s;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created by Monard on 25/11/2018.
 */
@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Autowired
    private DemoComponent demoComponent;

    @Override
    public Health health() {
        if (demoComponent.isApplicationSlow()){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                return Health.down().build();
            }
        }
        return demoComponent.isApplicationUp() ? Health.up().build(): Health.down().build();
    }
}
