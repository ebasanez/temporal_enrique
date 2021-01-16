package com.viu.giin21.controller;

import com.viu.giin21.dto.JobDTO;
import com.viu.giin21.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping
    public ModelAndView index() {
        List<JobDTO> jobs = service.findAll();
        return new ModelAndView("job/index", "jobs", jobs);
    }

    @GetMapping("/create")
    public ModelAndView create_GET() {
        JobDTO job = new JobDTO(null, null, null, "", 1, false);
        return new ModelAndView("job/create", "job", job);
    }

    @PostMapping("/create")
    public String create_POST(JobDTO job) {
        service.save(job);
        return "redirect:/job";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit_GET(@PathVariable Integer id) {
        JobDTO job = service.get(id);
        return new ModelAndView("job/edit", "job", job);
    }

    @PostMapping("/{id}/edit")
    public String edit_POST(@PathVariable Integer id, JobDTO job) {
        job.setId(id);
        service.save(job);
        return "redirect:/job";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete_GET(@PathVariable Integer id) {
        JobDTO job = service.get(id);
        return new ModelAndView("job/delete", "job", job);
    }

    @PostMapping("/{id}/delete")
    public String delete_POST(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/job";
    }
}
