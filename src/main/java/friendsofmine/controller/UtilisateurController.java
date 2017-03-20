package friendsofmine.controller;

import friendsofmine.Bootstrap;
import friendsofmine.domain.Activite;
import friendsofmine.domain.Utilisateur;
import friendsofmine.service.ActiviteService;
import friendsofmine.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by valen on 27/02/2017.
 */
@Controller
public class UtilisateurController {

    @Autowired
    private Bootstrap bootstrap;

    @Autowired
    private UtilisateurService utilisateurService;

    @RequestMapping("/utilisateurs")
    public String list(Model model, @RequestParam(value = "sexe", required = false) String sexe){
        Iterable<Utilisateur> utilisateurList;
        if(sexe != null){
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setGenre(sexe);
            utilisateurList = utilisateurService.findByExample(utilisateur);
        }else{
            utilisateurList = bootstrap.getUtilisateurs();
        }
        model.addAttribute("utilisateurs", utilisateurList);
        return "utilisateurs";
    }

    @RequestMapping("/utilisateur/{id}")
    public String getUtilisateur(@PathVariable int id, Model model){
        Utilisateur utilisateur = utilisateurService.findOneUtilisateur(id);
        if(utilisateur != null){
            Set<Activite> activites = utilisateur.getActivites();
            model.addAttribute("utilisateur", utilisateur);
            model.addAttribute("activites", activites);
            return "utilisateurShow";
        }else{
            return "error";
        }
    }

    @RequestMapping("/utilisateur/new")
    public String newUtilisateur(Utilisateur utilisateur){
        return "utilisateurForm";
    }

    @RequestMapping(value = "/utilisateur", method = RequestMethod.POST)
    public String storeUtilisateur(@Valid Utilisateur utilisateur, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "utilisateurForm";
        }
        utilisateur = utilisateurService.saveUtilisateur(utilisateur);
        return "redirect:/utilisateur/" + utilisateur.getId();
    }

    @RequestMapping("/utilisateur/edit/{id}")
    public String editUtilisateur(@PathVariable int id, Model model){
        Utilisateur utilisateur = utilisateurService.findOneUtilisateur(id);
        if(utilisateur != null){
            model.addAttribute("utilisateur", utilisateur);
            return "utilisateurForm";
        }else{
            return "error";
        }
    }

    @RequestMapping(value = "/utilisateur", method = RequestMethod.PUT)
    public String updateUtilisateur(@Valid Utilisateur utilisateur, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "utilisateurForm";
        }
        utilisateur = utilisateurService.saveUtilisateur(utilisateur);
        return "redirect:/utilisateur/" + utilisateur.getId();
    }

    @RequestMapping("/utilisateur/delete/{id}")
    public String deleteUtilisateur(@PathVariable int id, Model model){
        Utilisateur utilisateur = utilisateurService.findOneUtilisateur(id);
        if(utilisateur == null || utilisateur.getActivites().size() > 0){
            model.addAttribute("message", "Impossible. L'utilisateur est responsable d'activités");
            return "error";
        }
        utilisateurService.deleteUtilisateur(utilisateur);
        return "redirect:/utilisateurs";
    }

}
