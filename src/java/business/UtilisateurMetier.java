/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.IUtilisateurDAO;
import entite.Utilisateur;
import java.util.List;

/**
 *
 * @author Damien
 */
public class UtilisateurMetier implements IUtilisateurMetier{

    IUtilisateurDAO utilisateurDAO;
    
    public void setUtilisateurDAO(IUtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}
    @Override
    public void save(Utilisateur u) {
        utilisateurDAO.save(u);
    }

    @Override
    public void update(Utilisateur u) {
        utilisateurDAO.update(u);
    }

    @Override
    public void delete(Utilisateur u) {
        utilisateurDAO.delete(u);
    }

    @Override
    public Utilisateur findByUtilisateurId(String utilId) {
        return utilisateurDAO.findByUtilisateurId(utilId);
    }

    @Override
    public List findAll() {
        return utilisateurDAO.findAll();
    }

    @Override
    public List findUtilisateursRange(int startId, int endId) {
        return utilisateurDAO.findUtilisateursRange(startId, endId);
    }

    @Override
    public int getNbUtilisateurs() {
        return utilisateurDAO.getNbUtilisateurs();
    }

    @Override
    public int getLastIndex() {
        return utilisateurDAO.getLastIndex();
    }
    
}
