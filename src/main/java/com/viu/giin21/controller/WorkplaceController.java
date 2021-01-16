package com.viu.giin21.controller;

import com.viu.giin21.dto.WorkplaceDTO;
import com.viu.giin21.service.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/workplace")
public class WorkplaceController {

    @Autowired
    private WorkplaceService service;

    @GetMapping
    public ModelAndView index() {
        List<WorkplaceDTO> workplaces = service.findAll();
        return new ModelAndView("workplace/index", "workplaces", workplaces);
    }

    @GetMapping("/create")
    public ModelAndView create_GET() {
        WorkplaceDTO workplace = new WorkplaceDTO(null, null, "", 1, 1);
        return new ModelAndView("workplace/create", "workplace", workplace);
    }

    @PostMapping("/create")
    public String create_POST(WorkplaceDTO workplace) {
        service.save(workplace);
        return "redirect:/workplace";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit_GET(@PathVariable Integer id) {
        WorkplaceDTO workplace = service.get(id);
        return new ModelAndView("workplace/edit", "workplace", workplace);
    }

    @PostMapping("/{id}/edit")
    public String edit_POST(@PathVariable Integer id, WorkplaceDTO workplace) {
        workplace.setId(id);
        service.save(workplace);
        return "redirect:/workplace";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete_GET(@PathVariable Integer id) {
        WorkplaceDTO workplace = service.get(id);
        return new ModelAndView("workplace/delete", "workplace", workplace);
    }

    @PostMapping("/{id}/delete")
    public String delete_POST(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/workplace";
    }
}
