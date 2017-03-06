package friendsofmine.controller;

import friendsofmine.Bootstrap;
import friendsofmine.domain.Activite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by valen on 27/02/2017.
 */
@Controller
public class ActiviteController {

    @Autowired
    private Bootstrap bootstrap;

    @RequestMapping("/activites")
    public String list(Model model){
        List<Activite> activiteList = bootstrap.getActivites();
        model.addAttribute("activites", activiteList);
        return "activites";
    }

}
