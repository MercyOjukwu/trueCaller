package africa.semicolon.eventbrite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest registerUserRequest){
        try{
            var serviceResponse : RegisterUserResponse = userService.registerUser(registerUserRequest);
            ApiResponse response = new ApiResponse(true, serviceResponse);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (DuplicateEmailException ex){
            ApiResponse response = new ApiResponse()
        }
    }
}
