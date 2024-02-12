package org.health.healthcheck.web.controller;


import org.health.healthcheck.domain.User;
import org.health.healthcheck.domain.service.MeasureService;
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

    @GetMapping("/{type}-{id}")
    public ResponseEntity<User> getUser(@PathVariable("type") String typeId, @PathVariable("id") String userId){

        Optional<User> user = userService.getUser(typeId, userId);

        //to calculate current age
        UserProjection userProjection2 = userService.getCurrentAge(typeId, userId);
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

    @DeleteMapping("/delete/{type}-{id}")
    public ResponseEntity delete(@PathVariable("type") String typeId, @PathVariable("id") String userId){
        if(userService.delete(typeId, userId)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/update/{type}-{id}")
    public ResponseEntity updateUser(@PathVariable("type") String typeId,
                                     @PathVariable("id") String userId,
                                     @RequestBody User user){
        User updatedUser = userService.update(typeId, userId, user);
        if(updatedUser != null){
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}