package com.ls.controller;

import com.ls.dao.DepartmentDao;
import com.ls.dao.EmployeeDao;
import com.ls.pojo.Department;
import com.ls.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @ls
 * @create 2022 -- 08 -- 25
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emps/list";
    }

    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    public String addPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emps/add";
    }

    @PostMapping("/emp")
    public String add(Employee employee) {
        employeeDao.add(employee);
        return "redirect:/emps";
    }


    @RequestMapping("/update/{id}")
    public String updatePage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("employee",employee);
//        employee.getDepartment().getId()
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emps/update";
    }

    @PostMapping("/update")
    public String update(Employee employee) {
        employeeDao.add(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
