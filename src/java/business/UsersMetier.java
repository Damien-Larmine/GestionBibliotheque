/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.IUsersDAO;
import entite.Users;
/**
 *
 * @author Damien
 */
public class UsersMetier implements IUsersMetier{

	
	IUsersDAO usersDao;
	
	public void setUsersDAO(IUsersDAO usersDAO) {
		this.usersDao = usersDao;
	}

        public IUsersDAO getUsersDAO(){
        return this.usersDao;
        }
        
        @Override
	public void save(Users u){
		usersDao.save(u);
	}
	
        @Override
	public void update(Users u){
		usersDao.update(u);
	}
	
        @Override
	public void delete(Users u){
		usersDao.delete(u);
	}
	
        @Override
	public Users findByUserUsername(String username){
		return usersDao.findByUserUsername(username);
	}
        
}
