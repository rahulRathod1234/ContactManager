package com.SmartContactManager.ContactManager.controller;


import com.SmartContactManager.ContactManager.Entities.User;
import com.SmartContactManager.ContactManager.smart.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController
{
   // @Autowired
    //private UserRepository userRepository;
    @RequestMapping("/index")
    public String dashboard(Model model, Principal principal)
    {
        String userName = principal.getName();
        System.out.println("USERNAME"+userName);

   // User user = userRepository.getUserByUserName(userName);
    //    System.out.println("USER:"+user);

        return "user_dashboard";
    }

}
