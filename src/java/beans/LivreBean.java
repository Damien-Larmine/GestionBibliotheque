/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entite.Livre;
import business.ILivreMetier;
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
public class LivreBean implements java.io.Serializable{
    private int idDep;
    private int idFin;
    private DataModel listeLivres = null;
    private Livre livre = null;
    private ILivreMetier livreMetier;
    
    private int livreSel;
    
    private int compteur;
    private int taillePage = 10;

    public LivreBean() {
        super();
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        livreMetier = (ILivreMetier)appContext.getBean("livreMetier");
        this.idDep = 0;
        this.idFin = taillePage;
        
        this.compteur = livreMetier.getNbLivres();
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

    public DataModel getListeLivres() {
        if (listeLivres == null) {
           listeLivres = new ListDataModel(livreMetier.findLivresRange(idDep, idFin)); 
        }
        return listeLivres;
    }

    public void setListeLivres(DataModel listeLivres) {
        this.listeLivres = listeLivres;
    }

    public Livre getLivre() {
        if(livre == null){
            livre = new Livre();
            livreSel = -1;
        }
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public ILivreMetier getLivreMetier() {
        return livreMetier;
    }

    public void setLivreMetier(ILivreMetier livreMetier) {
        this.livreMetier = livreMetier;
    }

    public int getLivreSel() {
        return livreSel;
    }

    public void setLivreSel(int livreSel) {
        this.livreSel = livreSel;
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
    
    public String selecLivre(){
        this.livre = (Livre) getListeLivres().getRowData();
        return "browselivre";
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
        return "listeLivres";
    }

    public String previous() {
        idDep = idDep - taillePage;
        idFin = idFin - taillePage;
        recreateModel();
        return "listeLivres";
    }
    
    public void recreateModel(){
        listeLivres = null;
    }
    
     public String prepareList(){
        recreateModel();
        return "listeLivres";
    }
     
     public String createLivre(){
         this.livre.setIdLivre(livreMetier.getLastIndex()+1);
         livreMetier.save(this.livre);
         recreateModel();
         return"listeLivres";
     }
     
     public String updateLivre(){
        livreMetier.update(this.livre);
        recreateModel();
        return "listeLivres";
     }
     
     public String deleteLivre(){
         livreMetier.delete(this.livre);
         recreateModel();
         return "listeLivres";
     }
}
