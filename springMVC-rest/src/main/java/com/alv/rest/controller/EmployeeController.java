package com.alv.rest.controller;

import com.alv.rest.bean.Employee;
import com.alv.rest.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @author ：tangxin
 * @date ：Created in 2022/11/17 11:41
 * @description：
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employDao;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String index(Model model){
        Collection<Employee> all = employDao.getAll();
        model.addAttribute("employeeList",all);
        return "employee_list";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employDao.delete(id);
        return "redirect:/employee";
    }


    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employDao.save(employee);
        return "redirect:/employee";
    }


    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String getEmployeeById (@PathVariable("id") Integer id, Model model){
        Employee employee = employDao.get(id);
        model.addAttribute("employee",employee);
        return "employee_update";
    }


    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee (Employee employee){
        employDao.save(employee);
        System.out.println("id是"+ employee.getId());
        return "redirect:/employee";
    }





}
