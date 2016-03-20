/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entite.Users;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Damien
 */
public class UsersDAO extends HibernateDaoSupport implements IUsersDAO{

    @Override
    public void save(Users u) {
        getHibernateTemplate().save(u);
    }

    @Override
    public void update(Users u) {
        getHibernateTemplate().update(u);
    }
    
    @Override
    public void delete(Users u) {
        getHibernateTemplate().save(u);
    }

    @Override
    public Users findByUserUsername(String username) {
        List list = getHibernateTemplate().find(
                      "from Users u where u.username=?",username
                );
		return (Users)list.get(0);
    }
    
}
