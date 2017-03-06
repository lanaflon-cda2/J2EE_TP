package friendsofmine.controller;

import friendsofmine.Bootstrap;
import friendsofmine.domain.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by valen on 27/02/2017.
 */
@Controller
public class UtilisateurController {

    @Autowired
    private Bootstrap bootstrap;

    @RequestMapping("/utilisateurs")
    public String list(Model model){
        List<Utilisateur> utilisateurList = bootstrap.getUtilisateurs();
        model.addAttribute("utilisateurs", utilisateurList);
        return "utilisateurs";
    }

}
