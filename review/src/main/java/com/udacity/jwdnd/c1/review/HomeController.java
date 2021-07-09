package com.udacity.jwdnd.c1.review;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@Controller
public class HomeController {

    private MessageListService messageListService;

    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping("/home")
    @ResponseBody
    public String getHomePage(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
        model.addAttribute("greetings", this.messageListService.getMessages());
        return "home";
    }

    @PostMapping("/home")
    public String addMessage(@ModelAttribute("newMessage") MessageForm messageForm, Model model) {
        messageListService.addMessage(messageForm.getText());
        model.addAttribute("greetings", messageListService.getMessages());
        messageForm.setText("");
        return "home";
    }

}
