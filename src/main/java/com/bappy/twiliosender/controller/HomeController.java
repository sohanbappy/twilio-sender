package com.bappy.twiliosender.controller;

import com.bappy.twiliosender.service.TwilioSmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    TwilioSmsSender smsSender;

    @RequestMapping(value="/",method= RequestMethod.GET)
    public String index() {
        return "redirect:/login";
    }

    @RequestMapping(value="/home",method= RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value="/error",method=RequestMethod.GET)
    public String error() {
        return "error";
    }

    @RequestMapping(value="/sendMessage",method=RequestMethod.POST)
    public String sendMessage(Model model, @RequestParam("message") String message, @RequestParam("phone") String phone) {

        if(StringUtils.isEmpty(message) || StringUtils.isEmpty(phone)){
            model.addAttribute("msg","Error Occurred!!!!!!!");
            return "error";
        }
        else{
            try{
            //sending
              smsSender.sendSms(message,phone);
              model.addAttribute("msg","Sent Message Successfully!!!!!!!");
              return "home";
            }catch (Exception e){
                e.printStackTrace();
                model.addAttribute("msg","Message Not Sent!!!!!!!");
                return "error";
            }
        }

    }
}
