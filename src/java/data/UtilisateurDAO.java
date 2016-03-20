/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entite.Utilisateur;
import java.util.Iterator;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Damien
 */
public class UtilisateurDAO extends HibernateDaoSupport implements IUtilisateurDAO{

    public void save(Utilisateur u) {
        getHibernateTemplate().save(u);
    }

    public void update(Utilisateur u) {
        getHibernateTemplate().update(u);
    }
    
    public void delete(Utilisateur u) {
        getHibernateTemplate().delete(u);
    }

    public Utilisateur findByUtilisateurId(String utilId) {
        List list = getHibernateTemplate().find(
                      "from Utilisateur u where u.idUtilisateur=?",utilId
                );
		return (Utilisateur)list.get(0);
    }
    
    @Override
    public List findAll(){
        List utilList = getHibernateTemplate().find("from Utilisateur");
        return utilList;
    }
    
    @Override
    public List findUtilisateursRange(int startId, int endId) {
        List<Utilisateur> utilList = getHibernateTemplate().find("from Utilisateur as util where util.idUtilisateur between '"+startId+"' and '"+endId+"'");
        return utilList;
    }
    
    public int getNbUtilisateurs(){
        int res = getHibernateTemplate().find("from Utilisateur").size();
        return res;
    }

    @Override
    public int getLastIndex() {
        List l = getHibernateTemplate().find("from Utilisateur");
        int index = 0;
        for(Iterator it = l.iterator(); it.hasNext();){
            Utilisateur u = (Utilisateur) it.next();
            index = u.getIdUtilisateur();
        }
        return index;
    }
}
