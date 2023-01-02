package com.salvai.user.controller.specification;

import com.salvai.user.model.client.UserRequest;
import com.salvai.user.model.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1/users")
public interface IUserController {

    @PostMapping
    ResponseEntity<Void> addUser(@RequestBody UserRequest userRequest);

    @GetMapping("/{userId}")
    ResponseEntity<User> getUser(@PathVariable Long userId);
}
