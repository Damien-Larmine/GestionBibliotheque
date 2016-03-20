/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entite.Authorities;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Damien
 */
public class AuthoritiesDAO extends HibernateDaoSupport implements IAuthoritiesDAO{
 
    public void save(Authorities a) {
        getHibernateTemplate().save(a);
    }

    public void update(Authorities a) {
    getHibernateTemplate().update(a);
    }

    public void delete(Authorities a) {
        getHibernateTemplate().delete(a);
    }

    public Authorities findAuthorityByUsername(String username) {
        List list = getHibernateTemplate().find(
                      "from Authorities whereusername=?",username
                );
		return (Authorities)list.get(0);
    }

    
    public List findAll() {
        List empList = getHibernateTemplate().find("from Authorities");
        return empList;
    }
    
}
