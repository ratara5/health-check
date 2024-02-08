package org.health.healthcheck.domain.repository;

import org.health.healthcheck.domain.User;
import org.health.healthcheck.persistence.entity.UserProjection;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> getAll();
    //To calculate methods
    /*Optional<List<User>> getByCategory(int categoryId);*/
    Optional<User> getUser(int productId);
    User save(User user);
    void delete(int userId);

    UserProjection getImc(int userId);

    UserProjection getCurrentAge(int userId);
}
