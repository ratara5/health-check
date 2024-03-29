package org.health.healthcheck.domain.service;


import org.health.healthcheck.domain.User;
import org.health.healthcheck.domain.repository.UserRepository;
import org.health.healthcheck.persistence.entity.UserProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    public User save(User user){
        return userRepository.save(user);
    }

    public boolean delete(int userId){
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

    public User update(int userId, User user) {

        return getUser(userId).map(existingUser -> {
            if(!Objects.equals(user.getTypeId(), null)){
                existingUser.setTypeId(user.getTypeId());
            }
            if(!Objects.equals(user.getName(), null)) {
                existingUser.setName(user.getName());
            }
            if(!Objects.equals(user.getBirthDate(), null)) {
                existingUser.setBirthDate(user.getBirthDate());
            }
            if(!Objects.equals(user.getWeight(), 0.0f)) {
                existingUser.setWeight(user.getWeight());
            }
            if(!Objects.equals(user.getHeight(), null)) {
                existingUser.setHeight(user.getHeight());
            }

            return userRepository.save(existingUser);
        }).orElse(null);

    }
}
