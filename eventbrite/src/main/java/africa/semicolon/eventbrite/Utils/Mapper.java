package africa.semicolon.eventbrite.Utils;

import africa.semicolon.eventbrite.data.models.User;
import africa.semicolon.eventbrite.dto.requests.RegisterUserRequest;
import africa.semicolon.eventbrite.dto.responses.RegisterUserResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {

    public static void map(RegisterUserRequest request, User user) {
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
    }
    public static void map(User savedUser, RegisterUserResponse response) {
        response.setEmail(savedUser.getEmail());
        response.setDateCreated(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy, hh:mm, a")
                .format(savedUser.getDateTime()));
    }
}
