package africa.semicolon.eventbrite.data.repositories;

import africa.semicolon.eventbrite.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepositories extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
