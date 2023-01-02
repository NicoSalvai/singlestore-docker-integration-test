package com.salvai.user.controller.implementation;

import com.salvai.user.BaseIT;
import com.salvai.user.model.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserControllerIT2 extends BaseIT {

    @Test
    @Sql({ "/schema.sql", "/users-main-user.sql" })
    public void testCreateEmployee() {

        ResponseEntity<User> response2 = testRestTemplate.getForEntity("/api/v1/users/2", User.class);

        var userResponse = response2.getBody();
        assertNotNull(userResponse.getId());
    }
}