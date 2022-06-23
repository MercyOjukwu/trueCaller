package africa.semicolon.trueCaller;

import africa.semicolon.trueCaller.controllers.ContactController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    private static final ContactController contactController = new ContactController();

    public static void main(String... args) {
        SpringApplication.run(Main.class, args);
    }
}
