package com.viu.giin21.controller;

import com.viu.giin21.service.JobService;
import com.viu.giin21.service.UserService;
import com.viu.giin21.service.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class DefaultController {

    @Autowired
    private UserService userService;

    @Autowired
    private WorkplaceService workplaceService;

    @Autowired
    private JobService jobService;

    @GetMapping("/")
    public ModelAndView index() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        long number_of_users = userService.count();
        long number_of_workplaces = workplaceService.count();
        long number_of_jobs = jobService.count();

        map.put("number_of_users", new Integer((int) number_of_users));
        map.put("number_of_workplaces", new Integer((int) number_of_workplaces));
        map.put("number_of_jobs", new Integer((int) number_of_jobs));

        return new ModelAndView("default/index", "map", map);
    }
}
