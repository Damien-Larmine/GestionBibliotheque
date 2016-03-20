/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.IAuthoritiesDAO;
import entite.Authorities;

/**
 *
 * @author Damien
 */
public class AuthoritiesMetier implements IAuthoritiesMetier{

    IAuthoritiesDAO authoritiesDao;
	
    public void setAuthoritiesDAO(IAuthoritiesDAO authoritiesDao) {
    	this.authoritiesDao = authoritiesDao;
    }
        
    public IAuthoritiesDAO getAuthoritiesDAO(){
        return this.authoritiesDao;
    }
    
    @Override
    public void save(Authorities a) {
        authoritiesDao.save(a);
    }

    @Override
    public void update(Authorities a) {
        authoritiesDao.update(a);
    }

    @Override
    public void delete(Authorities a) {
        authoritiesDao.delete(a);
    }

    @Override
    public Authorities findAuthorityByUsername(String username) {
        return authoritiesDao.findAuthorityByUsername(username);
    }
    
}
