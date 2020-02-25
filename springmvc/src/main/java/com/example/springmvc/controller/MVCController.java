package com.example.springmvc.controller;

import com.example.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MVCController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute User usr){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-data");
        mv.addObject("",usr);
        return mv;
    }

    @RequestMapping("/add")
    public String add(Model model){
        User user=new User();
        user.setMail("adi08u@gmail.com");
        user.setName("aditya");
        model.addAttribute("usr",user);
        return "mydetails";
    }
}
