package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.persons.Employee;
import org.example.persons.Level;
import org.example.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @GetMapping()
    public String allEmployee(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "employee/allEmployee";
    }

    @GetMapping("/{id}")
    public String showEmployee(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeRepository.findById(id));
        return "employee/showEmployee";
    }

    @GetMapping("/newEmployee")
    public String newEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("levels", Level.values());
        return "employee/newEmployee";
    }

    @PostMapping()
    public String createEmployee(@ModelAttribute("employee") Employee employee) {

        employeeRepository.create(employee);
        return "redirect:/employee";
    }

    @GetMapping("/{id}/editEmployee")
    public String editEmployee(Model model, @PathVariable("id") int id) {
        model.addAttribute("employee", employeeRepository.findById(id));
        model.addAttribute("levels", Level.values());
        return "employee/editEmployee";
    }

    @PatchMapping("/{id}")
    public String updateEmployee(@ModelAttribute("employee") Employee employee,
                         @PathVariable("id") int id) {
        employeeRepository.update(employee);
        return "redirect:/employee";
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeRepository.delete(id);
        return "redirect:/employee";
    }

/*    @GetMapping
    public ModelAndView showAll(ModelAndView model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addObject("employees", employees);
        model.setViewName("listEmployee");
        return model;
    }
   *//* @GetMapping
    public String showAll(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employee", employees);
        return "employees";
    }*//*

    @GetMapping("/createEmployee")
    public ModelAndView showCreate(ModelAndView modelAndView) {
        modelAndView.setViewName("createEmployee");
        Employee employee = new Employee();
        modelAndView.addObject(employee);
        modelAndView.addObject("levels", Level.values());
        return modelAndView;
    }

    @PostMapping("/createEmployee")
    public String create(@ModelAttribute Employee employee) {
        log.info("#createEmployee " + employee);
        *//*if (bindingResult.hasErrors()) {
            return "create";
        }*//*
        employeeRepository.create(employee);
        return "redirect:/employees";
    }

*//*    @GetMapping("/users/{id}/editEmployee")
    public ModelAndView editEmployee(@PathVariable("id") Integer id, ModelAndView modelAndView) {
        Optional employee = employeeRepository.findById(id);
        modelAndView.addObject(employee);
        modelAndView.addObject("levels", Level.values());
        return modelAndView;
    }
    @PutMapping("/users/{id}")
    public String editUser(@PathVariable("id") Long id,
                           @ModelAttribute("user") User user) {
        List<Authority> userAuthorities = user.getAuthorities();
        userAuthorities.removeIf(auth -> !auth.isChecked());

        user.setId(id);
        userService.update(user);

        return "redirect:/admin/users";
    }*/
}
