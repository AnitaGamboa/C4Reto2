/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_web.repository;

import Reto2_web.interfaces.UserInterface;
import Reto2_web.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CarlosSacristan
 */
@Repository
public class UserRepository {
    
    @Autowired
    private UserInterface userCrudInterface;

 /**
 *metodo traer datos
     * @return 
 * @
 */
    public List<User> getAll() {
        return (List<User>) userCrudInterface.findAll();

    }
 /**
 *metodo leer usuario
     * @param id
     * @return 
 * @
 */
    public Optional<User> getUser(int id) {
        return userCrudInterface.findById(id);
    }
 /**
 *metodo crear
     * @param user
     * @return 
 * @
 */
    public User create(User user) {
        return userCrudInterface.save(user);
    }
 /**
 *metodo actualizar
     * @param user
 * @
 */
    public void update(User user) {
        userCrudInterface.save(user);
    }
 /**
 *metodo borrar
     * @param user
 * @
 */    
    public void delete(User user) {
        userCrudInterface.delete(user);
    }
 /**
 *metodo autenticar email
     * @param email
     * @return 
 * @
 */
  
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudInterface.findByEmail(email);
        
        return usuario.isPresent();
    }
 /**
 *metodo para autenticar usuario
     * @param email
     * @param password
     * @return 
 * @
 */    
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudInterface.findByEmailAndPassword(email, password);
    }
     
}
