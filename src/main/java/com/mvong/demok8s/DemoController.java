package com.mvong.demok8s;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "welcome";
    }

    @PostMapping("toggleHealthCheck")
    @ResponseBody
    public String toggleHealthCheck() {
        demoComponent.toggleBoolean();
        return "/health will now answer " + demoComponent.isApplicationUp();
    }

}
