/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entite.Utilisateur;
import java.util.List;

/**
 *
 * @author Damien
 */
public interface IUtilisateurMetier {
    void save(Utilisateur u);
    void update(Utilisateur u);
    void delete(Utilisateur u);
    Utilisateur findByUtilisateurId(String utilId);
    public List findAll();
    public List findUtilisateursRange(int startId, int endId);
    public int getNbUtilisateurs();
    public int getLastIndex();
}
