/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entite.Utilisateur;
import java.util.List;
import business.IUtilisateurMetier;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Damien
 */
@ManagedBean
@SessionScoped
public class UtilisateurBean implements java.io.Serializable{
    private int idDep;
    private int idFin;
    private DataModel listeUtilisateurs = null;
    private Utilisateur utilisateur;
    private IUtilisateurMetier utilisateurMetier;
    
    private int utilSel;
    
    private int compteur;
    private int taillePage = 10;

    public UtilisateurBean() {
        super();
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        utilisateurMetier = (IUtilisateurMetier)appContext.getBean("utilisateurMetier");
        
        this.idDep = 0;
        this.idFin = taillePage;
        
        this.compteur = utilisateurMetier.getNbUtilisateurs();
    }

    public DataModel getListeUtilisateurs() {
        if (listeUtilisateurs == null) {
           listeUtilisateurs = new ListDataModel(utilisateurMetier.findUtilisateursRange(idDep, idFin)); 
        }
        return listeUtilisateurs;
    }

    public void setListeUtilisateurs(DataModel listeUtilisateurs) {
        this.listeUtilisateurs = listeUtilisateurs;
    }

    public Utilisateur getUtilisateur() {
        if(utilisateur == null){
            utilisateur = new Utilisateur();
            utilSel = -1;
        }
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public IUtilisateurMetier getUtilisateurMetier() {
        return utilisateurMetier;
    }

    public void setUtilisateurMetier(IUtilisateurMetier livreMetier) {
        this.utilisateurMetier = livreMetier;
    }

    public int getIdDep() {
        return idDep;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    public int getIdFin() {
        return idFin;
    }

    public void setIdFin(int idFin) {
        this.idFin = idFin;
    }

    public int getUtilSel() {
        return utilSel;
    }

    public void setUtilSel(int utilSel) {
        this.utilSel = utilSel;
    }

    public int getCompteur() {
        return compteur;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }

    public int getTaillePage() {
        return taillePage;
    }

    public void setTaillePage(int taillePage) {
        this.taillePage = taillePage;
    }
   
    public String selecUtil(){
        utilisateur = (Utilisateur) getListeUtilisateurs().getRowData();
        return "browseutil";
    }
    
    public boolean isHasNextPage() {
        return idFin + taillePage <= compteur;
    }

    public boolean isHasPreviousPage() {
        return idDep - taillePage > 0;
    }

    public String next() {
        idDep = idFin+1;
        idFin = idFin + taillePage;
        recreateModel();
        return "utilisateurs";
    }

    public String previous() {
        idDep = idDep - taillePage;
        idFin = idFin - taillePage;
        recreateModel();
        return "utilisateurs";
    }
    
    public void recreateModel(){
        listeUtilisateurs = null;
    }
    
     public String prepareList(){
        recreateModel();
        return "utilisateurs";
    }
     
     public String createUtilisateur(){
         this.utilisateur.setIdUtilisateur(utilisateurMetier.getLastIndex()+1);
         utilisateurMetier.save(this.utilisateur);
         recreateModel();
         return"utilisateurs";
     }
     
     public String updateUtilisateur(){
        utilisateurMetier.update(this.utilisateur);
        recreateModel();
        return "listeLivres";
     }
     
     public String deleteUtilisateur(){
         utilisateurMetier.delete(this.utilisateur);
         recreateModel();
         return "listeLivres";
     }
}
