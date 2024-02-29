package com.SmartContactManager.ContactManager;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserController
{
    @RequestMapping("/user")
    public String dashboard(){
        return "user_dashboard";
    }

}
