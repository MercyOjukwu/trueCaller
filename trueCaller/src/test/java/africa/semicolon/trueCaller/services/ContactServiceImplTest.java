package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImplTest {

    private ContactService contactService;
    private ContactRepository contactRepository;

    @BeforeEach public void setUp(){
        contactRepository = new ContactRepositoryImpl();
        contactService = new ContactServiceImpl(contactRepository);
    }

    @Test public void saveContact_findContactReturnsContact(){
        contactService.addContact("Mary", "John", "012345");
        Contact contact = contactService.findById(1);

        assertEquals("Mary", contact.getFirstName());

    }

}