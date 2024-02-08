package org.health.healthcheck.domain.service;


import org.health.healthcheck.domain.User;
import org.health.healthcheck.domain.repository.UserRepository;
import org.health.healthcheck.persistence.entity.UserProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public Optional<User> getUser(int userId){
        return userRepository.getUser(userId);
    }

    //to calculate imc
    /*public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }*/


    public User save(User user){
        return userRepository.save(user);
    }

    public boolean delete(int userId){
        /*getUser(userId).map(user-> {
            userRepository.delete(userId);
            return true;
        });
        return false;*/

        Optional<User> userOptional = getUser(userId);
        if (userOptional.isPresent()) {
            userRepository.delete(userId);
            return true;
        }
        return false;
    }


    public UserProjection getImc(int userId) {
        return userRepository.getImc(userId);
    }

    public UserProjection getCurrentAge(int userId) {
        return userRepository.getCurrentAge(userId);
    }
}
