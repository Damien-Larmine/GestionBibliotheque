/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entite.Emprunt;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Damien
 */
public class EmpruntDAO extends HibernateDaoSupport implements IEmpruntDAO{
 
    public void save(Emprunt emp) {
        getHibernateTemplate().save(emp);
    }

    public void update(Emprunt emp) {
    getHibernateTemplate().update(emp);
    }

    public void delete(Emprunt emp) {
        getHibernateTemplate().delete(emp);
    }

    public Emprunt findByEmpruntId(String empruntId) {
        List list = getHibernateTemplate().find(
                      "from Emprunt where idEmprunt=?",empruntId
                );
		return (Emprunt)list.get(0);
    }

    
    public List findAll() {
        List empList = getHibernateTemplate().find("from Emprunt");
        return empList;
    }
    
}
