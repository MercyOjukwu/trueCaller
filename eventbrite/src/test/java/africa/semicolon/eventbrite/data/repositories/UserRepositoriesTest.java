package africa.semicolon.eventbrite.data.repositories;

import africa.semicolon.eventbrite.data.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;



//@DataMongoTest
class UserRepositoriesTest{
    @Autowired
    private UserRepositories userRepositories;

    @Test
    public void saveTest(){
        User user = new User();
        user.setFirstName("Mary");
        userRepositories.save(user);
        assertEquals(1, userRepositories.count());
    }

}
