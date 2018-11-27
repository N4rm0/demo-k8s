package com.mvong.demok8s;

import org.springframework.stereotype.Component;

/**
 * Created by Monard on 25/11/2018.
 */
@Component
public class DemoComponent {

    private boolean applicationUp = true;
    private boolean applicationSlow = false;

    public boolean isApplicationUp() {
        return applicationUp;
    }

    public void toggleBoolean() {
        this.applicationUp ^= true;
    }

    public boolean isApplicationSlow() {
        return applicationSlow;
    }

    public void toggleSlowApplication() {
        this.applicationSlow ^= true;
    }
}
