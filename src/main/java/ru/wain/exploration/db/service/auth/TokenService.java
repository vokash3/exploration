package ru.wain.exploration.db.service.auth;

public interface TokenService {
    String generateToken(String clientId);
}

