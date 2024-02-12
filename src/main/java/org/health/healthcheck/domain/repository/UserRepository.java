package org.health.healthcheck.domain.repository;


import org.health.healthcheck.domain.User;
import org.health.healthcheck.persistence.entity.UserProjection;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> getAll();
    Optional<User> getUser(String typeId, String userId);
    User save(User user);
    void delete(String typeId, String userId);

    UserProjection getCurrentAge(String typeId, String userId);

}