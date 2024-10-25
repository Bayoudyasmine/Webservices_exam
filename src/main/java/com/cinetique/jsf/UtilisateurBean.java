package com.cinetique.jsf;

import com.cinetique.ejb.IUtilisateurService;
import com.cinetique.model.CD;
import com.cinetique.model.Emprunt;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class UtilisateurBean {
    @EJB
    private IUtilisateurService utilisateurService;

    private String utilisateur;

    public List<CD> getCdDisponibles() {
        return utilisateurService.listerCDDisponibles();
    }

    public void emprunterCD(Long cdId) {
        utilisateurService.emprunterCD(cdId, utilisateur);
    }

    public List<Emprunt> getCdEmpruntes() {
        return utilisateurService.voirCDsEmpruntes(utilisateur);
    }

    public void retournerCD(Long cdId) {
        utilisateurService.retournerCD(cdId);
    }

    // Getters et Setters pour utilisateur
    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }
}
