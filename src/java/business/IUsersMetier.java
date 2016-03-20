/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entite.Users;
/**
 *
 * @author Damien
 */
public interface IUsersMetier {
	
	void save(Users u);
	void update(Users u);
	void delete(Users u);
	Users findByUserUsername(String username);
}
