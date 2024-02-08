package org.health.healthcheck.web.controller;


import org.health.healthcheck.domain.User;
import org.health.healthcheck.domain.service.UserService;
import org.health.healthcheck.persistence.entity.UserProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int userId){

        Optional<User> user = userService.getUser(userId);

        //to calculate imc
        UserProjection userProjection1 = userService.getImc(userId);
        float imcUser= userProjection1.getImc();
        user.ifPresent(u->u.setImc(imcUser));

        //to calculate current age
        UserProjection userProjection2 = userService.getCurrentAge(userId);
        String currentAge= userProjection2.getCurrentAge();
        user.ifPresent(u->u.setCurrentAge(currentAge));

        return user
                .map(u->new ResponseEntity<>(u, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user){

        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int userId){
        if(userService.delete(userId)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
