package org.khrip.lab1.contoller;

import org.khrip.lab1.DAO.ContainerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/container")
public class ContainerController {
    private ContainerDAO containerDAO;

@Autowired
    public ContainerController(ContainerDAO containerDAO) {
        this.containerDAO = containerDAO;
    }


    @GetMapping()
    public String showPage()
    {
        return "container/showPage";
    }

    @GetMapping("/result")
    public String resultPage(Model model)
    {
        model.addAttribute("number", containerDAO.show());
        return "container/resultPage";
    }

    @PostMapping()
    public String change(@RequestParam(value = "add", required = false) String add, @RequestParam(value = "delete", required = false) String del){
        if(add!=null) {
            containerDAO.add(Integer.valueOf(add));
        }
        if(del!=null) {
            containerDAO.delete(Integer.valueOf(del));
        }
    containerDAO.show1();
    return "container/showPage";
    }

}
