/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entite.Livre;
import java.util.List;

/**
 *
 * @author Damien
 */
public interface ILivreDAO {
    void save(Livre l);
    void update(Livre l);
    void delete(Livre l);
    Livre findByLivreId(String livreId);
    public List findAll();
    public List findLivresRange(int startId, int endId);
    public int getNbLivres();
    public int getLastIndex();
}
