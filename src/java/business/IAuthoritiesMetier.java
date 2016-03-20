/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entite.Authorities;
/**
 *
 * @author Damien
 */
public interface IAuthoritiesMetier {
	
	void save(Authorities a);
	void update(Authorities a);
	void delete(Authorities a);
	Authorities findAuthorityByUsername(String username);
}
