/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entite.Users;
import java.util.List;

/**
 *
 * @author Damien
 */
public interface IUsersDAO {
    void save(Users u);
    void update(Users u);
    void delete(Users u);
    Users findByUserUsername(String username);
}
