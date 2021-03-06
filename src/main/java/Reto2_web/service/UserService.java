/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_web.service;

import Reto2_web.model.User;
import Reto2_web.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CarlosSacristan
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

   public User getUserById(int id){
        Optional<User> userOpt = userRepository.getUserById(id);
        if(userOpt.isPresent()){
            return userOpt.get();
        }
        return null;
    }
    public User create(User user) {
        if (user.getId() == null) {
            return userRepository.create(user);
        } else {
            Optional<User> e = userRepository.getUserById(user.getId());
            if (e.isPresent()) {
                  return user;
                    } else {
                return userRepository.create(user);
                /**
                if (emailExists(user.getEmail()) == false) {
                    return userRepository.create(user);
                } else {
                    return user;
                }
                *  } else {
                return user;
                * */
           
            }
        }
    }

    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getUserById(user.getId());
            if (userDb.isPresent()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                 if (user.getType() != null) {
                    userDb.get().setType(user.getType());
                }

                userRepository.create(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    
     public void delete(Integer id) {
        Optional<User> userOpt = userRepository.getUserById(id);
        if (userOpt.isPresent()) {
            userRepository.delete(userOpt.get());
        }
    }
    /**
    public boolean delete(Integer userId) {
        Boolean aBoolean = getUserById(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
**/
    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    public User authenticateUser(String email, String password) {
        Optional<User> usuario = userRepository.authenticateUser(email, password);
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            User u = new User();
            /**
            u.setName("NOT DEFINED");
            u.setEmail(email);
            u.setPassword(password);
            * **/
            return u;
        }

    }
}
