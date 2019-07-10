package com.training.platform.controllers;

import com.training.platform.entities.User;
import com.training.platform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "")
    public String index() throws Exception {
        List<User> users = userRepository.findAll();
        System.out.println("List All Users(In Console)");
        System.out.println(users);

        return "Method Get, Function: index => HTML Lists Page";
    }

    @GetMapping(value = "create")
    public String create() throws Exception {
        return "Method Create";
    }

    @PostMapping(value = "")
    public String store(@RequestParam Map<String,String> inputs) throws Exception {
        System.out.println("POST Param");
        System.out.println(inputs);

        return "param and insert";
    }

    @GetMapping(value = "/{id}")
    public String show(@PathVariable String id) throws Exception {
        Optional<User> user = userRepository.findById(Integer.parseInt(id));
        System.out.println("Find User By ID");
        System.out.println(user);

        return "Method GET, show ID: " + id;
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable String id) throws Exception {
        return "Method Get, edit ID: " + id;
    }

    @PutMapping(value = "/{id}")
    public String update(@PathVariable String id, @RequestParam Map<String,String> inputs) throws Exception {
        System.out.println("PUT Param");
        System.out.println(inputs);

        return "Method PUT, update";
    }

    @DeleteMapping(value = "/{id}")
    public String destroy(@PathVariable String id) throws Exception {
        return "Method DELETE, destroy ID: " + id;
    }
}
