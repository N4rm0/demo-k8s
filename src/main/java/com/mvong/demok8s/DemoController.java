package com.mvong.demok8s;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Monard on 25/11/2018.
 */
@Controller
public class DemoController {

    @Autowired
    private DemoComponent demoComponent;

    @RequestMapping("/")
    public String start(Model model) {
        model.addAttribute("isApplicationUp", demoComponent.isApplicationUp());
        model.addAttribute("isApplicationSlow", demoComponent.isApplicationSlow());
        return "welcome";
    }

    @PostMapping("toggleHealthCheck")
    @ResponseBody
    public String toggleHealthCheck() {
        demoComponent.toggleBoolean();
        return "/actuator/health  will now answer " + demoComponent.isApplicationUp();
    }

    @PostMapping("toggleSlowApplication")
    @ResponseBody
    public String toggleSlowApplication() {
        demoComponent.toggleSlowApplication();
        return "/actuator/health will answer " + (demoComponent.isApplicationSlow() ? "slowly" : "normally");
    }

}
