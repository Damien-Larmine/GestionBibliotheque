/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entite.Emprunt;
/**
 *
 * @author Damien
 */
public interface IEmpruntMetier {
	
	void save(Emprunt emp);
	void update(Emprunt emp);
	void delete(Emprunt emp);
	Emprunt findByEmpruntId(String empruntId);
}
