package africa.semicolon.eventbrite.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document("Users")
public class User {
    @Id
    private String id;
   private String email;
   private String lastName;
    private String firstName;
    private String password;
   private LocalDateTime dateTime = LocalDateTime.now();
}

