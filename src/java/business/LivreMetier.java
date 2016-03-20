/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.ILivreDAO;
import entite.Livre;
import java.util.List;

/**
 *
 * @author Damien
 */
public class LivreMetier implements ILivreMetier {
    
    ILivreDAO livreDAO;
    
    public void setLivreDAO(ILivreDAO livreDAO) {
		this.livreDAO = livreDAO;
	}
    
    public ILivreDAO getLivreDAO(){
        return this.livreDAO;
    }
    
    public void save(Livre l) {
        livreDAO.save(l);
    }

    public void update(Livre l) {
        livreDAO.update(l);
    }

    public void delete(Livre l) {
        livreDAO.delete(l);
    }

    public Livre findByLivreId(String livreId) {
        return livreDAO.findByLivreId(livreId);
    }
    
    public List findAll(){
        return livreDAO.findAll();
    }
    
    public List findLivresRange(int startId, int endId){
        return livreDAO.findLivresRange(startId, endId);
    }
    
    public int getNbLivres(){
        return livreDAO.getNbLivres();
    }

    @Override
    public int getLastIndex() {
        return livreDAO.getLastIndex();
    }
}
