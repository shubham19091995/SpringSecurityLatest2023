package com.springSecurity.Spring.Security.Controller;


import com.springSecurity.Spring.Security.Repo.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springSecurity.Spring.Security.Repo.customRepo;

@RestController
public class controller {

    @Autowired
    private customRepo customRepo;

    @GetMapping("/hello")
    public String get(){
        return "Hello !!";
    }

    @PostMapping("/save")
    public CustomUser post(@RequestBody CustomUser customUser){
       return customRepo.save(customUser);
    }
}
