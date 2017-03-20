package friendsofmine.controller;

import friendsofmine.Bootstrap;
import friendsofmine.domain.Activite;
import friendsofmine.domain.Inscription;
import friendsofmine.domain.Utilisateur;
import friendsofmine.service.ActiviteService;
import friendsofmine.service.InscriptionService;
import friendsofmine.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by valen on 16/03/2017.
 */
@RestController
@RequestMapping("/api/inscription")
public class InscriptionController {

    @Autowired
    private Bootstrap bootstrap;

    @Autowired
    private InscriptionService inscriptionService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private ActiviteService activiteService;

    @RequestMapping("/{id}")
    public Inscription getInscription(@PathVariable Long id){
        Inscription inscription = inscriptionService.findOneInscription(id);
        if(inscription == null){
            throw new ResourceNotFoundException();
        }
        return inscription;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Inscription> storeInscription(@RequestParam("utilisateur_id") Long utilisateur_id,
                                                        @RequestParam("activite_id") Long activite_id){
        Utilisateur utilisateur = utilisateurService.findOneUtilisateur(utilisateur_id);
        Activite activite = activiteService.findOneActivite(activite_id);
        if(utilisateur == null || activite == null){
            throw new ResourceNotFoundException();
        }
        Inscription inscription = inscriptionService.saveInscription(new Inscription(utilisateur, activite, null));
        return new ResponseEntity<Inscription>(inscription, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteInscription(@PathVariable Long id){
        Inscription inscription = inscriptionService.findOneInscription(id);
        if(inscription == null){
            throw new ResourceNotFoundException();
        }
        inscriptionService.deleteInscription(inscription);
        return HttpStatus.OK;
    }

    @RequestMapping("/search")
    public Page<Inscription> search(@RequestParam(value = "nom_utilisateur", required = false) String nom,
                                    @RequestParam(value = "titre_activite", required = false) String titre,
                                    Pageable pageable){
        if(nom != null && titre != null)
            return inscriptionService.findByUtilisateurActivite(nom, titre, pageable);
        else if(nom != null)
            return inscriptionService.findByUtilisateur(nom, pageable);
        else if(titre != null)
            return inscriptionService.findByActivite(titre, pageable);
        return inscriptionService.findAll(pageable);
    }

}
