package ru.wain.exploration.auth.token;

public interface TokenService {
    boolean checkToken(String token);
}
