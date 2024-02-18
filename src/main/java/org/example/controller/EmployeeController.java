package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.persons.Employee;
import org.example.persons.Level;
import org.example.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @GetMapping
    public ModelAndView showAll(ModelAndView model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addObject("employees", employees);
        model.setViewName("list");
        return model;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(ModelAndView modelAndView) {
        modelAndView.setViewName("create");
        Employee employee = new Employee();
        modelAndView.addObject(employee);
        modelAndView.addObject("priorities", Level.values());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Valid Employee employee,
                         BindingResult bindingResult) {
        log.info("#employee " + employee);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        employeeRepository.create(employee);
        return "redirect:/employees";
    }
}
