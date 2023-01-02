package com.salvai.user.controller.implementation;

import com.salvai.user.controller.specification.IUserController;
import com.salvai.user.model.client.UserRequest;
import com.salvai.user.model.domain.User;
import com.salvai.user.service.specification.IUserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController implements IUserController {

    @NonNull
    private IUserService userService;

    @Override
    public ResponseEntity<Void> addUser(@RequestBody UserRequest userRequest){
        log.info("New user registration {}", userRequest);
        var newUser = userService.addUser(userRequest);
        return ResponseEntity.created(getUserUriById(newUser.getId())).build();
    }

    @Override
    public ResponseEntity<User> getUser(@PathVariable Long userId){
        log.info("Retrieving user by id {}", userId);
        var user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    private URI getUserUriById(Long id) {
        try {
            return new URI("http://localhost:8080/api/v1/users/" + id);
        } catch (URISyntaxException e) {
            throw new ResponseStatusException(HttpStatus.CREATED, id.toString());
        }
    }
}
