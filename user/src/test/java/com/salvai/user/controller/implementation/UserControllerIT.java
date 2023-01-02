package com.salvai.user.controller.implementation;

import com.salvai.user.BaseIT;
import com.salvai.user.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserControllerIT extends BaseIT {

    @Test
    @Sql({ "/users-main-user.sql" })
    public void testCreateEmployee() {

        User user = new User();
        user.setFirstName("Nico");
        user.setLastName("Salvai");
        user.setEmail("nico.salvai@hotmail.com");

        var response = testRestTemplate.postForLocation( "/api/v1/users", user);

        assertNotNull(response.getPath());

        ResponseEntity<User> response2 = testRestTemplate.getForEntity(response.getPath(), User.class);

        var userResponse = response2.getBody();
        assertNotNull(userResponse.getId());
    }
}