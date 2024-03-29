package com.SmartContactManager.ContactManager.controller;

import com.SmartContactManager.ContactManager.Entities.User;
import com.SmartContactManager.ContactManager.smart.dao.UserRepository;
import com.SmartContactManager.ContactManager.smart.helper.Message;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home-Smart Contact Manager");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About-Smart Contact Manager");
        return "about";
    }

    @RequestMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("title", "Register`-Smart Contact Manager");
        model.addAttribute("user", new User());
        return "signup";
    }

    @RequestMapping(value = "/do_register", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result1, @RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,  HttpSession session) {
        {
            try {

                if (!agreement) {
                    System.out.println("you have not agreed terms and condition");
                    throw new Exception("you have not agreed terms and condition");
                }
                if (result1.hasErrors()) {
                    System.out.println("ERROR" +result1.toString());
                    model.addAttribute("user", user);
                    return "signup";
                }


                System.out.println("Agreement:" + agreement);
                System.out.println("User:" + user);
                user.setRole("ROLE_USER");
                user.setEnabled(true);

                User result = this.userRepository.save(user);
               model.addAttribute("user",new User());
                session.setAttribute("message",new Message("Successfully Registered!!","alert-success"));
                return "signup";


            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("user",user);
                session.setAttribute("message",new Message("Something Went Wrong!!"+e.getMessage(),"alert-error"));
                return "signup";
            }



        }
    }
    // handler for custom login

   @GetMapping("/signin")
    public String customLogin(Model model)
    {

        model.addAttribute("title","login page");
        return "login";
    }
}