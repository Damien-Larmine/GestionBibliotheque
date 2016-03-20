/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entite.Livre;
import java.util.Iterator;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Damien
 */
public class LivreDAO extends HibernateDaoSupport implements ILivreDAO{

    @Override
    public void save(Livre l) {
        getHibernateTemplate().save(l);
    }

    @Override
    public void update(Livre l) {
        getHibernateTemplate().update(l);
    }

    @Override
    public void delete(Livre l) {
        getHibernateTemplate().delete(l);
    }

    @Override
    public Livre findByLivreId(String livreId) {
        List list = getHibernateTemplate().find(
                      "from Livre where idLivre=?",livreId
                );
		return (Livre)list.get(0);
    }
    
    @Override
    public List findAll(){
        List livList = getHibernateTemplate().find("from Livre");
        return livList;
    }

    @Override
    public List findLivresRange(int startId, int endId) {
        List<Livre> livreList = getHibernateTemplate().find("from Livre as livre where livre.idLivre between '"+startId+"' and '"+endId+"'");
        return livreList;
    }
    
    public int getNbLivres(){
        int res = getHibernateTemplate().find("from Livre").size();
        return res;
    }
    
    public int getLastIndex(){
        List l = getHibernateTemplate().find("from Livre");
        int index = 0;
        for(Iterator it = l.iterator(); it.hasNext();){
            Livre liv = (Livre) it.next();
            index = liv.getIdLivre();
        }
        return index;
    }
}
