package com.infoeste.codecash.dto;

public record CreateUserInput(
        String name,
        String email,
        String document,
        String password
) {
}
