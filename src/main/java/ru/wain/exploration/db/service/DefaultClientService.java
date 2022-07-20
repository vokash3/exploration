package ru.wain.exploration.db.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import ru.wain.exploration.db.entities.ClientEntity;
import ru.wain.exploration.db.repo.ClientRepository;

import javax.security.auth.login.LoginException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultClientService implements ClientService{

    private final ClientRepository userRepository;

    @SneakyThrows
    @Override
    public void register(String clientId, String clientSecret) {
        if(userRepository.findById(clientId).isPresent())
            throw new RegistrationException("Client with id: " + clientId + " already registered");

        String hash = BCrypt.hashpw(clientSecret, BCrypt.gensalt());
        userRepository.save(new ClientEntity(clientId, hash));
    }

    @SneakyThrows
    @Override
    public void checkCredentials(String clientId, String clientSecret) {
        Optional<ClientEntity> optionalUserEntity = userRepository.findById(clientId);
        if(optionalUserEntity == null)
            throw new LoginException("Client with id: " + clientId + " not found");

        ClientEntity clientEntity = optionalUserEntity.get();

        if(!BCrypt.checkpw(clientSecret, clientEntity.getHash()))
            throw new LoginException("Secret is incorrect");
    }

    private class RegistrationException extends Throwable {
        public RegistrationException(String s) {
            super(s);
        }
    }

    private class LoginException extends Throwable {
        public LoginException(String s) {
            super(s);
        }
    }
}
