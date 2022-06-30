package africa.semicolon.eventbrite.services;
import africa.semicolon.eventbrite.dto.requests.RegisterUserRequest;
import africa.semicolon.eventbrite.exceptions.EmailNotFoundException;

import africa.semicolon.eventbrite.Utils.Mapper;
import africa.semicolon.eventbrite.data.models.User;
import africa.semicolon.eventbrite.data.repositories.UserRepositories;
import africa.semicolon.eventbrite.dto.requests.UserLoginRequest;
import africa.semicolon.eventbrite.dto.responses.RegisterUserResponse;
import africa.semicolon.eventbrite.dto.responses.UserLoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepositories userRepository;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request){
        User user = new User();
        Mapper.map(request, user);

        User savedUser = userRepository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();
        Mapper.map(savedUser, response);
        return response;
    }


    @Override
    public UserLoginResponse userLogin(UserLoginRequest userLoginRequest){
        Optional<User> savedUser = userRepository.findByEmail(userLoginRequest.getEmail());
        if(savedUser.isPresent()){
            if(savedUser.get().getPassword().equals(userLoginRequest.getPassword())){
                UserLoginResponse userLoginResponse = new UserLoginResponse();
                userLoginResponse.setMessage("Welcome back "+ savedUser.get().getFirstName());
                userLoginResponse.setLastSeen(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy , hh:mm, a").format(savedUser.get().getDateTime()));
                return userLoginResponse;
            }
        }
        throw new EmailNotFoundException("Contact not found");
    }
}
