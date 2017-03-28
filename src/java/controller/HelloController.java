package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import domain.HelloService;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;
    
    @RequestMapping(value= {"/hello"}, method = RequestMethod.GET)
    public String showHomePage(Model model) {
        model.addAttribute("name", new Name());
        return "nameForm";
    }
    

    
    @RequestMapping(value= {"/hello"}, method = RequestMethod.POST)
    public String onSubmit(
             @ModelAttribute Name name, Model model) {

        model.addAttribute("helloMessage",
                helloService.sayHello(name.getValue()));
        return "helloView";
    }
    
    
}