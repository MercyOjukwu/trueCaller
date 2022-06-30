package africa.semicolon.eventbrite.services;

import africa.semicolon.eventbrite.dto.requests.RegisterUserRequest;
import africa.semicolon.eventbrite.dto.requests.UserLoginRequest;
import africa.semicolon.eventbrite.dto.responses.RegisterUserResponse;
import africa.semicolon.eventbrite.dto.responses.UserLoginResponse;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest request);
    UserLoginResponse userLogin(UserLoginRequest request);
}
