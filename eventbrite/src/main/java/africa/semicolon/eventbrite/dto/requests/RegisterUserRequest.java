package africa.semicolon.eventbrite.dto.requests;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserRequest {

    private String password;
    private String firstName;
    private String lastName;
    private String email;


}
