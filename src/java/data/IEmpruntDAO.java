/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entite.Emprunt;
import java.util.List;

/**
 *
 * @author Damien
 */
public interface IEmpruntDAO {
    void save(Emprunt emp);
    void update(Emprunt emp);
    void delete(Emprunt emp);
    Emprunt findByEmpruntId(String empruntId);
    public List findAll();
}
