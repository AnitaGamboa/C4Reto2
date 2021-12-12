/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_web.interfaces;

import Reto2_web.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author CarlosSacristan
 */
public interface UserInterface extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);
@Query(" {id: ?0} ")
    Optional<User> findById(int id);

    Optional<User> findByEmailAndPassword(String email, String password);

}
