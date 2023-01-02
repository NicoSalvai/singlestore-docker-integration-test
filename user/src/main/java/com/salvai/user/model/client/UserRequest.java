package com.salvai.user.model.client;

public record UserRequest(
        String firstName,
        String lastName,
        String email) {
}
