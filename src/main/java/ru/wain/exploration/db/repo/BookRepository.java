package ru.wain.exploration.db.repo;

import org.springframework.data.repository.CrudRepository;
import ru.wain.exploration.db.entities.BookEntity;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
}
