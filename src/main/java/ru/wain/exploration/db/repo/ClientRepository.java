package ru.wain.exploration.db.repo;

import org.springframework.data.repository.CrudRepository;
import ru.wain.exploration.db.entities.ClientEntity;

public interface ClientRepository extends CrudRepository<ClientEntity, String> {
}
