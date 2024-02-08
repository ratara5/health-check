package org.health.healthcheck.persistence;


import org.health.healthcheck.domain.User;
import org.health.healthcheck.domain.repository.UserRepository;
import org.health.healthcheck.persistence.crud.UsuarioCrudRepository;
import org.health.healthcheck.persistence.entity.UserProjection;
import org.health.healthcheck.persistence.entity.Usuario;
import org.health.healthcheck.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> getAll(){
        List<Usuario> usuarios = (List<Usuario>) usuarioCrudRepository.findAll();
        return mapper.toUsers(usuarios);
    }

    @Override
    public Optional<User> getUser(int userId) {
        return usuarioCrudRepository.findById(userId).map(usuario -> mapper.toUser(usuario));
    }

    @Override
    public User save(User user) {
        Usuario usuario = mapper.toUsuario(user);
        return mapper.toUser(usuarioCrudRepository.save(usuario));
    }

    @Override
    public void delete(int userId){
        usuarioCrudRepository.deleteById(userId);
    }

    @Override
    public UserProjection getImc(int userId) {
        return usuarioCrudRepository.getImc(userId);
    }

    @Override
    public UserProjection getCurrentAge(int userId) {
        return usuarioCrudRepository.getCurrentAge(userId);
    }

}
